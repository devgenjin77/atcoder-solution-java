/*
 * AtCoder Beginner Contest 254
 * E - Small d and k
 * https://atcoder.jp/contests/abc254/tasks/abc254_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc254/submissions/38741623
 *
 */

package contests.abc.abc25x.abc254.abc254_e;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int m = sc.nextInt();
    final UndirectedGraph graph = new UndirectedGraph(n);
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      graph.addEdge(a, b);
    }
    final int q = sc.nextInt();
    final PrintWriter pw = new PrintWriter(System.out);
    for (int cnt = 0; cnt < q; cnt++) {
      int x = sc.nextInt() - 1;
      int k = sc.nextInt();
      pw.println(graph.solve(x, k));
    }
    pw.close();
    sc.close();
  }

  static class UndirectedGraph {

    final int _n;

    final List<List<Integer>> list_adj;

    UndirectedGraph(int n) {
      this._n = n;
      list_adj = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        list_adj.add(new ArrayList<>());
      }
    }

    void addEdge(int u, int v) {
      list_adj.get(u).add(v);
      list_adj.get(v).add(u);
    }

    int solve(int x, int k) {
      return bfs(x, k);
    }

    int bfs(int v, int depth) {
      int ret = 0;
      HashMap<Integer, Integer> dist_map = new HashMap<>();
      Queue<Integer> queue = new ArrayDeque<>();
      queue.add(v);
      dist_map.put(v, 0);
      while (!queue.isEmpty()) {
        int cur = queue.poll();
        ret += cur + 1;
        int dist = dist_map.get(cur);
        if (dist_map.get(cur) < depth) {
          for (int next : list_adj.get(cur)) {
            if (!dist_map.containsKey(next)) {
              queue.add(next);
              dist_map.put(next, dist + 1);
            }
          }
        }
      }
      return ret;
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
