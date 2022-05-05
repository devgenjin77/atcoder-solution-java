/*
 * ABC223
 * C - Doukasen
 * https://atcoder.jp/contests/abc223/tasks/abc223_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc223/submissions/31449454
 *
 */

package contests.abc.abc223.abc223_c;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int[] arr_a = new int[n];
    int[] arr_b = new int[n];
    double[] arr_time = new double[n];
    double total_time = 0.0d;
    for (int i = 0; i < n; i++) {
      arr_a[i] = Integer.parseInt(sc.next());
      arr_b[i] = Integer.parseInt(sc.next());
      arr_time[i] = (double) arr_a[i] / arr_b[i];
      total_time += arr_time[i];
    }
    sc.close();

    total_time /= 2.0;
    double ans = 0;
    for (int i = 0; i < n; i++) {
      if (total_time > arr_time[i]) {
        total_time -= arr_time[i];
        ans += arr_a[i];
      } else {
        ans += arr_b[i] * total_time;
        break;
      }
    }
    System.out.println(ans);
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
