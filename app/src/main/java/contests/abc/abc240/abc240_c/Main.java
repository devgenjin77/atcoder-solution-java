/*
 * ABC240
 * C - Jumping Takahashi
 * https://atcoder.jp/contests/abc240/tasks/abc240_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc240/submissions/29643305
 *
 */
package contests.abc.abc240.abc240_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int x = Integer.parseInt(input[1]);
    // dp[i][j]:=i回目のジャンプで座標jにいる場合1
    int[][] dp = new int[n + 1][x + 1];
    dp[0][0] = 1;
    for (int j = 0; j < n; j++) {
      String[] ab = br.readLine().split(" ");
      int a = Integer.parseInt(ab[0]);
      int b = Integer.parseInt(ab[1]);
      for (int prev_x = 0; prev_x <= x; prev_x++) {
        if (dp[j][prev_x] == 1) {
          if (prev_x + a <= x) {
            dp[j + 1][prev_x + a] = 1;
          }
          if (prev_x + b <= x) {
            dp[j + 1][prev_x + b] = 1;
          }
        }
      }
    }
    br.close();
    System.out.println(dp[n][x] == 1 ? "Yes" : "No");
  }
}
