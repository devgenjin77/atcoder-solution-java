/*
 * モノグサプログラミングコンテスト2022
 * （AtCoder Beginner Contest 238）
 * D - AND and SUM
 * https://atcoder.jp/contests/abc238/tasks/abc238_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc238/submissions/31436178
 *
 */

package contests.abc.abc238.abc238_d;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int t = Integer.parseInt(sc.next());
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < t; i++) {
      long a = Long.parseLong(sc.next());
      long s = Long.parseLong(sc.next());
      pw.println(solve(a, s) ? "Yes" : "No");
    }
    pw.close();
    sc.close();
  }

  static boolean solve(long a, long s) {
    if (2 * a > s) {
      return false;
    } else {
      return ((s - (2 * a)) & a) == 0;
    }
  }
}

//NextScannerライブラリ
class NextScanner implements AutoCloseable {

  private final java.io.BufferedReader br;

  private java.util.StringTokenizer st;

  private static final int BUF_SIZE = 1024;

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
