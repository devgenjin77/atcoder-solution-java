/*
 * AtCoder Beginner Contest 242
 * C - 1111gal password
 * https://atcoder.jp/contests/abc242/tasks/abc242_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc242/submissions/33967973
 *
 * note:
 * DPする
 */

package contests.abc.abc24x.abc242.abc242_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static final long MOD = 998244353L;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    // dp[i][j]:=i桁目までみて、末桁がjの数字の通り数
    final long[][] dp = new long[n][10];
    //初期値
    for (int d = 1; d <= 9; d++) {
      dp[0][d] = 1;
    }
    //遷移
    for (int i = 0; i < n - 1; i++) {
      for (int d = 1; d <= 9; d++) {
        for (int x = -1; x <= 1; x++) {
          int next = d + x;
          if (next >= 1 && next <= 9) {
            dp[i + 1][next] += dp[i][d];
            dp[i + 1][next] %= MOD;
          }
        }
      }
    }
    long ans = 0;
    for (int d = 1; d <= 9; d++) {
      ans += dp[n - 1][d];
      ans %= MOD;
    }
    System.out.println(ans);
  }
}
