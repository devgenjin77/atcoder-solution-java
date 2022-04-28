/*
 * Educational DP Contest / DP まとめコンテスト
 * F - LCS
 * https://atcoder.jp/contests/dp/tasks/dp_f
 *
 * verified:
 * - https://atcoder.jp/contests/dp/submissions/31327382
 *
 * note:
 * LCS 最長共通部分列問題
 */

package contests.dp.dp_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    String t = br.readLine();
    br.close();
    int[][] dp = new int[s.length() + 1][t.length() + 1];
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < t.length(); j++) {
        if (s.charAt(i) == t.charAt(j)) {
          dp[i + 1][j + 1] = dp[i][j] + 1;
        } else {
          dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
        }
      }
    }
    StringBuilder ans = new StringBuilder();
    int idx_s = s.length(), idx_t = t.length();
    while (idx_s > 0 && idx_t > 0) {
      if (s.charAt(idx_s - 1) == t.charAt(idx_t - 1)) {
        ans.append(s.charAt(idx_s - 1));
        idx_s--;
        idx_t--;
      } else {
        if (dp[idx_s - 1][idx_t] > dp[idx_s][idx_t - 1]) {
          idx_s--;
        } else {
          idx_t--;
        }
      }
    }
    System.out.println(ans.reverse().toString());
  }
}
