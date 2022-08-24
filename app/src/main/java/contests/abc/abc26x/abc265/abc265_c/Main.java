/*
 * AtCoder Beginner Contest 265
 * C - Belt Conveyor
 * https://atcoder.jp/contests/abc265/tasks/abc265_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc265/submissions/34312702
 *
 * note:
 *
 *
 */

package contests.abc.abc26x.abc265.abc265_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private final static int[] dh = {-1, 1, 0, 0};

  private final static int[] dw = {0, 0, -1, 1};

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
    final boolean[][] visited = new boolean[h][w];
    boolean isLoop = false;
    int pos_h = 0, pos_w = 0;
    visited[0][0] = true;
    while (true) {
      int dir = "UDLR".indexOf(grid[pos_h].charAt(pos_w));
      int next_pos_h = pos_h + dh[dir];
      int next_pos_w = pos_w + dw[dir];
      if (next_pos_h >= 0 && next_pos_h < h && next_pos_w >= 0 && next_pos_w < w) {
        pos_h = next_pos_h;
        pos_w = next_pos_w;
      } else {
        break;
      }

      if (visited[pos_h][pos_w]) {
        isLoop = true;
        break;
      } else {
        visited[pos_h][pos_w] = true;
      }
    }
    if (isLoop) {
      System.out.println(-1);
    } else {
      System.out.println(String.format("%d %d", pos_h + 1, pos_w + 1));
    }
  }
}
