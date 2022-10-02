/*
 * AtCoder Beginner Contest 245
 * B - Mex
 * https://atcoder.jp/contests/abc245/tasks/abc245_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc245/submissions/35341005
 *
 * note:
 *
 */

package contests.abc.abc24x.abc245.abc245_b;

public class Main {

  private static final int MAX_A = 2000;

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final boolean[] appeared = new boolean[MAX_A + 1];
    for (int i = 0; i < n; i++) {
      appeared[Integer.parseInt(sc.next())] = true;
    }
    sc.close();
    int mex = 0;
    while (true) {
      if (appeared[mex]) {
        mex++;
      } else {
        break;
      }
    }
    System.out.println(mex);
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
