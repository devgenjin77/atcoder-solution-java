/*
 * 競プロ典型90問
 * 008 - AtCounter（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_h
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/27926819
 *
 */
package contests.typical90.typical90_008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  final static String TARGET_STRING = "atcoder";
  final static long MOD = 1_000_000_007l;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();
    br.close();
    long[][] dp = new long[TARGET_STRING.length() + 1][n + 1];
    Arrays.fill(dp[0], 1);
    for (int idx_s = 1; idx_s <= n; idx_s++) {
      for (int idx_target = 1; idx_target <= TARGET_STRING.length(); idx_target++) {
        if (TARGET_STRING.charAt(idx_target - 1) == s.charAt(idx_s - 1)) {
          dp[idx_target][idx_s] = (dp[idx_target][idx_s - 1] + dp[idx_target - 1][idx_s - 1]) % MOD;
        } else {
          dp[idx_target][idx_s] = dp[idx_target][idx_s - 1];
        }
      }
    }
    System.out.println(dp[TARGET_STRING.length()][n]);
  }
}
