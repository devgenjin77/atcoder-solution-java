/*
 * AtCoder Beginner Contest 211
 * C - chokudai
 * https://atcoder.jp/contests/abc211/tasks/abc211_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc211/submissions/37906850
 *
 * note:
 *
 *
 */

package contests.abc.abc21x.abc211.abc211_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static final long MOD = 1_000_000_007;

  private static final String TARGET = "chokudai";

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    br.close();
    //dp[i][j]:=i文字目まで見て、j文字まで対象文字列と一致している通り数
    final long[][] dp = new long[s.length() + 1][TARGET.length() + 1];
    dp[0][0] = 1;
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j <= TARGET.length(); j++) {
        dp[i + 1][j] += dp[i][j];
        dp[i + 1][j] %= MOD;
        if (j != TARGET.length() && TARGET.charAt(j) == s.charAt(i)) {
          dp[i + 1][j + 1] += dp[i][j];
          dp[i + 1][j + 1] %= MOD;
        }
      }
    }
    System.out.println(dp[s.length()][TARGET.length()]);
  }
}
