/*
 * AtCoder Library Practice Contest
 * K - Range Affine Range Sum
 * https://atcoder.jp/contests/practice2/tasks/practice2_k
 *
 * verified:
 * - https://atcoder.jp/contests/practice2/submissions/31950055
 *
 */

package contests.practice2.practice2_k;

import java.io.PrintWriter;

public class Main {

  static final Long MOD = 998244353l;

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int q = Integer.parseInt(sc.next());
    StructS[] data = new StructS[n];
    for (int i = 0; i < n; i++) {
      data[i] = new StructS(Long.parseLong(sc.next()), 1l);
    }
    //区間加算・区間和取得
    LazySegTree<StructS, StructT> lazySegTree =
        new LazySegTree<>(data, Main::op, new StructS(0l, 0l),
            Main::mapping, Main::composition, new StructT(1l, 0l));
    PrintWriter pw = new PrintWriter(System.out);
    for (int cnt = 0; cnt < q; cnt++) {
      int type = Integer.parseInt(sc.next());
      int l = Integer.parseInt(sc.next());
      int r = Integer.parseInt(sc.next());
      switch (type) {
        case 0:
          long b = Long.parseLong(sc.next());
          long c = Long.parseLong(sc.next());
          lazySegTree.apply(l, r, new StructT(b, c));
          break;
        case 1:
          pw.println(lazySegTree.prod(l, r).sum);
          break;
        default:
          break;
      }
    }
    pw.close();
    sc.close();
  }

  static class StructS {

    long sum;
    long len;

    StructS(long sum, long len) {
      this.sum = sum;
      this.len = len;
    }
  }

  static class StructT {

    long val1;
    long val2;

    StructT(long val1, long val2) {
      this.val1 = val1;
      this.val2 = val2;
    }
  }

  static StructS op(StructS s1, StructS s2) {
    return new StructS((s1.sum + s2.sum) % MOD, s1.len + s2.len);
  }

  static StructS mapping(StructT f, StructS s) {
    return new StructS(((f.val1 * s.sum) + (f.val2 * s.len)) % MOD, s.len);
  }

  static StructT composition(StructT f1, StructT f2) {
    return new StructT((f1.val1 * f2.val1) % MOD, ((f1.val1 * f2.val2) + f1.val2) % MOD);
  }


  static class LazySegTree<S, F> {

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
      checkIndex(p);
      p += this.size;
      pushTo(p);
      this.data[p] = x;
      updateParent(p);
    }

    S get(int p) {
      checkIndex(p);
      p += this.size;
      pushTo(p);
      return this.data[p];
    }

    S prod(int l, int r) {
      checkFromToIndex(l, r);
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
      checkIndex(p);
      p += this.size;
      pushTo(p);
      this.data[p] = mapping.apply(f, data[p]);
      updateParent(p);
    }

    void apply(int l, int r, F f) {
      checkFromToIndex(l, r);
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

    void checkIndex(int i) {
      if (!(i >= 0 && i < this._n)) {
        String msg = String.format("Index %d out of bounds for length %d", i, this._n);
        throw new IndexOutOfBoundsException(msg);
      }
    }

    void checkFromToIndex(int l, int r) {
      if (l < 0 || l > r || r > this._n) {
        String msg = String.format("Range [%d, %d) out of bounds for length %d", l, r, this._n);
        throw new IndexOutOfBoundsException(msg);
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

  //NextScannerライブラリ
  static class NextScanner implements AutoCloseable {

    private final java.io.BufferedReader br;

    private java.util.StringTokenizer st;

    private static final int BUF_SIZE = 1 << 16;

    private static final char[] c_buf = new char[BUF_SIZE];

    public NextScanner(java.io.InputStream input) {
      this.br = new java.io.BufferedReader(new java.io.InputStreamReader(input));
    }

    private java.util.StringTokenizer readInput() {
      java.util.StringTokenizer st;
      try {
        int b = br.read(c_buf);
        if (b == BUF_SIZE) {
          StringBuilder sb = new StringBuilder();
          sb.append(c_buf);
          sb.append(br.readLine());
          st = new java.util.StringTokenizer(sb.toString());
        } else if (b < 0) {
          throw new java.util.NoSuchElementException();
        } else {
          st = new java.util.StringTokenizer(new String(c_buf, 0, b));
        }
      } catch (java.io.IOException e) {
        throw new java.util.InputMismatchException(e.getMessage());
      }
      return st;
    }

    public String next() throws java.io.IOException {
      if (st == null || !st.hasMoreElements()) {
        st = readInput();
      }
      return st.nextToken();
    }

    @Override
    public void close() throws Exception {
      br.close();
    }
  }
}
