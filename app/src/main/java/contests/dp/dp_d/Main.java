/*
 * Educational DP Contest / DP まとめコンテスト
 * D - Knapsack 1
 * https://atcoder.jp/contests/dp/tasks/dp_d
 *
 * verified:
 * - https://atcoder.jp/contests/dp/submissions/30010847
 *
 */
package contests.dp.dp_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nw = br.readLine().split(" ");
    int n = Integer.parseInt(nw[0]);
    int w = Integer.parseInt(nw[1]);
    int[] weights = new int[n];
    long[] values = new long[n];
    for (int i = 0; i < n; i++) {
      String[] wv = br.readLine().split(" ");
      weights[i] = Integer.parseInt(wv[0]);
      values[i] = Long.parseLong(wv[1]);
    }
    br.close();
    long[][] dp = new long[n + 1][w + 1];
    Arrays.fill(dp[0], -1);
    long ans = 0;
    dp[0][0] = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < w; j++) {
        dp[i + 1][j] = Math.max(dp[i][j], dp[i + 1][j]);
        int next_w = weights[i] + j;
        if (next_w <= w) {
          dp[i + 1][next_w] = Math.max(dp[i][j] + values[i], dp[i + 1][next_w]);
          ans = Math.max(dp[i + 1][next_w], ans);
        }
      }
    }
    System.out.println(ans);
  }
}
