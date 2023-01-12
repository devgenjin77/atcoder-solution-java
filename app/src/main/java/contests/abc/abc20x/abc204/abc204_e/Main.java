/*
 * AtCoder Beginner Contest 204
 * E - Rush Hour 2
 * https://atcoder.jp/contests/abc204/tasks/abc204_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc204/submissions/37966323
 *
 * note:
 *
 *
 */

package contests.abc.abc20x.abc204.abc204_e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

  private static final long INF = Long.MAX_VALUE / 2;

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int m = sc.nextInt();
    final List<List<CostedEdge>> list_adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list_adj.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      long c = sc.nextLong();
      long d = sc.nextLong();
      list_adj.get(a).add(new CostedEdge(a, b, c, d));
      list_adj.get(b).add(new CostedEdge(b, a, c, d));
    }
    sc.close();
    final long[] costs = new long[n];
    Arrays.fill(costs, INF);
    costs[0] = 0;
    final PriorityQueue<Player> p_queue = new PriorityQueue<>();
    p_queue.add(new Player(0, 0L));
    while (!p_queue.isEmpty()) {
      Player p = p_queue.poll();
      if (p.cost > costs[p.pos]) {
        continue;
      }
      for (CostedEdge next_edge : list_adj.get(p.pos)) {
        long sqrt_add = (long) Math.sqrt(next_edge.add);
        long dep_t = Math.max(sqrt_add, p.cost);
        long next_cost = dep_t + next_edge.cost + (next_edge.add / (dep_t + 1));
        if (costs[next_edge.to] > next_cost) {
          costs[next_edge.to] = next_cost;
          p_queue.add(new Player(next_edge.to, next_cost));
        }
      }
    }
    System.out.println(costs[n - 1] == INF ? -1 : costs[n - 1]);
  }

  static class Player implements Comparable<Player> {

    final long cost;
    final int pos;

    public Player(int pos, long cost) {
      this.pos = pos;
      this.cost = cost;
    }

    @Override
    public int compareTo(Player o) {
      if (this.cost != o.cost) {
        return Long.compare(this.cost, o.cost);
      }
      return Integer.compare(this.pos, o.pos);
    }
  }

  static class CostedEdge {

    final int from, to;
    final long cost, add;

    public CostedEdge(int from, int to, long cost, long add) {
      this.from = from;
      this.to = to;
      this.cost = cost;
      this.add = add;
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
