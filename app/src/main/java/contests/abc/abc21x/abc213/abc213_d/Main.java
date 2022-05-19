/*
 * ABC213
 * D - Takahashi Tour
 * https://atcoder.jp/contests/abc213/tasks/abc213_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc213/submissions/31804286
 *
 */

package contests.abc.abc21x.abc213.abc213_d;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
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
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(graph.solve());
    pw.close();
  }

  static class TreeGraph {

    private final int _n;

    private final List<List<Integer>> list_adj;

    public TreeGraph(int n) {
      this._n = n;
      list_adj = new ArrayList<>(n);
      for (int i = 0; i < n; i++) {
        list_adj.add(new ArrayList<>());
      }
    }

    public void addEdge(int u, int v) {
      list_adj.get(u).add(v);
      list_adj.get(v).add(u);
    }

    public String solve() {
      for (List<Integer> adj : list_adj) {
        Collections.sort(adj);
      }
      StringBuilder sb = new StringBuilder();
      dfs(0, -1, sb);
      return sb.deleteCharAt(sb.length() - 1).toString();
    }

    private void dfs(int v, int p, StringBuilder sb) {
      sb.append(v + 1).append(" ");
      List<Integer> v_list = list_adj.get(v);
      for (int to : v_list) {
        if (to == p) {
          continue;
        } else {
          dfs(to, v, sb);
          sb.append(v + 1).append(" ");
        }
      }
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
