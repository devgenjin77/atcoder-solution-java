/*
 * AtCoder Beginner Contest 245
 * C - Choose Elements
 * https://atcoder.jp/contests/abc245/tasks/abc245_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc245/submissions/35342176
 *
 * note:
 *
 */

package contests.abc.abc24x.abc245.abc245_c;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int k = Integer.parseInt(sc.next());
    final int[] array_a = new int[n];
    final int[] array_b = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(sc.next());
    }
    for (int i = 0; i < n; i++) {
      array_b[i] = Integer.parseInt(sc.next());
    }
    sc.close();
    final boolean[][] dp = new boolean[n][2];
    dp[0][0] = true;
    dp[0][1] = true;
    for (int i = 1; i < n; i++) {
      //A_iが使えるか
      if ((dp[i - 1][0] && Math.abs(array_a[i - 1] - array_a[i]) <= k) || (dp[i - 1][1]
          && Math.abs(array_b[i - 1] - array_a[i]) <= k)) {
        dp[i][0] = true;
      }
      //B_iが使えるか
      if ((dp[i - 1][0] && Math.abs(array_a[i - 1] - array_b[i]) <= k) || (dp[i - 1][1]
          && Math.abs(array_b[i - 1] - array_b[i]) <= k)) {
        dp[i][1] = true;
      }
    }
    System.out.println(dp[n - 1][0] || dp[n - 1][1] ? "Yes" : "No");
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
