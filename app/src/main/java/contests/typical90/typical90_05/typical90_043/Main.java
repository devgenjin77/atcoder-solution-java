/*
 * 競プロ典型90問
 * 043 - Maze Challenge with Lack of Sleep（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_aq
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31931391
 *
 * note:
 * -01-BFSを使う
 *
 */

package contests.typical90.typical90_05.typical90_043;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

  static final int[] dr = new int[]{-1, 1, 0, 0};

  static final int[] dc = new int[]{0, 0, -1, 1};

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int h = Integer.parseInt(sc.next());
    int w = Integer.parseInt(sc.next());
    int rs = Integer.parseInt(sc.next()) - 1;
    int cs = Integer.parseInt(sc.next()) - 1;
    int rt = Integer.parseInt(sc.next()) - 1;
    int ct = Integer.parseInt(sc.next()) - 1;
    String[] grid = new String[h];
    for (int i = 0; i < h; i++) {
      grid[i] = sc.next();
    }
    sc.close();

    int[][] tbl_cost = new int[h][w];
    for (int[] r : tbl_cost) {
      Arrays.fill(r, Integer.MAX_VALUE);
    }
    Deque<Player> queue = new ArrayDeque<>();
    queue.addLast(new Player(rs, cs, -1, 0));
    tbl_cost[rs][cs] = 0;
    while (!queue.isEmpty()) {
      Player p = queue.poll();
      if (p.pos_r == rt && p.pos_c == ct) {
        break;
      }
      if (tbl_cost[p.pos_r][p.pos_c] < p.cost) {
        continue;
      }
      for (int i = 0; i < 4; i++) {
        int next_r = p.pos_r + dr[i];
        int next_c = p.pos_c + dc[i];
        int next_cost = p.now_d == i ? p.cost : p.cost + 1;
        if (!(next_r >= 0 && next_r < h && next_c >= 0 && next_c < w)
            || grid[next_r].charAt(next_c) == '#') {
          continue;
        }
        if (tbl_cost[next_r][next_c] >= next_cost) {
          tbl_cost[next_r][next_c] = next_cost;
          if (p.cost == next_cost) {
            queue.addFirst(new Player(next_r, next_c, i, next_cost));
          } else {
            queue.addLast(new Player(next_r, next_c, i, next_cost));
          }
        }
      }
    }
    System.out.println(tbl_cost[rt][ct] - 1);
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

  //NextScannerライブラリ
  static class NextScanner implements AutoCloseable {

    private final java.io.BufferedReader br;

    private java.util.StringTokenizer st;

    private static final int BUF_SIZE = 1 << 16;

    private static final char[] c_buf = new char[BUF_SIZE];

    public NextScanner(java.io.InputStream input) {
      this.br = new java.io.BufferedReader(new java.io.InputStreamReader(input));
    }

    private java.util.StringTokenizer readInput() {
      java.util.StringTokenizer st;
      try {
        int b = br.read(c_buf);
        if (b == BUF_SIZE) {
          StringBuilder sb = new StringBuilder();
          sb.append(c_buf);
          sb.append(br.readLine());
          st = new java.util.StringTokenizer(sb.toString());
        } else if (b < 0) {
          throw new java.util.NoSuchElementException();
        } else {
          st = new java.util.StringTokenizer(new String(c_buf, 0, b));
        }
      } catch (java.io.IOException e) {
        throw new java.util.InputMismatchException(e.getMessage());
      }
      return st;
    }

    public String next() throws java.io.IOException {
      if (st == null || !st.hasMoreElements()) {
        st = readInput();
      }
      return st.nextToken();
    }

    @Override
    public void close() throws Exception {
      br.close();
    }
  }
}
