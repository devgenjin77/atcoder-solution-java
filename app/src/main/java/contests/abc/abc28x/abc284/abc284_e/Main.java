/*
 * AtCoder Beginner Contest 284
 * E - Count Simple Paths
 * https://atcoder.jp/contests/abc284/tasks/abc284_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc284/submissions/37869540
 *
 * note:
 * 単純パスの数え上げはDFS
 *
 */

package contests.abc.abc28x.abc284.abc284_e;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int m = sc.nextInt();
    final SimpleGraph graph = new SimpleGraph(n);
    for (int i = 0; i < m; i++) {
      int u = sc.nextInt() - 1;
      int v = sc.nextInt() - 1;
      graph.addEdge(u, v);
    }
    sc.close();
    System.out.println(graph.solve());
  }

  static class SimpleGraph {

    private final int _n;

    private final List<List<Integer>> list_adj;

    private int ans;

    private static final int MAX = 1_000_000;

    public SimpleGraph(int n) {
      this._n = n;
      this.list_adj = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        this.list_adj.add(new ArrayList<>());
      }
    }

    public void addEdge(int u, int v) {
      this.list_adj.get(u).add(v);
      this.list_adj.get(v).add(u);
    }

    public int solve() {
      ans = 0;
      boolean[] isvisited = new boolean[_n];
      dfs(0, -1, isvisited);
      return ans;
    }

    private void dfs(int v, int p, boolean[] visited) {
      visited[v] = true;
      if (ans >= MAX) {
        return;
      }
      ans++;
      for (int u : list_adj.get(v)) {
        if (u == p) {
          continue;
        }

        if (visited[u]) {
          continue;
        }
        if (ans >= MAX) {
          break;
        }
        dfs(u, v, visited);
      }
      visited[v] = false;
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
