/*
 * ABC237
 * F - |LIS| = 3
 * https://atcoder.jp/contests/abc237/tasks/abc237_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc237/submissions/29029995
 *
 */
package contests.abc.abc237.abc237_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static final long MOD = 998244353;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer data = new StringTokenizer(br.readLine());
    br.close();
    int n = Integer.parseInt(data.nextToken());
    int m = Integer.parseInt(data.nextToken());
    //dp[i][a1][a2][a3] := i個の数列で、長さ3のLISの1-3番目がそれぞれa1-a3番目となる通り数
    long dp[][][][] = new long[n + 1][m + 2][m + 2][m + 2];
    dp[0][m + 1][m + 1][m + 1] = 1;
    for (int i = 1; i <= n; i++) {
      for (int a1 = 1; a1 <= m + 1; a1++) {
        for (int a2 = a1; a2 <= m + 1; a2++) {
          for (int a3 = a2; a3 <= m + 1; a3++) {
            long now = dp[i - 1][a1][a2][a3];
            if(now > 0){
              for (int x = 1; x <= m; x++) {
                if (x <= a1) {
                  dp[i][x][a2][a3] += now;
                  dp[i][x][a2][a3] %= MOD;
                } else if (x <= a2) {
                  dp[i][a1][x][a3] += now;
                  dp[i][a1][x][a3] %= MOD;
                } else if (x <= a3) {
                  dp[i][a1][a2][x] += now;
                  dp[i][a1][a2][x] %= MOD;
                }
              }
            }
          }
        }
      }
    }
    long ans = 0;
    for (int a1 = 1; a1 <= m; a1++) {
      for (int a2 = a1; a2 <= m; a2++) {
        for (int a3 = a2; a3 <= m; a3++) {
          ans += dp[n][a1][a2][a3];
          ans %= MOD;
        }
      }
    }
    System.out.println(ans);
  }
}
