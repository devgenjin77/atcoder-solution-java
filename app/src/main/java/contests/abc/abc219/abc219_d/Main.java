/*
 * サイシードプログラミングコンテスト2021（AtCoder Beginner Contest 219）
 * D - Strange Lunchbox
 * https://atcoder.jp/contests/abc219/tasks/abc219_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc219/submissions/25999160
 */
package contests.abc.abc219.abc219_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] xy = br.readLine().split(" ");
    int x = Integer.parseInt(xy[0]);
    int y = Integer.parseInt(xy[1]);
    //dp[i][j][k]:=i個目まで見た時のたこ焼きj個、たい焼きk個入手できる弁当の最小個数
    int[][][] dp = new int[n + 1][x + 1][y + 1];
    for(int i = 0; i <= n; i++){
      for(int j = 0; j <= x; j++) {
        Arrays.fill(dp[i][j], Integer.MAX_VALUE);
      }
    }
    dp[0][0][0] = 0;
    for(int i = 0; i < n; i++){
      String[] ab = br.readLine().split(" ");
      int a = Integer.parseInt(ab[0]);
      int b = Integer.parseInt(ab[1]);
      for(int j = 0; j <= x; j++){
        for(int k = 0; k <= y; k++){
          if(dp[i][j][k] != Integer.MAX_VALUE){
            //選ばない場合
            dp[i + 1][j][k] = Math.min(dp[i][j][k], dp[i + 1][j][k]);
            //選ぶ場合
            int next_j = Math.min(j + a, x);
            int next_k = Math.min(k + b, y);
            dp[i + 1][next_j][next_k] = Math.min(dp[i][j][k] + 1, dp[i + 1][next_j][next_k]);
          }
        }
      }
    }
    br.close();
    System.out.println(dp[n][x][y] == Integer.MAX_VALUE ? -1 : dp[n][x][y]);
  }
}
