/*
 * AtCoder Beginner Contest 245
 * D - Polynomial division
 * https://atcoder.jp/contests/abc245/tasks/abc245_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc245/submissions/35436730
 *
 * note:
 *
 */

package contests.abc.abc24x.abc245.abc245_d;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int m = Integer.parseInt(sc.next());
    final int[] array_a = new int[n + 1];
    final int[] array_b = new int[m + 1];
    final int[] array_c = new int[n + m + 1];
    for (int i = 0; i <= n; i++) {
      array_a[i] = Integer.parseInt(sc.next());
    }
    for (int i = 0; i <= n + m; i++) {
      array_c[i] = Integer.parseInt(sc.next());
    }
    sc.close();
    for (int idx_b = m; idx_b >= 0; idx_b--) {
      array_b[idx_b] = array_c[n + idx_b] / array_a[n];
      for (int idx_a = 0; idx_a <= n; idx_a++) {
        array_c[idx_a + idx_b] -= array_a[idx_a] * array_b[idx_b];
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int b : array_b) {
      sb.append(b).append(' ');
    }
    System.out.println(sb.deleteCharAt(sb.length() - 1));
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
