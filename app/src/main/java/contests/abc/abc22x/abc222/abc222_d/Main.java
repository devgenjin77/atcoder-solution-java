/*
 * エクサウィザーズプログラミングコンテスト2021
 * （AtCoder Beginner Contest 222）
 * D - Between Two Arrays
 * https://atcoder.jp/contests/abc222/tasks/abc222_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc222/submissions/33254622
 *
 * note:
 * 累積和をDPで管理する
 *
 */

package contests.abc.abc22x.abc222.abc222_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static final long MOD = 998244353L;

  static final int MAX_AB = 3000;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final StringTokenizer st_b = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    final int[] array_b = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
      array_b[i] = Integer.parseInt(st_b.nextToken());
    }
    br.close();

    // dp[i][j]:=数列Cをi番目までみた時に、末尾がjである通り数
    long[][] dp = new long[n + 1][MAX_AB + 1];
    dp[0][0] = 1;

    for (int i = 1; i <= n; i++) {
      long cnt = 0;
      for (int j = 0; j < array_a[i - 1]; j++) {
        cnt += dp[i - 1][j];
        cnt %= MOD;
      }
      for (int j = array_a[i - 1]; j <= array_b[i - 1]; j++) {
        cnt += dp[i - 1][j];
        cnt %= MOD;
        dp[i][j] = cnt;
      }
    }
    long ans = 0;
    for (int i = 0; i <= MAX_AB; i++) {
      ans += dp[n][i];
      ans %= MOD;
    }
    System.out.println(ans);
  }
}
