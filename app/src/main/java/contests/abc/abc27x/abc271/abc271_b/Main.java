/*
 * 京セラプログラミングコンテスト2022
 * （AtCoder Beginner Contest 271）
 * B - Maintain Multiple Sequences
 * https://atcoder.jp/contests/abc271/tasks/abc271_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc271/submissions/35853550
 *
 */

package contests.abc.abc27x.abc271.abc271_b;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int q = Integer.parseInt(sc.next());
    final int[][] array_l = new int[n][];
    for (int i = 0; i < n; i++) {
      int l = Integer.parseInt(sc.next());
      array_l[i] = new int[l];
      for (int j = 0; j < l; j++) {
        array_l[i][j] = Integer.parseInt(sc.next());
      }
    }
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      int s = Integer.parseInt(sc.next()) - 1;
      int t = Integer.parseInt(sc.next()) - 1;
      pw.println(array_l[s][t]);
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
