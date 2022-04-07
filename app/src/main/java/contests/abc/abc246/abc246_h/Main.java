/*
 * ABC246
 * Ex - 01? Queries
 * https://atcoder.jp/contests/abc246/tasks/abc246_h
 *
 * verified:
 * - https://atcoder.jp/contests/abc246/submissions/30779432
 *
 * Note:
 * セグ木、行列の積
 *
 */

package contests.abc.abc246.abc246_h;

import java.io.PrintWriter;

public class Main {

  final static long MOD = 998244353L;

  final static long[][] matrix_0 = new long[][]{
      {1, 1, 1},
      {0, 1, 0},
      {0, 0, 1}
  };

  final static long[][] matrix_1 = new long[][]{
      {1, 0, 0},
      {1, 1, 1},
      {0, 0, 1}
  };

  final static long[][] matrix_q = new long[][]{
      {1, 1, 1},
      {1, 1, 1},
      {0, 0, 1}
  };

  final static long[][] matrix_e = new long[][]{
      {1, 0, 0},
      {0, 1, 0},
      {0, 0, 1}
  };

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    int n = fs.nextInt();
    int q = fs.nextInt();
    String s = fs.next();
    Matrix[] arr_matrix = new Matrix[n];
    for (int i = 0; i < n; i++) {
      arr_matrix[i] = selectMatrix(s.charAt(i));
    }
    SegTree<Matrix> segTree = new SegTree<>(arr_matrix, Main::op, new Matrix(matrix_e));
    PrintWriter pw = new PrintWriter(System.out);
    for (int cnt = 0; cnt < q; cnt++) {
      int x = fs.nextInt() - 1;
      char c = fs.next().charAt(0);
      segTree.set(x, selectMatrix(c));
      Matrix p = segTree.allProd();
      long ans = (p.data[0][2] + p.data[1][2]) % MOD;
      pw.println(ans);
    }
    pw.close();
    fs.close();
  }

  static Matrix selectMatrix(char ch) {
    if (ch == '0') {
      return new Matrix(matrix_0);
    } else if (ch == '1') {
      return new Matrix(matrix_1);
    } else {
      return new Matrix(matrix_q);
    }
  }

  static Matrix op(Matrix a, Matrix b) {
    long[][] n_data = new long[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          n_data[i][j] += a.data[i][k] * b.data[k][j];
          n_data[i][j] %= MOD;
        }
      }
    }
    return new Matrix(n_data);
  }

  static class Matrix {

    long[][] data;

    Matrix(long[][] data) {
      this.data = new long[3][3];
      for (int i = 0; i < 3; i++) {
        System.arraycopy(data, 0, this.data, 0, 3);
      }
    }
  }

  //SegTree ライブラリ
  static class SegTree<S> {

    final int MAX;
    final int N;
    final java.util.function.BinaryOperator<S> op;
    final S e;
    final S[] data;

    SegTree(int n, java.util.function.BinaryOperator<S> op, S e) {
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

    SegTree(S[] dat, java.util.function.BinaryOperator<S> op, S e) {
      this(dat.length, op, e);
      int l = dat.length;
      System.arraycopy(dat, 0, data, N, l);
      for (int i = N - 1; i > 0; i--) {
        data[i] = op.apply(data[i << 1 | 0], data[i << 1 | 1]);
      }
    }

    void set(int p, S x) {
      if (!(p >= 0 && p < MAX)) {
        String errMsg = String.format("Index %d out of bounds for length %d.", p, MAX);
        throw new ArrayIndexOutOfBoundsException(errMsg);
      }
      data[p += N] = x;
      p >>= 1;
      while (p > 0) {
        data[p] = op.apply(data[p << 1 | 0], data[p << 1 | 1]);
        p >>= 1;
      }
    }

    S get(int p) {
      if (!(p >= 0 && p < MAX)) {
        String errMsg = String.format("Index %d out of bounds for length %d.", p, MAX);
        throw new ArrayIndexOutOfBoundsException(errMsg);
      }
      return data[p + N];
    }

    S prod(int l, int r) {
      if (l > r) {
        String errMsg = String.format("Invalid range: [%d, %d).", l, r);
        throw new IllegalArgumentException(errMsg);
      }
      if (!(l >= 0 && l <= MAX)) {
        String errMsg = String.format("Index %d out of bounds for length %d.", l, MAX);
        throw new ArrayIndexOutOfBoundsException(errMsg);
      }
      if (!(r >= 0 && r <= MAX)) {
        String errMsg = String.format("Index %d out of bounds for length %d.", r, MAX);
        throw new ArrayIndexOutOfBoundsException(errMsg);
      }

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

    S allProd() {
      return data[1];
    }

    int maxRight(int l, java.util.function.Predicate<S> f) {
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

    int minLeft(int r, java.util.function.Predicate<S> f) {
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
  }

  //FastScanner ライブラリ
  static class FastScanner implements AutoCloseable {

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

    @Override
    public void close() throws Exception {
      in.close();
    }
  }
}
