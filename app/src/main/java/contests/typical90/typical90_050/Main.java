/*
 * 競プロ典型90問
 * 050 - Stair Jump（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ax
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28353528
 *
 */
package contests.typical90.typical90_050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  final static int MOD = 1_000_000_007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    br.close();
    int n = Integer.parseInt(input[0]);
    int l = Integer.parseInt(input[1]);
    int[] dp = new int[n + 1];
    dp[0] = 1;
    for (int i = 1; i <= n; i++) {
      dp[i] += dp[i - 1];
      if (i - l >= 0) {
        dp[i] += dp[i - l];
      }
      dp[i] %= 1_000_000_007;
    }
    System.out.println(dp[n]);
    return;
  }
}
