/*
 * AtCoder Beginner Contest 276
 * E - Round Trip
 * https://atcoder.jp/contests/abc276/tasks/abc276_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc276/submissions/36291781
 *
 * note:
 *
 *
 */

package contests.abc.abc27x.abc276.abc276_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  private static final int[] d_h = {-1, 1, 0, 0};

  private static final int[] d_w = {0, 0, -1, 1};

  private static final String DIRS = "UDLR";

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int h = Integer.parseInt(st.nextToken());
    final int w = Integer.parseInt(st.nextToken());
    final String[] grid = new String[h];
    final int[][] dir_from_s = new int[h][w];
    int start_h = -1, start_w = -1;
    for (int i = 0; i < h; i++) {
      Arrays.fill(dir_from_s[i], -1);
      grid[i] = br.readLine();
      if (start_h < 0) {
        int idx = grid[i].indexOf('S');
        if (idx >= 0) {
          start_h = i;
          start_w = idx;
        }
      }
    }
    br.close();
    final Queue<Player> queue = new ArrayDeque<>();
    //最初に、スタート地点から上下左右を試す。
    for (int i = 0; i < 4; i++) {
      int next_h = start_h + d_h[i];
      int next_w = start_w + d_w[i];
      if (next_h < 0 || next_h >= h || next_w < 0 || next_w >= w) {
        continue;
      }
      if (grid[next_h].charAt(next_w) == '.') {
        dir_from_s[next_h][next_w] = i;
        queue.add(new Player(next_h, next_w, i));
      }
    }
    boolean isOk = false;
    main_loop:
    while (!queue.isEmpty()) {
      Player p = queue.poll();
      for (int i = 0; i < 4; i++) {
        int next_h = p.pos_h + d_h[i];
        int next_w = p.pos_w + d_w[i];
        if (next_h < 0 || next_h >= h || next_w < 0 || next_w >= w) {
          continue;
        }
        char c = grid[next_h].charAt(next_w);
        if (c == '.') {
          if (dir_from_s[next_h][next_w] == -1) {
            dir_from_s[next_h][next_w] = p.dir;
            queue.add(new Player(next_h, next_w, p.dir));
          } else if (dir_from_s[next_h][next_w] != p.dir) {
            isOk = true;
            break main_loop;
          }
        }
      }
    }
    System.out.println(isOk ? "Yes" : "No");
  }

  static class Player {

    int pos_h, pos_w, dir;

    public Player(int pos_h, int pos_w, int dir) {
      this.pos_h = pos_h;
      this.pos_w = pos_w;
      this.dir = dir;
    }
  }
}

