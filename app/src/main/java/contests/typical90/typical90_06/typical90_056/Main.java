/*
 * 競プロ典型90問
 * 056 - Lucky Bag（★5）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bd
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/32520163
 *
 * note:
 * -DP復元
 *
 */

package contests.typical90.typical90_06.typical90_056;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int s = Integer.parseInt(sc.next());
    int[] array_a = new int[n];
    int[] array_b = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(sc.next());
      array_b[i] = Integer.parseInt(sc.next());
    }
    sc.close();
    boolean[][] dp = new boolean[n + 1][s + 1];
    dp[0][0] = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < s; j++) {
        if (dp[i][j]) {
          if (array_a[i] + j <= s) {
            dp[i + 1][array_a[i] + j] = true;
          }
          if (array_b[i] + j <= s) {
            dp[i + 1][array_b[i] + j] = true;
          }
        }
      }
    }

    if (dp[n][s]) {
      StringBuilder ans = new StringBuilder();
      int v = s;
      for (int i = n - 1; i >= 0; i--) {
        if (v - array_a[i] >= 0 && dp[i][v - array_a[i]]) {
          ans.append('A');
          v -= array_a[i];
        } else {
          ans.append('B');
          v -= array_b[i];
        }
      }
      System.out.println(ans.reverse());
    } else {
      System.out.println("Impossible");
    }
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
