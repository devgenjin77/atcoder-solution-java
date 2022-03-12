/*
 * Educational DP Contest / DP まとめコンテスト
 * E - Knapsack 2
 * https://atcoder.jp/contests/dp/tasks/dp_e
 *
 * verified:
 * - https://atcoder.jp/contests/dp/submissions/30016598
 *
 */
package contests.dp.dp_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  static final int MAX_VALUE = 1000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nw = br.readLine().split(" ");
    int n = Integer.parseInt(nw[0]);
    int w = Integer.parseInt(nw[1]);
    long[] weights = new long[n];
    int[] values = new int[n];
    for (int i = 0; i < n; i++) {
      String[] wv = br.readLine().split(" ");
      weights[i] = Long.parseLong(wv[0]);
      values[i] = Integer.parseInt(wv[1]);
    }
    br.close();
    // dp[i][j]:= i個目までみた時、価値がjになった時の重量の最小値
    int max_sum_value = MAX_VALUE * n;
    long[][] dp = new long[n + 1][max_sum_value + 1];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], -1);
    }
    int ans = 0;
    dp[0][0] = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < max_sum_value; j++) {
        if (dp[i][j] >= 0) {
          // i個目を使わないとき
          dp[i + 1][j] = dp[i + 1][j] >= 0 ? Math.min(dp[i][j], dp[i + 1][j]) : dp[i][j];
          long next_w = dp[i][j] + weights[i];
          int next_v = j + values[i];
          if (next_w <= w) {
            ans = Math.max(next_v, ans);
            // i個目を使うとき
            dp[i + 1][next_v] = dp[i + 1][next_v] >= 0 ? Math.min(next_w, dp[i + 1][next_v])
                : dp[i][j] + weights[i];
          }
        }
      }
    }
    System.out.println(ans);
  }
}
