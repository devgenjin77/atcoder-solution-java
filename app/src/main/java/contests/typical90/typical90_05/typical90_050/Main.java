/*
 * 競プロ典型90問
 * 050 - Stair Jump（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ax
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31933581
 *
 * note:
 * -漸化式を立ててDPをする
 *
 */

package contests.typical90.typical90_05.typical90_050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static final long MOD = 1_000_000_007L;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());
    br.close();

    //dp[i]:=i段目への移動方法が何通りあるか
    long[] dp = new long[n + 1];
    dp[0] = 1;
    for (int step = 1; step <= n; step++) {
      dp[step] += dp[step - 1];
      if (step >= l) {
        dp[step] += dp[step - l];
      }
      dp[step] %= MOD;
    }
    System.out.println(dp[n]);
  }
}
