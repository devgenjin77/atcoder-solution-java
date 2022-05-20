/*
 * ABC213
 * E - Stronger Takahashi
 * https://atcoder.jp/contests/abc213/tasks/abc213_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc213/submissions/31816796
 *
 * note:
 * 01-BFS
 */

package contests.abc.abc21x.abc213.abc213_e;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

  final static int[] dh = new int[]{-1, 1, 0, 0};

  final static int[] dw = new int[]{0, 0, -1, 1};

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int h = Integer.parseInt(sc.next());
    int w = Integer.parseInt(sc.next());
    String[] grid = new String[h];
    for (int i = 0; i < h; i++) {
      grid[i] = sc.next();
    }
    sc.close();
    int[][] tbl_cost = new int[h][w];
    for (int[] row : tbl_cost) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    Deque<Player> queue = new ArrayDeque<>();
    queue.add(new Player(0, 0, 0));
    tbl_cost[0][0] = 0;
    while (!queue.isEmpty()) {
      Player p = queue.pollFirst();
      for (int i = 0; i < 4; i++) {
        int next_h = p.pos_h + dh[i];
        int next_w = p.pos_w + dw[i];
        if (!(next_h >= 0 && next_h < h && next_w >= 0 && next_w < w)) {
          continue;
        }
        if (grid[next_h].charAt(next_w) == '.') {
          if (tbl_cost[next_h][next_w] > p.cost) {
            queue.addFirst(new Player(next_h, next_w, p.cost));
            tbl_cost[next_h][next_w] = p.cost;
          }
        } else {
          for (int tmp_h = next_h - 1; tmp_h <= next_h + 1; tmp_h++) {
            for (int tmp_w = next_w - 1; tmp_w <= next_w + 1; tmp_w++) {
              if (!(tmp_h >= 0 && tmp_h < h && tmp_w >= 0 && tmp_w < w)) {
                continue;
              }
              if (grid[tmp_h].charAt(tmp_w) == '#' && tbl_cost[tmp_h][tmp_w] > p.cost + 1) {
                queue.addLast(new Player(tmp_h, tmp_w, p.cost + 1));
                tbl_cost[tmp_h][tmp_w] = p.cost + 1;
              }
            }
          }
        }
      }
    }
    System.out.println(tbl_cost[h - 1][w - 1]);
  }

  static class Player {

    final int pos_h, pos_w, cost;

    public Player(int pos_h, int pos_w, int cost) {
      this.pos_h = pos_h;
      this.pos_w = pos_w;
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
