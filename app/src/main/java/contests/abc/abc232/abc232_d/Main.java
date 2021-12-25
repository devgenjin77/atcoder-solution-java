/*
 * ABC232
 * D - Weak Takahashi
 * https://atcoder.jp/contests/abc232/tasks/abc232_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc232/submissions/28103124
 */
package contests.abc.abc232.abc232_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] hw = br.readLine().split(" ");
    int h = Integer.parseInt(hw[0]);
    int w = Integer.parseInt(hw[1]);
    String[] map = new String[h];
    int[][] dp = new int[h + 1][w + 1];
    for (int i = 0; i < h; i++) {
      map[i] = br.readLine();
    }
    br.close();
    for (int pos_h = h - 1; pos_h >= 0; pos_h--) {
      for (int pos_w = w - 1; pos_w >= 0; pos_w--) {
        if (map[pos_h].charAt(pos_w) == '#') {
          continue;
        } else {
          // 下からの遷移
          dp[pos_h][pos_w] = dp[pos_h + 1][pos_w] + 1;
          // 右からの遷移
          dp[pos_h][pos_w] = Math.max(dp[pos_h][pos_w + 1] + 1, dp[pos_h][pos_w]);
        }
      }
    }
    System.out.println(dp[0][0]);
  }
}
