/*
 * ABC242
 * C - 1111gal password
 * https://atcoder.jp/contests/abc242/tasks/abc242_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc242/submissions/29921625
 *
 */
package contests.abc.abc242.abc242_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static final long MOD = 998244353L;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.close();
    long[][] dp = new long[n][10];
    for (int i = 1; i <= 9; i++) {
      dp[0][i] = 1;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j <= 9; j++) {
        for (int k = -1; k <= 1; k++) {
          int next_j = j + k;
          if (next_j >= 1 && next_j <= 9) {
            dp[i][next_j] += dp[i - 1][j];
            dp[i][next_j] %= MOD;
          }
        }
      }
    }
    long ans = 0;
    for (int i = 1; i <= 9; i++) {
      ans += dp[n - 1][i];
    }
    System.out.println(ans % MOD);
  }
}
