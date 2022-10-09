/*
 * AtCoder Beginner Contest 246
 * A - Four Points
 * https://atcoder.jp/contests/abc246/tasks/abc246_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc246/submissions/35527759
 *
 * note:
 * XOR
 */

package contests.abc.abc24x.abc246.abc246_a;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    int ans_x = 0, ans_y = 0;
    for (int i = 0; i < 3; i++) {
      int x = Integer.parseInt(sc.next());
      int y = Integer.parseInt(sc.next());
      ans_x ^= x;
      ans_y ^= y;
    }
    sc.close();
    System.out.println(String.format("%d %d", ans_x, ans_y));
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
