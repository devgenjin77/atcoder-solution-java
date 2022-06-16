/*
 * 競プロ典型90問
 * 037 - Don't Leave the Spice（★5）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ak
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/32506152
 *
 * note:
 * - DPをセグ木で高速化する
 *
 */

package contests.typical90.typical90_04.typical90_037;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int w = Integer.parseInt(sc.next());
    int n = Integer.parseInt(sc.next());
    Long[] dp = new Long[w + 1];
    Long[] next_dp = new Long[w + 1];
    Arrays.fill(dp, -1L);
    dp[0] = 0L;
    Arrays.fill(next_dp, -1L);
    next_dp[0] = 0L;
    for (int i = 0; i < n; i++) {
      int l = Integer.parseInt(sc.next());
      int r = Integer.parseInt(sc.next());
      long v = Long.parseLong(sc.next());
      SegTree<Long> seg = new SegTree<>(dp, Long::max, -1L);
      for (int next_w = l; next_w <= w; next_w++) {
        int range_l = Math.max(next_w - r, 0);
        int range_r = next_w - l + 1;
        long prev_val = seg.prod(range_l, range_r);
        if (prev_val >= 0) {
          next_dp[next_w] = Math.max(prev_val + v, next_dp[next_w]);
        }
      }
      System.arraycopy(next_dp, 0, dp, 0, w + 1);
    }
    sc.close();
    System.out.println(next_dp[w]);
  }

  //SegTreeライブラリ
  static class SegTree<S> {

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
