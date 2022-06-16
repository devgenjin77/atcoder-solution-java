/*
 * ac-library
 * SegTree
 * https://github.com/atcoder/ac-library/blob/master/document_ja/segtree.md
 */

package library.util;

//SegTreeライブラリ
public class SegTree<S> {

  private final int MAX;
  private final int N;
  private final java.util.function.BinaryOperator<S> op;
  private final S e;
  private final S[] data;

  public SegTree(int n, java.util.function.BinaryOperator<S> op, S e) {
    if (n < 0) {
      String errMsg = String.format("Illegal Size: %d", n);
      throw new IllegalArgumentException(errMsg);
    }
    this.MAX = n;
    int k = 1;
    while (k < n) {
      k <<= 1;
    }
    this.N = k;
    this.e = e;
    this.op = op;
    this.data = (S[]) new Object[N << 1];
    java.util.Arrays.fill(data, e);
  }

  public SegTree(S[] dat, java.util.function.BinaryOperator<S> op, S e) {
    this(dat.length, op, e);
    int l = dat.length;
    System.arraycopy(dat, 0, data, N, l);
    for (int i = N - 1; i > 0; i--) {
      data[i] = op.apply(data[i << 1 | 0], data[i << 1 | 1]);
    }
  }

  public void set(int p, S x) {
    checkIndex(p);
    data[p += N] = x;
    p >>= 1;
    while (p > 0) {
      data[p] = op.apply(data[p << 1 | 0], data[p << 1 | 1]);
      p >>= 1;
    }
  }

  public S get(int p) {
    checkIndex(p);
    return data[p + N];
  }

  public S prod(int l, int r) {
    checkFromToIndex(l, r);
    S sumLeft = e;
    S sumRight = e;
    l += N;
    r += N;
    while (l < r) {
      if ((l & 1) == 1) {
        sumLeft = op.apply(sumLeft, data[l++]);
      }
      if ((r & 1) == 1) {
        sumRight = op.apply(data[--r], sumRight);
      }
      l >>= 1;
      r >>= 1;
    }
    return op.apply(sumLeft, sumRight);
  }

  public S allProd() {
    return data[1];
  }

  public int maxRight(int l, java.util.function.Predicate<S> f) {
    if (!(l >= 0 && l <= MAX)) {
      String errMsg = String.format("Index %d out of bounds for length %d.", l, MAX);
      throw new ArrayIndexOutOfBoundsException(errMsg);
    }
    if (!f.test(e)) {
      throw new IllegalArgumentException("Identity element must satisfy the condition.");
    }
    if (l == MAX) {
      return MAX;
    }
    l += N;
    S sum = e;
    do {
      l >>= Integer.numberOfTrailingZeros(l);
      if (!f.test(op.apply(sum, data[l]))) {
        while (l < N) {
          l = l << 1;
          if (f.test(op.apply(sum, data[l]))) {
            sum = op.apply(sum, data[l]);
            l++;
          }
        }
        return l - N;
      }
      sum = op.apply(sum, data[l]);
      l++;
    } while ((l & -l) != l);
    return MAX;
  }

  public int minLeft(int r, java.util.function.Predicate<S> f) {
    if (!(r >= 0 && r <= MAX)) {
      String errMsg = String.format("Index %d out of bounds for length %d.", r, MAX);
      throw new ArrayIndexOutOfBoundsException(errMsg);
    }
    if (!f.test(e)) {
      throw new IllegalArgumentException("Identity element must satisfy the condition.");
    }
    if (r == 0) {
      return 0;
    }
    r += N;
    S sum = e;
    do {
      r--;
      while (r > 1 && (r & 1) == 1) {
        r >>= 1;
      }
      if (!f.test(op.apply(data[r], sum))) {
        while (r < N) {
          r = r << 1 | 1;
          if (f.test(op.apply(data[r], sum))) {
            sum = op.apply(data[r], sum);
            r--;
          }
        }
        return r + 1 - N;
      }
      sum = op.apply(data[r], sum);
    } while ((r & -r) != r);
    return 0;
  }

  private void checkIndex(int i) {
    if (!(i >= 0 && i < this.MAX)) {
      String msg = String.format("Index %d out of bounds for length %d", i, this.MAX);
      throw new IndexOutOfBoundsException(msg);
    }
  }

  private void checkFromToIndex(int l, int r) {
    if (l < 0 || l > r || r > this.MAX) {
      String msg = String.format("Range [%d, %d) out of bounds for length %d", l, r, this.MAX);
      throw new IndexOutOfBoundsException(msg);
    }
  }
}
