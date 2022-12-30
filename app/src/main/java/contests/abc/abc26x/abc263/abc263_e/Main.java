/*
 * LINE Verda プログラミングコンテスト
 * （AtCoder Beginner Contest 263）
 * E - Sugoroku 3
 * https://atcoder.jp/contests/abc263/tasks/abc263_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc263/submissions/37638804
 *
 * note:
 * 期待値DP
 * マスNからスタート地点に戻る過程で期待値を求めていく
 *
 */

package contests.abc.abc26x.abc263.abc263_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static final long MOD = 998_244_353L;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final long[] array_a = new long[n - 1];
    for (int i = 0; i < n - 1; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
    }
    br.close();
    final long[] dp = new long[n];
    final long[] sum = new long[n + 1];
    for (int i = n - 2; i >= 0; i--) {
      long m = modinv(array_a[i], MOD);
      dp[i] = ((sum[i + 1] - sum[i + (int) array_a[i] + 1]) * m) % MOD;
      dp[i] += ((array_a[i] + 1L) * m) + MOD;
      dp[i] %= MOD;
      sum[i] = sum[i + 1] + dp[i] + MOD;
      sum[i] %= MOD;
    }
    System.out.println(dp[0]);
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
