/*
 * AtCoder Beginner Contest 204
 * D - Cooking
 * https://atcoder.jp/contests/abc204/tasks/abc204_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc204/submissions/37960657
 *
 * note:
 *
 *
 */

package contests.abc.abc20x.abc204.abc204_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static final int MAX = 100_000;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_t = new StringTokenizer(br.readLine());
    final int[] array_t = new int[n];
    int total = 0;
    for (int i = 0; i < n; i++) {
      array_t[i] = Integer.parseInt(st_t.nextToken());
      total += array_t[i];
    }
    br.close();
    //dp[i][j]:=i個まで見て、使った時間の合計がjになるか
    final boolean[][] dp = new boolean[n + 1][MAX + 1];
    dp[0][0] = true;
    for (int i = 1; i <= n; i++) {
      int t = array_t[i - 1];
      for (int j = 0; j < MAX; j++) {
        if (dp[i - 1][j]) {
          //オーブンを使わない
          dp[i][j] = true;
          //オーブンを使う
          dp[i][j + t] = true;
        }
      }
    }
    int ans = MAX;
    for (int i = 1; i <= MAX; i++) {
      if (dp[n][i]) {
        ans = Math.min(Math.max(i, total - i), ans);
      }
    }
    System.out.println(ans);
  }
}
