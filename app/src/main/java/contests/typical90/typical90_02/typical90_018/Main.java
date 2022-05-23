/*
 * 競プロ典型90問
 * 018 - Statue of Chokudai（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_r
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31920563
 *
 * note:
 * 三角関数を使う
 *
 */

package contests.typical90.typical90_02.typical90_018;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int t = Integer.parseInt(sc.next());
    int l = Integer.parseInt(sc.next());
    double x = Double.parseDouble(sc.next());
    double y = Double.parseDouble(sc.next());
    int q = Integer.parseInt(sc.next());
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      int e = Integer.parseInt(sc.next());
      double rad = Math.toRadians(360.0 * e / t);
      double f_y = -l / 2.0 * Math.sin(rad);
      double f_z = l / 2.0 - (l / 2.0 * Math.cos(rad));
      double dist_y = Math.abs(y - f_y);
      double dist_xy = Math.sqrt((x * x) + (dist_y * dist_y));
      pw.println(Math.toDegrees(Math.atan2(f_z, dist_xy)));
    }
    pw.close();
    sc.close();
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
