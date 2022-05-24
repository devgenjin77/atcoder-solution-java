/*
 * 競プロ典型90問
 * 042 - Multiple of 9（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ap
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31930474
 *
 * note:
 * -DP、9の倍数の性質
 *
 */

package contests.typical90.typical90_05.typical90_042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static final long MOD = 1_000_000_007L;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(br.readLine());
    br.close();
    System.out.println(solve(k));
  }

  static long solve(int k) {
    if (k % 9 == 0) {
      // dp[i]:=桁和がiとなる通り数
      long dp[] = new long[k + 1];
      dp[0] = 1;
      for (int i = 1; i <= k; i++) {
        for (int j = 1; j <= 9; j++) {
          if (i - j >= 0) {
            dp[i] += dp[i - j];
            dp[i] %= MOD;
          }
        }
      }
      return dp[k];
    } else {
      return 0;
    }
  }
}
