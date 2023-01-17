/*
 * AtCoder Beginner Contest 252
 * E - Road Reduction
 * https://atcoder.jp/contests/abc252/tasks/abc252_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc252/submissions/38125552
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc252.abc252_e;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

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
      long cost = sc.nextLong();
      list_adj.get(a).add(new CostedEdge(a, b, i, cost));
      list_adj.get(b).add(new CostedEdge(b, a, i, cost));
    }
    sc.close();

    //都市１からの最短経路として使える辺
    final int[] edges = new int[n];
    final PriorityQueue<Node> queue = new PriorityQueue<>();
    final long[] costs = new long[n];
    Arrays.fill(costs, Long.MAX_VALUE / 2);
    costs[0] = 0;
    queue.add(new Node(0, 0));
    //ダイクストラ法
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (costs[node.v] < node.dist) {
        continue;
      }
      for (CostedEdge edge : list_adj.get(node.v)) {
        if (costs[edge.v] > node.dist + edge.cost) {
          costs[edge.v] = node.dist + edge.cost;
          queue.add(new Node(edge.v, costs[edge.v]));
          edges[edge.v] = edge.id;
        }
      }
    }
    final StringBuilder sb = new StringBuilder();
    for (int i = 1; i < n; i++) {
      sb.append(edges[i] + 1).append(' ');
    }
    System.out.println(sb.deleteCharAt(sb.length() - 1));
  }

  static class Node implements Comparable<Node> {

    int v;
    long dist;

    public Node(int v, long dist) {
      this.v = v;
      this.dist = dist;
    }

    @Override
    public int compareTo(Node o) {
      if (dist != o.dist) {
        return Long.compare(dist, o.dist);
      } else {
        return Integer.compare(v, o.v);
      }
    }
  }

  static class CostedEdge implements Comparable<CostedEdge> {

    int u, v, id;
    long cost;

    public CostedEdge(int u, int v, int id, long cost) {
      this.u = u;
      this.v = v;
      this.id = id;
      this.cost = cost;
    }

    @Override
    public int compareTo(CostedEdge o) {
      if (this.cost != o.cost) {
        return Long.compare(this.cost, o.cost);
      } else {
        return Integer.compare(this.id, o.id);
      }
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
