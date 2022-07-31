/*
 * UNICORNプログラミングコンテスト2021
 * （AtCoder Beginner Contest 225）
 * B - Star or Not
 * https://atcoder.jp/contests/abc225/tasks/abc225_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc225/submissions/33649245
 *
 * note:
 *
 *
 */

package contests.abc.abc22x.abc225.abc225_b;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int[] in_deg = new int[n];
    for (int i = 1; i < n; i++) {
      int a = Integer.parseInt(sc.next()) - 1;
      int b = Integer.parseInt(sc.next()) - 1;
      in_deg[a]++;
      in_deg[b]++;
    }
    sc.close();
    boolean isOk = true;
    for (int i = 0; i < n - 1; i++) {
      if (in_deg[i] > 1 && in_deg[i] != n - 1) {
        isOk = false;
      }
    }
    System.out.println(isOk ? "Yes" : "No");
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
