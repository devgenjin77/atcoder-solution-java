/*
 * AtCoder Beginner Contest 215
 * E - Chain Contestant
 * https://atcoder.jp/contests/abc215/tasks/abc215_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc215/submissions/32441340
 *
 */

package contests.abc.abc21x.abc215.abc215_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  final static long MOD = 998_244_353L;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String s = br.readLine();
    br.close();
    //dp[i][bit][k]:=i個目までみて、参加したコンテストのパターンがbit且つ最後の参加がk
    long[][][] dp = new long[n + 1][1 << 10][10];
    for (int i = 1; i <= n; i++) {
      int type = s.charAt(i - 1) - 'A';
      for (int bit = 1; bit < 1 << 10; bit++) {
        for (int k = 0; k < 10; k++) {
          //i個目に参加しないパターン
          dp[i][bit][k] += dp[i - 1][bit][k];
          dp[i][bit][k] %= MOD;
          if (type == k) {
            //最後に参加したコンテストと同種のコンテストとして参加
            dp[i][bit][k] += dp[i - 1][bit][k];
            dp[i][bit][k] %= MOD;
          }
        }
        if ((bit >> type & 1) == 0) {
          for (int k = 0; k < 10; k++) {
            //typeに未参加の状態から参加する
            dp[i][bit | (1 << type)][type] += dp[i - 1][bit][k];
            dp[i][bit | (1 << type)][type] %= MOD;
          }
        }
      }
      //初めてtypeのコンテストに参加する
      dp[i][1 << type][type] += 1;
      dp[i][1 << type][type] %= MOD;
    }
    long ans = 0;
    for (int bit = 1; bit < 1 << 10; bit++) {
      for (int k = 0; k < 10; k++) {
        ans += dp[n][bit][k];
        ans %= MOD;
      }
    }
    System.out.println(ans);
  }
}
