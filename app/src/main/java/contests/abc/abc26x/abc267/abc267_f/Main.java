/*
 * NECプログラミングコンテスト2022
 * （AtCoder Beginner Contest 267）
 * F - Exactly K Steps
 * https://atcoder.jp/contests/abc267/tasks/abc267_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc267/submissions/35071871
 *
 */

package contests.abc.abc26x.abc267.abc267_f;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final TreeGraph graph = new TreeGraph(n);
    for (int i = 0; i < n - 1; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      graph.addEdge(a, b);
    }
    graph.prepare();
    final int q = sc.nextInt();
    final PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {

      int u = sc.nextInt() - 1;
      int k = sc.nextInt();
      int ans = graph.solve(u, k);
      pw.println(ans == -1 ? -1 : ans + 1);
    }
    pw.close();
    sc.close();
  }

  static class TreeGraph {

    private final int _n;

    private final java.util.List<java.util.List<Integer>> list_edge;

    private final int[][] doubling_a;

    private final int[][] doubling_b;

    public TreeGraph(int n) {
      this._n = n;
      list_edge = new java.util.ArrayList<>();
      for (int i = 0; i < n; i++) {
        list_edge.add(new java.util.ArrayList<>());
      }
      doubling_a = new int[18][_n];
      doubling_b = new int[18][_n];
      for (int i = 0; i < 18; i++) {
        java.util.Arrays.fill(doubling_a[i], -1);
        java.util.Arrays.fill(doubling_b[i], -1);
      }
    }

    public void addEdge(int u, int v) {
      list_edge.get(u).add(v);
      list_edge.get(v).add(u);
    }

    public void prepare() {
      int a = bfs(0);
      int b = bfs(a);
      dfs(a, -1, doubling_a);
      dfs(b, -1, doubling_b);
      for (int p = 1; p < 18; p++) {
        for (int i = 0; i < _n; i++) {
          //ダブリング定型
          //行き先が-1だと配列外参照になるので注意
          if (doubling_a[p - 1][i] != -1) {
            doubling_a[p][i] = doubling_a[p - 1][doubling_a[p - 1][i]];
          }
          if (doubling_b[p - 1][i] != -1) {
            doubling_b[p][i] = doubling_b[p - 1][doubling_b[p - 1][i]];
          }
        }
      }
    }

    public int solve(int v, int k) {
      int ans1 = v, ans2 = v;
      for (int i = 0; i < 18; i++) {
        if (((k >> i) & 1) == 1) {
          if (ans1 != -1) {
            ans1 = doubling_a[i][ans1];
          }
          if (ans2 != -1) {
            ans2 = doubling_b[i][ans2];
          }
        }
      }
      if (ans1 != -1) {
        return ans1;
      } else if (ans2 != -1) {
        return ans2;
      } else {
        return -1;
      }
    }

    private void dfs(int v, int p, int[][] doubling) {
      for (int to : list_edge.get(v)) {
        if (to == p) {
          continue;
        }
        doubling[0][to] = v;
        dfs(to, v, doubling);
      }
    }

    //指定頂点Vから最も遠い頂点を返す
    private int bfs(int v) {
      final int[] dist = new int[_n];
      java.util.Arrays.fill(dist, -1);
      java.util.Queue<Integer> queue = new java.util.ArrayDeque<>();
      dist[v] = 0;
      int max_depth = 0, max_depth_v = v;
      queue.add(v);
      while (!queue.isEmpty()) {
        int cur = queue.poll();
        for (int to : list_edge.get(cur)) {
          if (dist[to] == -1) {
            dist[to] = dist[cur] + 1;
            queue.add(to);
            if (dist[to] > max_depth) {
              max_depth = dist[to];
              max_depth_v = to;
            }
          }
        }
      }
      return max_depth_v;
    }
  }

  // FastScannerライブラリ
  static class FastScanner implements AutoCloseable {

    private final java.io.InputStream in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    public FastScanner(java.io.InputStream input) {
      this.in = input;
    }

    private boolean hasNextByte() {
      if (ptr < buflen) {
        return true;
      } else {
        ptr = 0;
        try {
          buflen = in.read(buffer);
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
