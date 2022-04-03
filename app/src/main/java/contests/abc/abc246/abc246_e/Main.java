/*
 * ABC246
 * E - Bishop 2
 * https://atcoder.jp/contests/abc246/tasks/abc246_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc246/submissions/30707138
 *
 */

package contests.abc.abc246.abc246_e;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

  //左上、右上、右下、左下の順に定義
  static int[] dx = {-1, -1, 1, 1};
  static int[] dy = {-1, 1, 1, -1};

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    int n = fs.nextInt();
    int ax = fs.nextInt() - 1;
    int ay = fs.nextInt() - 1;
    int bx = fs.nextInt() - 1;
    int by = fs.nextInt() - 1;
    String[] map = new String[n];
    for (int i = 0; i < n; i++) {
      map[i] = fs.next();
    }
    fs.close();
    int[][] tbl_cost = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(tbl_cost[i], Integer.MAX_VALUE);
    }
    Queue<Piece> queue = new ArrayDeque<>();
    queue.add(new Piece(ax, ay, -1));
    tbl_cost[ax][ay] = 0;
    while (!queue.isEmpty()) {
      Piece p = queue.poll();
      for (int next_dir = 0; next_dir < 4; next_dir++) {
        // 以前と同一方向かまたは逆方向の場合は調べない
        if (p.dir == next_dir || isOppositeDir(p.dir, next_dir)) {
          continue;
        }
        int nx_x = p.pos_x + dx[next_dir];
        int nx_y = p.pos_y + dy[next_dir];
        int nx_ct = tbl_cost[p.pos_x][p.pos_y] + 1;
        while (nx_x >= 0 && nx_x < n && nx_y >= 0 && nx_y < n && map[nx_x].charAt(nx_y) == '.') {
          if (tbl_cost[nx_x][nx_y] > nx_ct) {
            tbl_cost[nx_x][nx_y] = nx_ct;
            queue.add(new Piece(nx_x, nx_y, next_dir));
          } else if (tbl_cost[nx_x][nx_y] < nx_ct) {
            break;
          }
          nx_x += dx[next_dir];
          nx_y += dy[next_dir];
        }
      }
    }
    System.out.println(tbl_cost[bx][by] != Integer.MAX_VALUE ? tbl_cost[bx][by] : -1);
  }

  static boolean isOppositeDir(int a, int b) {
    if (a >= 0 && b >= 0 && Math.abs(a - b) == 2) {
      return true;
    } else {
      return false;
    }
  }

  static class Piece {

    int pos_x, pos_y, dir;

    Piece(int x, int y, int dir) {
      this.pos_x = x;
      this.pos_y = y;
      this.dir = dir;
    }
  }

  //FastScanner ライブラリ
  static class FastScanner implements AutoCloseable {

    private final java.io.InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buf_len = 0;

    private boolean hasNextByte() {
      if (ptr < buf_len) {
        return true;
      } else {
        ptr = 0;
        try {
          buf_len = in.read(buffer);
        } catch (java.io.IOException e) {
          e.printStackTrace();
        }
        if (buf_len <= 0) {
          return false;
        }
      }
      return true;
    }

    private int readByte() {
      if (hasNextByte()) {
        return buffer[ptr++];
      } else {
        return -1;
      }
    }

    private static boolean isPrintableChar(int c) {
      return 33 <= c && c <= 126;
    }

    public boolean hasNext() {
      while (hasNextByte() && !isPrintableChar(buffer[ptr])) {
        ptr++;
      }
      return hasNextByte();
    }

    public String next() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      StringBuilder sb = new StringBuilder();
      int b = readByte();
      while (isPrintableChar(b)) {
        sb.appendCodePoint(b);
        b = readByte();
      }
      return sb.toString();
    }

    public long nextLong() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      long n = 0;
      boolean minus = false;
      int b = readByte();
      if (b == '-') {
        minus = true;
        b = readByte();
      }
      if (b < '0' || '9' < b) {
        throw new NumberFormatException();
      }
      while (true) {
        if ('0' <= b && b <= '9') {
          n *= 10;
          n += b - '0';
        } else if (b == -1 || !isPrintableChar(b)) {
          return minus ? -n : n;
        } else {
          throw new NumberFormatException();
        }
        b = readByte();
      }
    }

    public int nextInt() {
      long nl = nextLong();
      if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) {
        throw new NumberFormatException();
      }
      return (int) nl;
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    @Override
    public void close() throws Exception {
      in.close();
    }
  }
}
