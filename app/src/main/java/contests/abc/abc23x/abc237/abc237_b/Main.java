/*
 * AtCoder Beginner Contest 237
 * B - Matrix Transposition
 * https://atcoder.jp/contests/abc237/tasks/abc237_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc237/submissions/33926404
 *
 * note:
 *
 *
 */

package contests.abc.abc23x.abc237.abc237_b;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int h = Integer.parseInt(sc.next());
    final int w = Integer.parseInt(sc.next());
    final int[][] matrix_ans = new int[w][h];
    for (int pos_h = 0; pos_h < h; pos_h++) {
      for (int pos_w = 0; pos_w < w; pos_w++) {
        matrix_ans[pos_w][pos_h] = Integer.parseInt(sc.next());
      }
    }
    sc.close();
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < w; i++) {
      StringBuilder line = new StringBuilder();
      for (int j = 0; j < h; j++) {
        line.append(matrix_ans[i][j]);
        line.append(' ');
      }
      pw.println(line.deleteCharAt(line.length() - 1));
    }
    pw.close();
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
