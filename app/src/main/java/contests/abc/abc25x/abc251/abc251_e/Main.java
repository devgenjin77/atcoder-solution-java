/*
 * パナソニックグループプログラミングコンテスト2022
 * （AtCoder Beginner Contest 251）
 * E - Takahashi and Animals
 * https://atcoder.jp/contests/abc251/tasks/abc251_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc251/submissions/35183520
 *
 */

package contests.abc.abc25x.abc251.abc251_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static final long INF = 1_000_000_000_000_000L;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final long[] array_a = new long[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
    }
    br.close();
    long ans = INF;
    // dp[i][j]:=行動iをj{0,1}回行なった時のコストの最小値
    final long[][] dp = new long[n + 1][2];
    for (int x = 0; x < 2; x++) {
      Arrays.fill(dp[0], INF);
      dp[0][x] = 0;
      for (int i = 1; i <= n; i++) {
        //行動iを行わないのは、前の行動が行えたときだけ
        dp[i][0] = dp[i - 1][1];
        //行動iを行う時は、一回前の状況のminにi回目のコストを足す
        dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + array_a[i - 1];
      }
      ans = Math.min(dp[n][x], ans);
    }
    System.out.println(ans);
  }
}
