/*
 * 競プロ典型90問
 * 044 - Shift and Swapping（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ar
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31931860
 *
 * note:
 * -見かけ上の変化をメモする
 *
 */

package contests.typical90.typical90_05.typical90_044;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int q = Integer.parseInt(sc.next());
    int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(sc.next());
    }
    PrintWriter pw = new PrintWriter(System.out);
    int shift = 0;
    for (int i = 0; i < q; i++) {
      int type = Integer.parseInt(sc.next());
      int x = Integer.parseInt(sc.next()) - 1;
      int y = Integer.parseInt(sc.next()) - 1;
      int shift_x = (n + x - shift) % n;
      int shift_y = (n + y - shift) % n;
      switch (type) {
        case 1:
          int tmp = array_a[shift_x];
          array_a[shift_x] = array_a[shift_y];
          array_a[shift_y] = tmp;
          break;
        case 2:
          shift = (shift + 1) % n;
          break;
        case 3:
          pw.println(array_a[shift_x]);
          break;
        default:
          break;
      }
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
