/*
 * 競プロ典型90問
 * 072 - Loop Railway Plan（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bt
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28996767
 *
 */
package contests.typical90.typical90_072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int ans;
  static String[] field_map;
  static boolean[][] used_flg;

  //上、下、左、右の順で定義
  final static int[] dir_h = {-1, 1, 0, 0};
  final static int[] dir_w = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    used_flg = new boolean[h][w];
    field_map = new String[h];
    for (int i = 0; i < h; i++) {
      field_map[i] = br.readLine();
      Arrays.fill(used_flg[i], false);
    }
    br.close();
    ans = -1;
    for (int pos_h = 0; pos_h < h; pos_h++) {
      for (int pos_w = 0; pos_w < w; pos_w++) {
        dfs(pos_h, pos_w, pos_h, pos_w, 0);
      }
    }
    System.out.println(ans);
  }

  static void dfs(int st_pos_h, int st_pos_w, int cur_pos_h, int cur_pos_w, int level) {
    if (level != 0 && st_pos_h == cur_pos_h && st_pos_w == cur_pos_w) {
      if (level > 2) {
        ans = Math.max(level, ans);
      }
      return;
    }
    for (int dir = 0; dir < 4; dir++) {
      int next_pos_h = cur_pos_h + dir_h[dir];
      int next_pos_w = cur_pos_w + dir_w[dir];
      if (next_pos_h < 0 || next_pos_w < 0 || next_pos_h >= field_map.length
          || next_pos_w >= field_map[next_pos_h].length()) {
        continue;
      }
      if (field_map[next_pos_h].charAt(next_pos_w) == '.'
          && !used_flg[next_pos_h][next_pos_w]) {
        used_flg[next_pos_h][next_pos_w] = true;
        dfs(st_pos_h, st_pos_w, next_pos_h, next_pos_w, level + 1);
        used_flg[next_pos_h][next_pos_w] = false;
      }
    }
  }
}
