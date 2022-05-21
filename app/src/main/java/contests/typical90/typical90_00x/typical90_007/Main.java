/*
 * 競プロ典型90問
 * 007 - CP Classes（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_g
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31829167
 *
 * note:
 * ソートから二分探索
 */

package contests.typical90.typical90_00x.typical90_007;

import java.io.PrintWriter;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(sc.next());
    }
    Arrays.sort(array_a);
    int q = Integer.parseInt(sc.next());
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      int b = Integer.parseInt(sc.next());
      int idx = Arrays.binarySearch(array_a, b);
      if (idx >= 0) {
        pw.println(0);
      } else {
        idx = ~idx;
        if (idx == 0) {
          pw.println(Math.abs(array_a[0] - b));
        } else if (idx == n) {
          pw.println(Math.abs(array_a[n - 1] - b));
        } else {
          pw.println(Math.min(Math.abs(array_a[idx] - b), Math.abs(array_a[idx - 1] - b)));
        }
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
