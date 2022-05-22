/*
 * 競プロ典型90問
 * 010 - Score Sum Queries（★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_j
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31883170
 *
 * note:
 * 累積和
 */

package contests.typical90.typical90_01.typical90_010;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int[][] sum_class = new int[n + 1][2];
    for (int i = 1; i <= n; i++) {
      int c = Integer.parseInt(sc.next()) - 1;
      int p = Integer.parseInt(sc.next());
      sum_class[i][c] = p;
      sum_class[i][0] += sum_class[i - 1][0];
      sum_class[i][1] += sum_class[i - 1][1];
    }
    int q = Integer.parseInt(sc.next());
    PrintWriter pw = new PrintWriter(System.out);
    for (int cnt = 0; cnt < q; cnt++) {
      int l = Integer.parseInt(sc.next());
      int r = Integer.parseInt(sc.next());
      int sum1 = sum_class[r][0] - sum_class[l - 1][0];
      int sum2 = sum_class[r][1] - sum_class[l - 1][1];
      StringBuilder sb = new StringBuilder();
      sb.append(sum1).append(' ').append(sum2);
      pw.println(sb.toString());
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
