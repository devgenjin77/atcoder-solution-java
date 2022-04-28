/*
 * Educational DP Contest / DP まとめコンテスト
 * H - Grid 1
 * https://atcoder.jp/contests/dp/tasks/dp_h
 *
 * verified:
 * - https://atcoder.jp/contests/dp/submissions/31328787
 *
 */


package contests.dp.dp_h;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static final long MOD = 1_000_000_007L;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] hw = br.readLine().split(" ");
    int h = Integer.parseInt(hw[0]);
    int w = Integer.parseInt(hw[1]);
    char[][] grid = new char[h][];
    for (int i = 0; i < h; i++) {
      grid[i] = br.readLine().toCharArray();
    }
    br.close();
    //dp[i][j]:=マス(i,j)への経路が何通りか。
    long[][] dp = new long[h + 1][w + 1];
    dp[1][1] = 1;
    for (int pos_h = 1; pos_h <= h; pos_h++) {
      for (int pos_w = 1; pos_w <= w; pos_w++) {
        if (pos_h == 1 && pos_w == 1) {
          continue;
        }
        if (grid[pos_h - 1][pos_w - 1] == '#') {
          continue;
        } else {
          dp[pos_h][pos_w] = (dp[pos_h - 1][pos_w] + dp[pos_h][pos_w - 1]) % MOD;
        }
      }
    }
    System.out.println(dp[h][w]);
  }
}
