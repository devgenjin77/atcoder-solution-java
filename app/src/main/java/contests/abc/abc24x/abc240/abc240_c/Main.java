/*
 * ABC240
 * C - Jumping Takahashi
 * https://atcoder.jp/contests/abc240/tasks/abc240_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc240/submissions/32289432
 *
 */

package contests.abc.abc24x.abc240.abc240_c;

public class Main {

  static final int MAX_DIST = 10000;

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int x = Integer.parseInt(sc.next());
    boolean[][] dp = new boolean[n + 1][MAX_DIST + 1];
    dp[0][0] = true;
    for (int i = 1; i <= n; i++) {
      int a = Integer.parseInt(sc.next());
      int b = Integer.parseInt(sc.next());
      for (int dist = 0; dist < MAX_DIST; dist++) {
        if (dp[i - 1][dist]) {
          dp[i][dist + a] = true;
          dp[i][dist + b] = true;
        }
      }
    }
    sc.close();
    System.out.println(dp[n][x] ? "Yes" : "No");
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
