/*
 * 競プロ典型90問
 * 004 - Cross Sum（★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_d
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31825152
 *
 * note:
 * 累積和
 */

package contests.typical90.typical90_01.typical90_004;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int h = Integer.parseInt(sc.next());
    int w = Integer.parseInt(sc.next());
    int[][] array_a = new int[h][w];
    int[] array_sum_row = new int[h];
    int[] array_sum_col = new int[w];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        array_a[i][j] = Integer.parseInt(sc.next());
        array_sum_row[i] += array_a[i][j];
        array_sum_col[j] += array_a[i][j];
      }
    }
    sc.close();
    int[][] array_b = new int[h][w];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        array_b[i][j] = array_sum_row[i] + array_sum_col[j] - array_a[i][j];
      }
    }
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < h; i++) {
      StringBuilder sb = new StringBuilder();
      for (int b : array_b[i]) {
        sb.append(b).append(' ');
      }
      pw.println(sb.deleteCharAt(sb.length() - 1));
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
