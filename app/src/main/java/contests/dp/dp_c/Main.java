/*
 * Educational DP Contest / DP まとめコンテスト
 * C - Vacation
 * https://atcoder.jp/contests/dp/tasks/dp_c
 *
 * verified:
 * - https://atcoder.jp/contests/dp/submissions/30009020
 *
 */
package contests.dp.dp_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] tbl_hp = new int[n][3];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        tbl_hp[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    br.close();
    int[][] dp = new int[n][3];
    dp[0][0] = tbl_hp[0][0];
    dp[0][1] = tbl_hp[0][1];
    dp[0][2] = tbl_hp[0][2];
    for (int i = 1; i < n; i++) {
      dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]) + tbl_hp[i][0];
      dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + tbl_hp[i][1];
      dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + tbl_hp[i][2];
    }
    int ans = Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    System.out.println(ans);
  }
}
