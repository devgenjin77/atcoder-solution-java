/*
 * ABC245
 * D - Polynomial division
 * https://atcoder.jp/contests/abc245/tasks/abc245_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc245/submissions/31403854
 *
 */

package contests.abc.abc245.abc245_d;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int m = Integer.parseInt(sc.next());
    int[] arr_a = new int[n + 1];
    int[] arr_c = new int[n + m + 1];
    for (int i = 0; i <= n; i++) {
      arr_a[i] = Integer.parseInt(sc.next());
    }
    for (int i = 0; i <= n + m; i++) {
      arr_c[i] = Integer.parseInt(sc.next());
    }
    sc.close();

    int[] arr_b = new int[m + 1];
    for (int idx_b = m; idx_b >= 0; idx_b--) {
      arr_b[idx_b] = arr_c[idx_b + n] / arr_a[n];
      for (int idx_a = 0; idx_a < n; idx_a++) {
        arr_c[idx_a + idx_b] -= arr_a[idx_a] * arr_b[idx_b];
      }
    }
    StringBuilder sb = new StringBuilder();
    sb.append(arr_b[0]);
    for (int i = 1; i < arr_b.length; i++) {
      sb.append(" ").append(arr_b[i]);
    }
    System.out.println(sb.toString());
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
