/*
 * 競プロ典型90問
 * 036 - Max Manhattan Distance（★5）
 * https://atcoder.jp/contests/typical90/tasks/typical90_aj
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/32078164
 *
 * note:
 * -マンハッタン距離は45度回転して求める
 *
 */

package contests.typical90.typical90_04.typical90_036;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int q = Integer.parseInt(sc.next());
    //z = x - y
    long[] array_z = new long[n];
    //w = x + y
    long[] array_w = new long[n];
    long min_z = Long.MAX_VALUE, max_z = Long.MIN_VALUE;
    long min_w = Long.MAX_VALUE, max_w = Long.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      long x = Long.parseLong(sc.next());
      long y = Long.parseLong(sc.next());
      array_z[i] = x - y;
      array_w[i] = x + y;
      min_z = Math.min(array_z[i], min_z);
      max_z = Math.max(array_z[i], max_z);
      min_w = Math.min(array_w[i], min_w);
      max_w = Math.max(array_w[i], max_w);
    }
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      int qi = Integer.parseInt(sc.next()) - 1;
      long dist = 0;
      dist = Math.max(Math.abs(min_z - array_z[qi]), dist);
      dist = Math.max(Math.abs(max_z - array_z[qi]), dist);
      dist = Math.max(Math.abs(min_w - array_w[qi]), dist);
      dist = Math.max(Math.abs(max_w - array_w[qi]), dist);
      pw.println(dist);
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
