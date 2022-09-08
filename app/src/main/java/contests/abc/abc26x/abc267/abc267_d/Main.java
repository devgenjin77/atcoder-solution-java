/*
 * NECプログラミングコンテスト2022
 * （AtCoder Beginner Contest 267）
 * D - Index × A(Not Continuous ver.)
 * https://atcoder.jp/contests/abc267/tasks/abc267_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc267/submissions/34693881
 *
 */

package contests.abc.abc26x.abc267.abc267_d;

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
    final int m = Integer.parseInt(st.nextToken());
    final long[] array_a = new long[n];
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
    }
    br.close();

    final long[][] dp = new long[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      Arrays.fill(dp[i], -100_000_000_000_000_00L);
      dp[i][0] = 0;
    }
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= Math.min(i, m); j++) {
        dp[i][j] = Math.max(dp[i - 1][j - 1] + (j * array_a[i - 1]), dp[i - 1][j]);
      }
    }
    System.out.println(dp[n][m]);
  }
}
