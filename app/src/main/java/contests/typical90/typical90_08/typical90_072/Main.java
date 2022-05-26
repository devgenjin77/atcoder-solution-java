/*
 * 競プロ典型90問
 * 072 - Loop Railway Plan（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bt
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31965444
 *
 * note:
 * -バックトラックを使う
 *
 */

package contests.typical90.typical90_08.typical90_072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int H, W;

  static String[] grid;

  static int[][] steps;

  static final int[] dh = new int[]{-1, 1, 0, 0};

  static final int[] dw = new int[]{0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    H = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    grid = new String[H];
    for (int i = 0; i < H; i++) {
      grid[i] = br.readLine();
    }
    steps = new int[H][W];
    br.close();

    int ans = -1;
    for (int pos_h = 0; pos_h < H; pos_h++) {
      for (int pos_w = 0; pos_w < W; pos_w++) {
        if (grid[pos_h].charAt(pos_w) == '.') {
          ans = Math.max(dfs(pos_h, pos_w, 1), ans);
        }
      }
    }
    System.out.println(ans);
  }

  static int dfs(int h, int w, int level) {
    int ret = -1;
    steps[h][w] = level;
    for (int i = 0; i < 4; i++) {
      int next_h = h + dh[i];
      int next_w = w + dw[i];
      if (!(next_h >= 0 && next_h < H && next_w >= 0 && next_w < W)) {
        continue;
      }
      if (grid[next_h].charAt(next_w) == '#') {
        continue;
      }
      if (steps[next_h][next_w] == 0) {
        ret = Math.max(dfs(next_h, next_w, level + 1), ret);
      } else if (steps[next_h][next_w] == 1 && level > 2) {
        ret = Math.max(level, ret);
      }
    }
    steps[h][w] = 0;
    return ret;
  }
}
