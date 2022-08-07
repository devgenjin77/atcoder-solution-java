/*
 * トヨタシステムズプログラミングコンテスト2021
 * （AtCoder Beginner Contest 228）
 * C - Final Day
 * https://atcoder.jp/contests/abc228/tasks/abc228_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc228/submissions/33866472
 *
 * note:
 * 総得点をソートする。他の人全員0点で自分が満点の場合、規定順位以上になれるかを求める
 *
 */

package contests.abc.abc22x.abc228.abc228_c;

import java.io.PrintWriter;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int k = Integer.parseInt(sc.next());
    final int[] array_p = new int[n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < 3; j++) {
        array_p[i] += Integer.parseInt(sc.next());
      }
    }
    sc.close();
    final int[] array_q = new int[n];
    System.arraycopy(array_p, 0, array_q, 0, n);
    Arrays.sort(array_q);
    PrintWriter pw = new PrintWriter(System.out);
    for (int p : array_p) {
      pw.println(p + 300 >= array_q[n - k] ? "Yes" : "No");
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
