/*
 * 競プロ典型90問
 * 070 - Plant Planning（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_br
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31953638
 *
 * note:
 * -中央値をとる
 * -x,y独立で考える
 *
 */

package contests.typical90.typical90_07.typical90_070;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    long[] array_x = new long[n];
    long[] array_y = new long[n];
    for (int i = 0; i < n; i++) {
      array_x[i] = Long.parseLong(sc.next());
      array_y[i] = Long.parseLong(sc.next());
    }
    sc.close();

    Arrays.sort(array_x);
    Arrays.sort(array_y);
    long ans = 0;
    if (n > 1) {
      int med = n / 2;
      for (int i = 0; i < n; i++) {
        ans += Math.abs(array_x[med] - array_x[i]);
        ans += Math.abs(array_y[med] - array_y[i]);
      }
    }
    System.out.println(ans);
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
