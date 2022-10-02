/*
 * AtCoder Beginner Contest 245
 * A - Good morning
 * https://atcoder.jp/contests/abc245/tasks/abc245_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc245/submissions/35340128
 *
 * note:
 *
 */

package contests.abc.abc24x.abc245.abc245_a;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int a = Integer.parseInt(sc.next());
    final int b = Integer.parseInt(sc.next());
    final int c = Integer.parseInt(sc.next());
    final int d = Integer.parseInt(sc.next());
    sc.close();
    final int time_t = (a * 100) + b;
    final int time_a = (c * 100) + d;
    System.out.println(time_t <= time_a ? "Takahashi" : "Aoki");
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
