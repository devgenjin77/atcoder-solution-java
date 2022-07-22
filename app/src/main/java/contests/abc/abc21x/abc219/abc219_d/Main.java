/*
 * サイシードプログラミングコンテスト2021
 * （AtCoder Beginner Contest 219）
 * D - Strange Lunchbox
 * https://atcoder.jp/contests/abc219/tasks/abc219_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc219/submissions/33414177
 *
 * note:
 * 動的計画法
 */

package contests.abc.abc21x.abc219.abc219_d;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int x = Integer.parseInt(sc.next());
    final int y = Integer.parseInt(sc.next());
    //dp[i][j][k]:=弁当i個まで見た時に、たこ焼きj個、たい焼きk個を手に入れられる最小の弁当の数
    final int[][][] dp = new int[n + 1][x + 1][y + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        Arrays.fill(dp[i][j], Integer.MAX_VALUE);
      }
    }
    for (int i = 1; i <= n; i++) {
      int a = Integer.parseInt(sc.next());
      int b = Integer.parseInt(sc.next());
      a = Math.min(a, x);
      b = Math.min(b, y);
      //最初の一個のケース
      dp[i][a][b] = 1;
      //追加の一個のケース
      for (int n_a = 1; n_a <= x; n_a++) {
        for (int n_b = 1; n_b <= y; n_b++) {
          if (dp[i - 1][n_a][n_b] != Integer.MAX_VALUE) {
            // 追加で買うケース
            int sum_a = Math.min(n_a + a, x);
            int sum_b = Math.min(n_b + b, y);
            dp[i][sum_a][sum_b] = Math.min(dp[i - 1][n_a][n_b] + 1, dp[i][sum_a][sum_b]);
            // 買わないケース
            dp[i][n_a][n_b] = Math.min(dp[i - 1][n_a][n_b], dp[i][n_a][n_b]);
          }
        }
      }
    }
    sc.close();
    System.out.println(dp[n][x][y] != Integer.MAX_VALUE ? dp[n][x][y] : -1);
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
