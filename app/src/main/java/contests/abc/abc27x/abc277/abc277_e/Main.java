/*
 * 大和証券プログラミングコンテスト2022 Autumn
 * （AtCoder Beginner Contest 277）
 * E - Crystal Switches
 * https://atcoder.jp/contests/abc277/tasks/abc277_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc277/submissions/36463339
 *
 */

package contests.abc.abc27x.abc277.abc277_e;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {

  private static final int INF = Integer.MAX_VALUE / 2;

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int m = sc.nextInt();
    final int k = sc.nextInt();
    final List<List<Edge>> list_adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list_adj.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int u = sc.nextInt() - 1;
      int v = sc.nextInt() - 1;
      int a = sc.nextInt();
      list_adj.get(u).add(new Edge(u, v, a));
      list_adj.get(v).add(new Edge(v, u, a));
    }
    final boolean[] switch_exists = new boolean[n];
    for (int i = 0; i < k; i++) {
      switch_exists[sc.nextInt() - 1] = true;
    }
    sc.close();

    final int[][] costs = new int[2][n];
    Arrays.fill(costs[0], INF);
    Arrays.fill(costs[1], INF);
    costs[0][0] = 0;
    final Queue<Player> queue = new ArrayDeque<>();
    queue.add(new Player(0, 0, 0));
    while (!queue.isEmpty()) {
      Player p = queue.poll();
      for (Edge e : list_adj.get(p.pos)) {
        int v = e.v;
        if ((e.a + p.hit) % 2 == 0 && !switch_exists[p.pos]) {
          continue;
        }
        int h = (switch_exists[p.pos] && (e.a + p.hit) % 2 == 0) ? 1 : 0;
        if (costs[(p.hit + h) % 2][v] > p.cost + 1) {
          costs[(p.hit + h) % 2][v] = p.cost + 1;
          queue.add(new Player(v, p.cost + 1, p.hit + h));
        }
      }
    }
    int ans = Math.min(costs[0][n - 1], costs[1][n - 1]);
    System.out.println(ans == INF ? -1 : ans);
  }

  static class Player {

    int cost;
    int pos;
    int hit;

    public Player(int pos, int cost, int hit) {
      this.pos = pos;
      this.cost = cost;
      this.hit = hit;
    }
  }

  static class Edge {

    int u;
    int v;
    int a;

    public Edge(int u, int v, int a) {
      this.u = u;
      this.v = v;
      this.a = a;
    }

  }


  // FastScannerライブラリ
  static class FastScanner implements AutoCloseable {

    private final java.io.InputStream in;
    private final byte[] buf = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    FastScanner(java.io.InputStream source) {
      this.in = source;
    }

    private boolean hasNextByte() {
      if (ptr < buflen) {
        return true;
      } else {
        ptr = 0;
        try {
          buflen = in.read(buf);
        } catch (java.io.IOException e) {
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
        return buf[ptr++];
      } else {
        return -1;
      }
    }

    private boolean isPrintableChar(int c) {
      return 33 <= c && c <= 126;
    }

    private boolean isNumeric(int c) {
      return '0' <= c && c <= '9';
    }

    private void skipToNextPrintableChar() {
      while (hasNextByte() && !isPrintableChar(buf[ptr])) {
        ptr++;
      }
    }

    public boolean hasNext() {
      skipToNextPrintableChar();
      return hasNextByte();
    }

    public String next() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      StringBuilder ret = new StringBuilder();
      int b = readByte();
      while (isPrintableChar(b)) {
        ret.appendCodePoint(b);
        b = readByte();
      }
      return ret.toString();
    }

    public long nextLong() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      long ret = 0;
      int b = readByte();
      boolean negative = false;
      if (b == '-') {
        negative = true;
        if (hasNextByte()) {
          b = readByte();
        }
      }
      if (!isNumeric(b)) {
        throw new NumberFormatException();
      }
      while (true) {
        if (isNumeric(b)) {
          ret = ret * 10 + b - '0';
        } else if (b == -1 || !isPrintableChar(b)) {
          return negative ? -ret : ret;
        } else {
          throw new NumberFormatException();
        }
        b = readByte();
      }
    }

    public int nextInt() {
      return (int) nextLong();
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
