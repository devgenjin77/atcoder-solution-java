/*
 * 競プロ典型90問
 * 043 - Maze Challenge with Lack of Sleep（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_aq
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28328430
 *
 */
package contests.typical90.typical90_043;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

  final static int DIR_UP = 0;
  final static int DIR_DOWN = 1;
  final static int DIR_LEFT = 2;
  final static int DIR_RIGHT = 3;
  final static int DIR_NONE = 9;
  final static int[] UDLR = {DIR_UP, DIR_DOWN, DIR_LEFT, DIR_RIGHT};
  //上、下、左、右の順で定義
  final static int[] V_ROW = {0, 0, -1, 1};
  final static int[] V_COL = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    String[] hw = br.readLine().split(" ");
    int h = Integer.parseInt(hw[0]);
    int w = Integer.parseInt(hw[1]);
    String[] pos_from = br.readLine().split(" ");
    String[] pos_to = br.readLine().split(" ");
    int rs = Integer.parseInt(pos_from[0]) - 1;
    int cs = Integer.parseInt(pos_from[1]) - 1;
    int rt = Integer.parseInt(pos_to[0]) - 1;
    int ct = Integer.parseInt(pos_to[1]) - 1;
    String[] map = new String[h];
    for (int i = 0; i < h; i++) {
      map[i] = br.readLine();
    }
    br.close();

    int ans = Integer.MAX_VALUE;
    int[][][] min_cost = new int[h][w][4];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        Arrays.fill(min_cost[i][j], Integer.MAX_VALUE);
      }
    }
    Arrays.fill(min_cost[rs][cs], 0);

    Deque<Player> queue = new ArrayDeque<>();
    queue.add(new Player(rs, cs, DIR_NONE, 0));

    while (!queue.isEmpty()) {
      Player p = queue.poll();
      if (p.cost >= ans) {
        continue;
      }
      for (int next_dir : UDLR) {
        if (isOppositeDir(p.now_d, next_dir)) {
          //真逆方向への転換は無駄に計算が増えるだけなので無視
          continue;
        }
        int next_r = p.pos_r + V_ROW[next_dir];
        int next_c = p.pos_c + V_COL[next_dir];
        int next_cost = p.now_d == next_dir ? p.cost : p.cost + 1;
        if (next_r == rt && next_c == ct) {
          ans = Math.min(next_cost, ans);
          continue;
        }
        if (next_r >= 0 && next_r < h && next_c >= 0 && next_c < w
            && map[next_r].charAt(next_c) != '#'
            && min_cost[next_r][next_c][next_dir] > next_cost) {
          Player next = new Player(next_r, next_c, next_dir, next_cost);
          min_cost[next_r][next_c][next_dir] = next_cost;
          if (p.cost == next_cost) {
            queue.addFirst(next);
          } else {
            queue.addLast(next);
          }
        }
      }

    }
    System.out.println(ans - 1);
  }

  static boolean isOppositeDir(int dir1, int dir2) {
    return (dir1 == DIR_UP && dir2 == DIR_DOWN) || (dir1 == DIR_DOWN && dir2 == DIR_UP) || (
        dir1 == DIR_LEFT && dir2 == DIR_RIGHT) || (dir1 == DIR_RIGHT && dir2 == DIR_LEFT);
  }

  static class Player {

    int pos_r, pos_c, now_d, cost;

    Player(int pos_r, int pos_c, int now_d, int cost) {
      this.pos_r = pos_r;
      this.pos_c = pos_c;
      this.now_d = now_d;
      this.cost = cost;
    }
  }
}
