/*
 * AtCoder Beginner Contest 266
 * D - Snuke Panic (1D)
 * https://atcoder.jp/contests/abc266/tasks/abc266_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc266/submissions/35016674
 *
 * note:
 *　DP
 *
 */

package contests.abc.abc26x.abc266.abc266_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static final int MAX_T = 100_000;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final long[][] tbl_score = new long[MAX_T + 1][5];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      long a = Long.parseLong(st.nextToken());
      tbl_score[t][x] = a;
    }
    br.close();

    long[][] dp = new long[MAX_T + 1][5];
    //dp[0][0]以外からのスタートが無効になるように、低い値を入れておく。
    Arrays.fill(dp[0], (long) -1e18);
    dp[0][0] = 0;
    for (int i = 1; i <= MAX_T; i++) {
      for (int j = 0; j < 5; j++) {
        long prev_max = dp[i - 1][j];
        if (j > 0) {
          prev_max = Math.max(dp[i - 1][j - 1], prev_max);
        }
        if (j < 4) {
          prev_max = Math.max(dp[i - 1][j + 1], prev_max);
        }
        dp[i][j] = prev_max + tbl_score[i][j];
      }
    }
    long ans = 0;
    for (int i = 0; i < 5; i++) {
      ans = Math.max(dp[MAX_T][i], ans);
    }
    System.out.println(ans);
  }
}
