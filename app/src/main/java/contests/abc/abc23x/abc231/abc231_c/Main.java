/*
 * パナソニックプログラミングコンテスト2021
 * （AtCoder Beginner Contest 231）
 * C - Counting 2
 * https://atcoder.jp/contests/abc231/tasks/abc231_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc231/submissions/33897854
 *
 * note:
 * 二分探索する
 *
 */

package contests.abc.abc23x.abc231.abc231_c;

import java.io.PrintWriter;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int q = Integer.parseInt(sc.next());
    final int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(sc.next());
    }
    Arrays.sort(array_a);

    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      int x = Integer.parseInt(sc.next());
      int b = Arrays.binarySearch(array_a, x);
      if (b < 0) {
        b = ~b;
      }
      pw.println(n - b);
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
