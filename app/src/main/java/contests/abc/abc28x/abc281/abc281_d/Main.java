/*
 * AtCoder Beginner Contest 281
 * D - Max Multiple
 * https://atcoder.jp/contests/abc281/tasks/abc281_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc281/submissions/37217657
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc281.abc281_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int k = Integer.parseInt(st.nextToken());
    final int d = Integer.parseInt(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final long[] array_a = new long[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
    }
    br.close();
    // dp[i][j][k]:= i個までみて、j個使った時、mod_dがkの値の最大
    final long[][][] dp = new long[n + 1][k + 1][d];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= k; j++) {
        Arrays.fill(dp[i][j], -1);
      }
    }
    dp[0][0][0] = 0;
    for (int i1 = 0; i1 < n; i1++) {
      long a = array_a[i1];
      for (int i2 = 0; i2 <= k; i2++) {
        for (int i3 = 0; i3 < d; i3++) {
          if (dp[i1][i2][i3] >= 0) {
            //採用しない
            dp[i1 + 1][i2][i3] = Math.max(dp[i1][i2][i3], dp[i1 + 1][i2][i3]);
            if (i2 < k) {
              //採用する
              long next_val = dp[i1][i2][i3] + a;
              int next_mod = (int) (next_val % (long) d);
              dp[i1 + 1][i2 + 1][next_mod] = Math.max(next_val, dp[i1 + 1][i2 + 1][next_mod]);
            }
          }
        }
      }
    }
    System.out.println(dp[n][k][0]);
  }
}
