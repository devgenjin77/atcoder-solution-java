/*
 * 競プロ典型90問
 * 064 - Uplift（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bl
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31952351
 *
 * note:
 * -階差を考える
 *
 */

package contests.typical90.typical90_07.typical90_064;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int q = Integer.parseInt(sc.next());
    long[] array_a = new long[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(sc.next());
    }
    long[] array_diff = new long[n - 1];
    long total_diff = 0;
    for (int i = 0; i < n - 1; i++) {
      array_diff[i] = array_a[i + 1] - array_a[i];
      total_diff += Math.abs(array_diff[i]);
    }
    PrintWriter pw = new PrintWriter(System.out);
    for (int cnt = 1; cnt <= q; cnt++) {
      int l = Integer.parseInt(sc.next()) - 1;
      int r = Integer.parseInt(sc.next()) - 1;
      long v = Long.parseLong(sc.next());
      if (l > 0) {
        total_diff -= Math.abs(array_diff[l - 1]);
        array_diff[l - 1] += v;
        total_diff += Math.abs(array_diff[l - 1]);
      }
      if (r < n - 1) {
        total_diff -= Math.abs(array_diff[r]);
        array_diff[r] -= v;
        total_diff += Math.abs(array_diff[r]);
      }
      pw.println(total_diff);
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
