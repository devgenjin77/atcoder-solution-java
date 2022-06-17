/*
 * 競プロ典型90問
 * 039 - Tree Distance（★5）
 * https://atcoder.jp/contests/typical90/tasks/typical90_am
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/32518496
 *
 * note:
 * - 答えへの貢献度を考える
 * - dp[i]:=頂点i配下に属する頂点の数、を作り、n-dp[i]の合計を取る
 *
 */

package contests.typical90.typical90_04.typical90_039;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    TreeGraph graph = new TreeGraph(n);
    for (int i = 0; i < n - 1; i++) {
      int a = Integer.parseInt(sc.next()) - 1;
      int b = Integer.parseInt(sc.next()) - 1;
      graph.addEdge(a, b);
    }
    sc.close();
    System.out.println(graph.solve());
  }

  static class TreeGraph {

    private final int _n;
    private final List<List<Integer>> list_edge;
    private final long[] dp;

    public TreeGraph(int n) {
      this._n = n;
      this.dp = new long[n];
      list_edge = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        list_edge.add(new ArrayList<>());
      }
    }

    public void addEdge(int u, int v) {
      list_edge.get(u).add(v);
      list_edge.get(v).add(u);
    }

    public long solve() {
      long ans = 0;
      dfs(0, -1);
      for (int i = 1; i < _n; i++) {
        ans += dp[i] * (_n - dp[i]);
      }
      return ans;
    }

    private long dfs(int v, int p) {
      dp[v] = 1;
      for (int next_v : list_edge.get(v)) {
        if (next_v == p) {
          continue;
        }
        dp[v] += dfs(next_v, v);
      }
      return dp[v];
    }
  }

  //NextScannerライブラリ
  static class NextScanner implements AutoCloseable {

    private final java.io.BufferedReader br;

    private java.util.StringTokenizer st;

    private static final int BUF_SIZE = 1 << 16;

    private static final char[] c_buf = new char[BUF_SIZE];

    public NextScanner(java.io.InputStream input) {
      this.br = new java.io.BufferedReader(new java.io.InputStreamReader(input));
    }

    private java.util.StringTokenizer readInput() {
      java.util.StringTokenizer st;
      try {
        int b = br.read(c_buf);
        if (b == BUF_SIZE) {
          StringBuilder sb = new StringBuilder();
          sb.append(c_buf);
          sb.append(br.readLine());
          st = new java.util.StringTokenizer(sb.toString());
        } else if (b < 0) {
          throw new java.util.NoSuchElementException();
        } else {
          st = new java.util.StringTokenizer(new String(c_buf, 0, b));
        }
      } catch (java.io.IOException e) {
        throw new java.util.InputMismatchException(e.getMessage());
      }
      return st;
    }

    public String next() throws java.io.IOException {
      if (st == null || !st.hasMoreElements()) {
        st = readInput();
      }
      return st.nextToken();
    }

    @Override
    public void close() throws Exception {
      br.close();
    }
  }
}
