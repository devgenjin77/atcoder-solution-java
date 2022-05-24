/*
 * 競プロ典型90問
 * 028 - Cluttered Paper（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ab
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31927634
 *
 * note:
 * - 二次元いもす法を使う
 *
 */

package contests.typical90.typical90_03.typical90_028;

import java.io.PrintWriter;

public class Main {

  static final int MAX_SIZE = 1000;

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int[][] grid = new int[MAX_SIZE + 1][MAX_SIZE + 1];
    for (int i = 0; i < n; i++) {
      int lx = Integer.parseInt(sc.next());
      int ly = Integer.parseInt(sc.next());
      int rx = Integer.parseInt(sc.next());
      int ry = Integer.parseInt(sc.next());

      grid[ly][lx] += 1;  //左下
      grid[ry][lx] -= 1;  //左上
      grid[ly][rx] -= 1;  //右下
      grid[ry][rx] += 1;  //右上
    }
    sc.close();

    //x方向の累積和
    for (int y = 0; y <= MAX_SIZE; y++) {
      for (int x = 1; x <= MAX_SIZE; x++) {
        grid[y][x] += grid[y][x - 1];
      }
    }

    //y方向の累積和
    for (int x = 0; x <= MAX_SIZE; x++) {
      for (int y = 1; y <= MAX_SIZE; y++) {
        grid[y][x] += grid[y - 1][x];
      }
    }
    int[] cnt_p = new int[n + 1];
    for (int x = 0; x <= MAX_SIZE; x++) {
      for (int y = 0; y <= MAX_SIZE; y++) {
        cnt_p[grid[y][x]] += 1;
      }
    }
    PrintWriter pw = new PrintWriter(System.out);
    for (int cnt = 1; cnt <= n; cnt++) {
      pw.println(cnt_p[cnt]);
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
