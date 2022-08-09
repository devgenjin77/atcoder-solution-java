/*
 * M-SOLUTIONS プロコンオープン2021
 * （AtCoder Beginner Contest 232）
 * D - Weak Takahashi
 * https://atcoder.jp/contests/abc232/tasks/abc232_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc232/submissions/33904381
 *
 * note:
 *
 *
 */

package contests.abc.abc23x.abc232.abc232_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int h = Integer.parseInt(st.nextToken());
    final int w = Integer.parseInt(st.nextToken());
    final String[] grid = new String[h];
    for (int i = 0; i < h; i++) {
      grid[i] = br.readLine();
    }
    br.close();
    final int[][] dp = new int[h][w];
    dp[0][0] = 1;
    int ans = 1;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if ((i == 0 && j == 0) || grid[i].charAt(j) == '#') {
          continue;
        }
        if (i > 0 && dp[i - 1][j] > 0) {
          dp[i][j] = Math.max(dp[i - 1][j] + 1, dp[i][j]);
        }
        if (j > 0 && dp[i][j - 1] > 0) {
          dp[i][j] = Math.max(dp[i][j - 1] + 1, dp[i][j]);
        }
        ans = Math.max(dp[i][j], ans);
      }
    }
    System.out.println(ans);
  }
}
