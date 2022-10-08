/*
 * AtCoder Beginner Contest 245
 * F - Endless Walk
 * https://atcoder.jp/contests/abc245/tasks/abc245_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc245/submissions/35458035
 *
 * note:
 * SCC(強連結成分分解)を行う
 */

package contests.abc.abc24x.abc245.abc245_f;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int m = Integer.parseInt(sc.next());
    final SCCGraph scc = new SCCGraph(n);
    final List<List<Integer>> list_adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list_adj.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int u = Integer.parseInt(sc.next()) - 1;
      int v = Integer.parseInt(sc.next()) - 1;
      scc.addEdge(u, v);
      list_adj.get(u).add(v);
    }
    sc.close();
    final boolean[] is_cycle = new boolean[n];
    final List<List<Integer>> scc_list = scc.scc();
    for (int i = 0; i < scc_list.size(); i++) {
      if (scc_list.get(i).size() == 1) {
        continue;
      }
      for (int v : scc_list.get(i)) {
        is_cycle[v] = true;
      }
    }
    for (int i = scc_list.size() - 1; i >= 0; i--) {
      if (scc_list.get(i).size() != 1) {
        continue;
      }
      int u = scc_list.get(i).get(0);
      for (int v : list_adj.get(u)) {
        if (is_cycle[v]) {
          is_cycle[u] = true;
          break;
        }
      }
    }
    int ans = 0;
    for (boolean b : is_cycle) {
      if (b) {
        ans++;
      }
    }
    System.out.println(ans);
  }

  //SCCGraph ライブラリ
  static class SCCGraph {

    private final int _n;
    private final java.util.ArrayList<Edge> list_edge;

    private int now_ord, grp_num;
    private int[] gid, low, ord;
    private int[] start;
    private int[] edge_to;
    private java.util.Deque<Integer> visited;

    public SCCGraph(int n) {
      this._n = n;
      this.list_edge = new java.util.ArrayList<>();
      this.start = new int[n + 1];
    }

    public final void addEdge(int from, int to) {
      checkIndex(from);
      checkIndex(to);
      list_edge.add(new Edge(from, to));
      start[from + 1]++;
    }

    public final java.util.List<java.util.List<Integer>> scc() {
      for (int i = 1; i <= _n; i++) {
        start[i] += start[i - 1];
      }
      edge_to = new int[list_edge.size()];
      int[] counter = java.util.Arrays.copyOf(start, start.length);
      for (Edge e : list_edge) {
        edge_to[counter[e.from]++] = e.to;
      }
      now_ord = 0;
      grp_num = 0;
      visited = new java.util.ArrayDeque<>();
      low = new int[_n];
      ord = new int[_n];
      gid = new int[_n];
      java.util.Arrays.fill(ord, -1);
      for (int v = 0; v < _n; v++) {
        if (ord[v] == -1) {
          dfs(v);
        }
      }
      java.util.List<java.util.List<Integer>> group_list = new java.util.ArrayList<>(grp_num);
      for (int g = 0; g < grp_num; g++) {
        group_list.add(new java.util.ArrayList<>());
      }
      for (int i = _n - 1; i >= 0; i--) {
        group_list.get(grp_num - 1 - gid[i]).add(i);
      }
      return group_list;
    }

    private void dfs(int v) {
      low[v] = ord[v] = now_ord++;
      visited.add(v);
      for (int i = start[v]; i < start[v + 1]; i++) {
        int to = edge_to[i];
        if (ord[to] == -1) {
          dfs(to);
          low[v] = Math.min(low[v], low[to]);
        } else {
          low[v] = Math.min(low[v], ord[to]);
        }
      }
      if (low[v] == ord[v]) {
        while (true) {
          int u = visited.pollLast();
          ord[u] = _n;
          gid[u] = grp_num;
          if (u == v) {
            break;
          }
        }
        grp_num++;
      }
    }

    void checkIndex(int i) {
      if (!(i >= 0 && i < this._n)) {
        String msg = String.format("Index %d out of bounds for length %d", i, this._n);
        throw new IndexOutOfBoundsException(msg);
      }
    }

    private static final class Edge {

      final int from, to;

      Edge(int from, int to) {
        this.from = from;
        this.to = to;
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
