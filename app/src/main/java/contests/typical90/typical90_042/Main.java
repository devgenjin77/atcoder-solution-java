/*
 * 競プロ典型90問
 * 042 - Multiple of 9（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ap
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28340291
 *
 */
package contests.typical90.typical90_042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  final static int MOD = 1_000_000_007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(br.readLine());
    br.close();

    System.out.println(solve(k));
  }

  static int solve(int k) {
    if (k % 9 != 0) {
      return 0;
    }
    int[] dp = new int[k + 1];
    dp[0] = 1;
    for (int i = 1; i <= k; i++) {
      int range = Math.min(i, 9);
      for (int prev = 1; prev <= range; prev++) {
        dp[i] += dp[i - prev];
        dp[i] %= MOD;
      }
    }
    return dp[k];
  }
}
