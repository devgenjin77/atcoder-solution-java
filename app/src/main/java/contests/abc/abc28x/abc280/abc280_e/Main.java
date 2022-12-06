/*
 * デンソークリエイトプログラミングコンテスト2022
 * （AtCoder Beginner Contest 280）
 * E - Critical Hit
 * https://atcoder.jp/contests/abc280/tasks/abc280_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc280/submissions/37063518
 *
 * note:
 * - 期待値DP
 */

package contests.abc.abc28x.abc280.abc280_e;

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
    final int p = Integer.parseInt(st.nextToken());
    br.close();
    long mod100 = modinv(100, MOD);
    final long[] dp = new long[n + 1];
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      dp[i] += ((dp[i - 2] + 1L) * p % MOD) * mod100 % MOD;
      dp[i] = (dp[i] + MOD) % MOD;
      dp[i] += ((dp[i - 1] + 1L) * (100 - p) % MOD) * mod100 % MOD;
      dp[i] = (dp[i] + MOD) % MOD;
    }
    System.out.println(dp[n]);
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
