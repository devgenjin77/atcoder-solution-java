/*
 * AtCoder Library Practice Contest
 * K - Range Affine Range Sum
 * https://atcoder.jp/contests/practice2/tasks/practice2_k
 *
 * verified:
 * - https://atcoder.jp/contests/practice2/submissions/30150928
 *
 */
package contests.practice2.practice2_k;

import java.io.IOException;
import java.io.PrintWriter;

public class Main {

  static final Long MOD = 998244353l;

  public static void main(String[] args) throws IOException {
    FastScanner sc = new FastScanner();
    int n = sc.nextInt();
    int q = sc.nextInt();
    StructS[] data = new StructS[n];
    for (int i = 0; i < n; i++) {
      data[i] = new StructS(sc.nextLong(), 1l);
    }
    //区間加算・区間和取得
    LazySegTree<StructS, StructT> lazySegTree =
        new LazySegTree<>(data, Main::op, new StructS(0l, 0l),
            Main::mapping, Main::composition, new StructT(1l, 0l));
    PrintWriter pw = new PrintWriter(System.out);
    for (int cnt = 0; cnt < q; cnt++) {
      int type = sc.nextInt();
      int l = sc.nextInt();
      int r = sc.nextInt();
      switch (type) {
        case 0:
          long b = sc.nextLong();
          long c = sc.nextLong();
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


  // FastScannerライブラリ
  static class FastScanner {

    private final java.io.InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buf_len = 0;

    private boolean hasNextByte() {
      if (ptr < buf_len) {
        return true;
      } else {
        ptr = 0;
        try {
          buf_len = in.read(buffer);
        } catch (java.io.IOException e) {
          e.printStackTrace();
        }
        if (buf_len <= 0) {
          return false;
        }
      }
      return true;
    }

    private int readByte() {
      if (hasNextByte()) {
        return buffer[ptr++];
      } else {
        return -1;
      }
    }

    private static boolean isPrintableChar(int c) {
      return 33 <= c && c <= 126;
    }

    public boolean hasNext() {
      while (hasNextByte() && !isPrintableChar(buffer[ptr])) {
        ptr++;
      }
      return hasNextByte();
    }

    public String next() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      StringBuilder sb = new StringBuilder();
      int b = readByte();
      while (isPrintableChar(b)) {
        sb.appendCodePoint(b);
        b = readByte();
      }
      return sb.toString();
    }

    public long nextLong() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      long n = 0;
      boolean minus = false;
      int b = readByte();
      if (b == '-') {
        minus = true;
        b = readByte();
      }
      if (b < '0' || '9' < b) {
        throw new NumberFormatException();
      }
      while (true) {
        if ('0' <= b && b <= '9') {
          n *= 10;
          n += b - '0';
        } else if (b == -1 || !isPrintableChar(b)) {
          return minus ? -n : n;
        } else {
          throw new NumberFormatException();
        }
        b = readByte();
      }
    }

    public int nextInt() {
      long nl = nextLong();
      if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) {
        throw new NumberFormatException();
      }
      return (int) nl;
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public void close() throws java.io.IOException {
      in.close();
    }
  }
}
