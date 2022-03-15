/*
 * ac-library
 * LazySegTree
 *
 * https://atcoder.github.io/ac-library/document_ja/lazysegtree.html
 *
 */
package library.util;

class LazySegTree<S, F> {

  private final int _n;
  private final int size;
  private final int log;
  private final S[] data;
  private final F[] lazy;

  private final java.util.function.BinaryOperator<S> op;
  private final S e; //単位元
  private final java.util.function.BiFunction<F, S, S> mapping;
  private final java.util.function.BinaryOperator<F> composition;
  private final F id; //恒等写像

  LazySegTree(int n, java.util.function.BinaryOperator<S> op, S e,
      java.util.function.BiFunction<F, S, S> mapping,
      java.util.function.BinaryOperator<F> composition, F id) {
    if (n < 0) {
      throw new IllegalArgumentException("Illegal size: " + n);
    }
    this._n = n;
    this.op = op;
    this.e = e;
    this.mapping = mapping;
    this.composition = composition;
    this.id = id;

    this.log = ceilPow2(_n);
    this.size = 1 << this.log;
    this.data = (S[]) new Object[this.size << 1];
    this.lazy = (F[]) new Object[this.size];
    java.util.Arrays.fill(data, e);
    java.util.Arrays.fill(lazy, id);
  }

  LazySegTree(S[] data, java.util.function.BinaryOperator<S> op, S e,
      java.util.function.BiFunction<F, S, S> mapping,
      java.util.function.BinaryOperator<F> composition, F id) {
    this(data.length, op, e, mapping, composition, id);
    System.arraycopy(data, 0, this.data, this.size, data.length);
    for (int i = this.size - 1; i >= 1; i--) {
      update(i);
    }
  }

  void set(int p, S x) {
    java.util.Objects.checkIndex(p, this._n);
    p += this.size;
    pushTo(p);
    this.data[p] = x;
    updateParent(p);
  }

  S get(int p) {
    java.util.Objects.checkIndex(p, this._n);
    p += this.size;
    pushTo(p);
    return this.data[p];
  }

  S prod(int l, int r) {
    java.util.Objects.checkFromToIndex(l, r, this._n);
    if (l == r) {
      return e;
    }

    l += this.size;
    r += this.size;
    pushTo(l, r);
    S sum_left = e, sum_right = e;
    while (l < r) {
      if ((l & 1) == 1) {
        sum_left = op.apply(sum_left, this.data[l++]);
      }
      if ((r & 1) == 1) {
        sum_right = op.apply(this.data[--r], sum_right);
      }
      l >>= 1;
      r >>= 1;
    }
    return op.apply(sum_left, sum_right);
  }

  S allProd() {
    return this.data[1];
  }

  void apply(int p, F f) {
    java.util.Objects.checkIndex(p, this._n);
    p += this.size;
    pushTo(p);
    this.data[p] = mapping.apply(f, data[p]);
    updateParent(p);
  }

  void apply(int l, int r, F f) {
    java.util.Objects.checkFromToIndex(l, r, this._n);
    if (l == r) {
      return;
    }
    l += this.size;
    r += this.size;
    pushTo(l, r);

    int l2 = l, r2 = r;
    while (l2 < r2) {
      if ((l2 & 1) == 1) {
        allApply(l2++, f);
      }
      if ((r2 & 1) == 1) {
        allApply(--r2, f);
      }
      l2 >>= 1;
      r2 >>= 1;
    }
    updateParent(l, r);
  }

  int maxRight(int l, java.util.function.Predicate<S> g) {
    if (!(0 <= l && l <= this._n)) {
      throw new IndexOutOfBoundsException(
          String.format("Index is not in [%d, %d].", l, 0, this._n));
    }
    if (!g.test(e)) {
      throw new IllegalArgumentException("Identity element must satisfy the condition.");
    }
    if (l == this._n) {
      return this._n;
    }
    l += this.size;
    pushTo(l);
    S sum = e;
    do {
      while (l % 2 == 0) {
        l >>= 1;
      }
      if (!g.test(op.apply(sum, data[l]))) {
        while (l < this.size) {
          push(l);
          l <<= 1;
          if (g.test(op.apply(sum, data[l]))) {
            sum = op.apply(sum, data[l]);
            l++;
          }
        }
        return l - this.size;
      }
      sum = op.apply(sum, data[l]);
      l++;
    } while ((l & -l) != l);
    return this._n;
  }

  int minLeft(int r, java.util.function.Predicate<S> g) {
    if (!(0 <= r && r <= this._n)) {
      throw new IndexOutOfBoundsException(
          String.format("Index %d out of bounds for length %d.", r, this._n));
    }
    if (!g.test(e)) {
      throw new IllegalArgumentException("Identity element must satisfy the condition.");
    }
    if (r == 0) {
      return 0;
    }
    r += this.size;
    pushTo(r - 1);
    S sum = e;
    do {
      r--;
      while (r > 1 && r % 2 == 1) {
        r >>= 1;
      }
      if (!g.test(op.apply(data[r], sum))) {
        while (r < this.size) {
          push(r);
          r = (r << 1) | 1;
          if (g.test(op.apply(data[r], sum))) {
            sum = op.apply(data[r], sum);
            r--;
          }
        }
        return r - size + 1;
      }
      sum = op.apply(data[r], sum);
    } while ((r & -r) != r);
    return 0;
  }

  private void update(int k) {
    this.data[k] = this.op.apply(this.data[k << 1 | 0], this.data[k << 1 | 1]);
  }

  private void updateParent(int k) {
    for (int i = 1; i <= this.log; i++) {
      update(k >> i);
    }
  }

  private void updateParent(int l, int r) {
    for (int i = 1; i <= log; i++) {
      if (((l >> i) << i) != l) {
        update(l >> i);
      }
      if (((r >> i) << i) != r) {
        update((r - 1) >> i);
      }
    }
  }

  private void allApply(int k, F f) {
    this.data[k] = mapping.apply(f, this.data[k]);
    if (k < this.size) {
      this.lazy[k] = composition.apply(f, this.lazy[k]);
    }
  }

  private void push(int k) {
    allApply(k << 1 | 0, lazy[k]);
    allApply(k << 1 | 1, lazy[k]);
    lazy[k] = id;
  }

  private void pushTo(int k) {
    for (int i = this.log; i >= 1; i--) {
      push(k >> i);
    }
  }

  private void pushTo(int l, int r) {
    for (int i = this.log; i >= 1; i--) {
      if (((l >> i) << i) != l) {
        push(l >> i);
      }
      if (((r >> i) << i) != r) {
        push((r - 1) >> i);
      }
    }
  }

  private static int ceilPow2(int n) {
    int x = 0;
    while ((1 << x) < n) {
      x++;
    }
    return x;
  }
}
