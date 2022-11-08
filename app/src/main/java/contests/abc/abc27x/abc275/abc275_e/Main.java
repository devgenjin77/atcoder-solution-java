/*
 * AtCoder Beginner Contest 275
 * E - Sugoroku 4
 * https://atcoder.jp/contests/abc275/tasks/abc275_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc275/submissions/36325442
 *
 * note:
 *
 */

package contests.abc.abc27x.abc275.abc275_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static final long MOD = 998244353L;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final int k = Integer.parseInt(st.nextToken());
    br.close();

    final long inv_m = modinv(m, MOD);
    final long[][] dp = new long[k + 1][n + 1];
    dp[0][0] = 1; //初期値
    for (int i = 0; i < k; i++) {
      //dp[?][n]の確率のみ移す
      dp[i + 1][n] = dp[i][n];
      for (int j = 0; j < n; j++) {
        if (dp[i][j] == 0) {
          continue;
        }
        for (int dice = 1; dice <= m; dice++) {
          int dist = j + dice <= n ? j + dice : (2 * n) - (j + dice);
          dp[i + 1][dist] += (dp[i][j] * inv_m) % MOD;
          dp[i + 1][dist] %= MOD;
        }
      }
    }
    System.out.println(dp[k][n]);
  }

  static long modinv(long a, long m) {
    long b = m;
    long u = 1;
    long v = 0;
    long tmp = 0;

    while (b > 0) {
      long t = a / b;
      a -= t * b;
      tmp = a;
      a = b;
      b = tmp;

      u -= t * v;
      tmp = u;
      u = v;
      v = tmp;
    }

    u %= m;
    if (u < 0) {
      u += m;
    }
    return u;
  }
}
