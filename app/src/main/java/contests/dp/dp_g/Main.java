/*
 * Educational DP Contest / DP まとめコンテスト
 * G - Longest Path
 * https://atcoder.jp/contests/dp/tasks/dp_g
 *
 * verified:
 * - https://atcoder.jp/contests/dp/submissions/31335877
 *
 */

package contests.dp.dp_g;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int m = Integer.parseInt(sc.next());
    DirectedGraph graph = new DirectedGraph(n);
    for (int i = 0; i < m; i++) {
      int u = Integer.parseInt(sc.next()) - 1;
      int v = Integer.parseInt(sc.next()) - 1;
      graph.addEdge(u, v);
    }
    sc.close();
    System.out.println(graph.solve());
  }

  static class DirectedGraph {

    final int _n;

    List<List<Integer>> edges;

    int[] dp;

    DirectedGraph(int n) {
      this._n = n;
      edges = new ArrayList<>();
      dp = new int[n];
      Arrays.fill(dp, -1);
      for (int i = 0; i < n; i++) {
        edges.add(new ArrayList<>());
      }
    }

    void addEdge(int from, int to) {
      edges.get(from).add(to);
    }

    int solve() {
      int ret = 0;
      for (int i = 0; i < _n; i++) {
        ret = Math.max(dfs(i), ret);
      }
      return ret;
    }

    int dfs(int v) {
      if (dp[v] >= 0) {
        return dp[v];
      }
      int ret = 0;
      for (int to : edges.get(v)) {
        ret = Math.max(dfs(to) + 1, ret);
      }
      return dp[v] = ret;
    }
  }

  //NextScannerライブラリ
  static class NextScanner implements AutoCloseable {

    final private java.io.InputStreamReader reader;

    private java.util.StringTokenizer st;

    private static final int BUF_SIZE = 1024;

    private static final char[] buf = new char[BUF_SIZE];

    public NextScanner(java.io.InputStream is) {
      this.reader = new java.io.InputStreamReader(is);
      init();
    }

    private void init() {
      StringBuilder sb = new StringBuilder();
      int len = 0;
      while (true) {
        try {
          int r = this.reader.read(buf, 0, BUF_SIZE);
          if (r < 0) {
            break;
          } else {
            len += r;
            sb.append(buf);
          }
        } catch (IOException ioe) {
          throw new InputMismatchException();
        }
      }
      st = new StringTokenizer(sb.substring(0, len));
    }

    public String next() {
      if (st == null || !st.hasMoreElements()) {
        throw new NoSuchElementException();
      }
      return st.nextToken();
    }

    @Override
    public void close() throws Exception {
      reader.close();
    }
  }
}
