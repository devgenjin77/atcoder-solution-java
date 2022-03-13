/*
 * ABC243
 * C - Collision 2
 * https://atcoder.jp/contests/abc243/tasks/abc243_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc243/submissions/30110657
 *
 */
package contests.abc.abc243.abc243_c;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {

  public static void main(String[] args) throws IOException {
    FastScanner sc = new FastScanner();
    int n = sc.nextInt();
    int[][] arr_pos = new int[n][2];
    for (int i = 0; i < n; i++) {
      arr_pos[i][0] = sc.nextInt();
      arr_pos[i][1] = sc.nextInt();
    }
    String str = sc.next();
    sc.close();
    // Y座標に対して、向きが'L'かつX座標が最も右の要素
    Map<Integer, Integer> map_dir_l = new HashMap<>();
    // Y座標に対して、向きが'R'かつX座標が最も左の要素
    Map<Integer, Integer> map_dir_r = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int pos_x = arr_pos[i][0];
      int pos_y = arr_pos[i][1];
      char dir = str.charAt(i);
      if (dir == 'L') {
        map_dir_l.put(pos_y, Math.max(pos_x, map_dir_l.getOrDefault(pos_y, 0)));
      } else {
        map_dir_r.put(pos_y, Math.min(pos_x, map_dir_r.getOrDefault(pos_y, Integer.MAX_VALUE)));
      }
    }
    boolean isNG = false;
    for (int key : map_dir_l.keySet()) {
      if (map_dir_r.containsKey(key) && map_dir_r.get(key) < map_dir_l.get(key)) {
        isNG = true;
        break;
      }
    }
    System.out.println(isNG ? "Yes" : "No");
  }

  // ライブラリ
  static class FastScanner {

    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    private boolean hasNextByte() {
      if (ptr < buflen) {
        return true;
      } else {
        ptr = 0;
        try {
          buflen = in.read(buffer);
        } catch (IOException e) {
          e.printStackTrace();
        }
        if (buflen <= 0) {
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
        throw new NoSuchElementException();
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
        throw new NoSuchElementException();
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

    public void close() throws IOException {
      in.close();
    }
  }
}
