/*
 * ABC246
 * E - Bishop 2
 * https://atcoder.jp/contests/abc246/tasks/abc246_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc246/submissions/30700294
 *
 */


package contests.abc.abc246.abc246_e;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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
    int[][][] tbl_cost = new int[n][n][4];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        Arrays.fill(tbl_cost[i][j], Integer.MAX_VALUE);
      }
    }
    Arrays.fill(tbl_cost[ax][ay], 0);
    Deque<Piece> queue = new ArrayDeque<>();
    queue.add(new Piece(ax, ay, -1, 0));
    int ans = Integer.MAX_VALUE;
    while (!queue.isEmpty()) {
      Piece p = queue.poll();
      if(p.cost >= ans) {
        continue;
      }
      for (int next_dir = 0; next_dir < 4; next_dir++) {
        if(isOppositeDir(p.d, next_dir)) {
          continue;
        }
        int next_x = p.x + dx[next_dir];
        int next_y = p.y + dy[next_dir];
        int next_cost = p.d == next_dir ? p.cost : p.cost + 1;
        if (next_x >= 0 && next_x < n && next_y >= 0 && next_y < n
            && map[next_x].charAt(next_y) == '.'
            && tbl_cost[next_x][next_y][next_dir] > next_cost) {
          tbl_cost[next_x][next_y][next_dir] = next_cost;
          if(next_x == bx && next_y == by) {
            ans = Math.min(next_cost, ans);
          } else {
            Piece next = new Piece(next_x, next_y, next_dir, next_cost);
            if(p.d == next_dir) {
              queue.addFirst(next);
            } else {
              queue.addLast(next);
            }
          }

        }
      }
    }
    System.out.println(ans != Integer.MAX_VALUE ? ans : -1);
  }

  static boolean isOppositeDir(int a, int b) {
    if(a >= 0 && b >= 0 && Math.abs(a - b) == 2) {
      return true;
    } else {
      return false;
    }
  }

  static class Piece implements Comparable<Piece> {

    int x, y, d, cost;

    Piece(int x, int y, int d, int cost) {
      this.x = x;
      this.y = y;
      this.d = d;
      this.cost = cost;
    }

    @Override
    public int compareTo(Piece o) {
      return Integer.compare(cost, o.cost);
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
