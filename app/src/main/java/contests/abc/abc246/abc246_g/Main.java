/*
 * ABC246
 * G - Game on Tree 3
 * https://atcoder.jp/contests/abc246/tasks/abc246_g
 *
 * verified:
 * - https://atcoder.jp/contests/abc246/submissions/30742542
 *
 * Note:
 * 木DP、二分探索
 *
 */

package contests.abc.abc246.abc246_g;

import java.util.ArrayList;
import java.util.List;

public class Main {

  static int[] array_a;
  static List<List<Integer>> edge_list;

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    int n = fs.nextInt();
    array_a = new int[n];
    for (int i = 1; i < n; i++) {
      array_a[i] = fs.nextInt();
    }
    edge_list = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      edge_list.add(new ArrayList<>());
    }
    for (int cnt = 0; cnt < n - 1; cnt++) {
      int from = fs.nextInt() - 1;
      int to = fs.nextInt() - 1;
      edge_list.get(from).add(to);
      edge_list.get(to).add(from);
    }
    fs.close();
    int ng = (int) 1e9 + 1, ok = -1;
    while (ng - ok > 1) {
      int mid = (ng + ok) / 2;
      if (dfs(0, -1, mid) > 0) {
        ok = mid;
      } else {
        ng = mid;
      }
    }
    System.out.println(ok);
  }

  static int dfs(int current, int parent, int x) {
    int ret = 0;
    for (int child : edge_list.get(current)) {
      if (child == parent) {
        continue;
      }
      ret += dfs(child, current, x);
    }
    ret = Math.max(ret - 1, 0);
    if (array_a[current] >= x) {
      ret += 1;
    }
    return ret;
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
