/*
 * AtCoder Beginner Contest 246
 * C - Coupon
 * https://atcoder.jp/contests/abc246/tasks/abc246_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc246/submissions/35529977
 *
 * note:
 *
 */

package contests.abc.abc24x.abc246.abc246_c;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final long k = Long.parseLong(sc.next());
    final long x = Long.parseLong(sc.next());
    final long[] array_mod = new long[n];
    long remain_coupon = k;
    long sum = 0;
    for (int i = 0; i < n; i++) {
      long a = Long.parseLong(sc.next());
      long use = Math.min(a / x, remain_coupon);
      remain_coupon -= use;
      sum += (a - (use * x));
      array_mod[i] = a % x;
    }
    sc.close();
    //X円未満の割引を受ける時、余りが大きい順から引いていく。
    if (remain_coupon > 0) {
      Arrays.sort(array_mod);
      int idx_m = n - 1;
      while (idx_m >= 0 && array_mod[idx_m] > 0 && remain_coupon > 0) {
        sum -= array_mod[idx_m];
        remain_coupon--;
        idx_m--;
      }
    }
    System.out.println(sum);
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
