/*
 * 競プロ典型90問
 * 008 - AtCounter（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_h
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31882529
 *
 * note:
 * 状態DP
 */

package contests.typical90.typical90_00x.typical90_008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static final String TARGET_STRING = "atcoder";
  static final long MOD = 1_000_000_007L;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();
    br.close();
    //dp[i][j]:=i文字目まで見て、対象文字列のj番目までまでの文字列の作り方が何通りあるか
    long[][] dp = new long[n + 1][TARGET_STRING.length()];
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < TARGET_STRING.length(); j++) {
        //一つ前の結果をコピー
        dp[i][j] = dp[i - 1][j];
      }
      int idx = TARGET_STRING.indexOf(s.charAt(i - 1));
      if (idx == 0) {
        dp[i][idx] += 1;
        dp[i][idx] %= MOD;
      } else if (idx > 0) {
        dp[i][idx] += dp[i - 1][idx - 1];
        dp[i][idx] %= MOD;
      }
    }
    System.out.println(dp[n][TARGET_STRING.length() - 1]);
  }
}
