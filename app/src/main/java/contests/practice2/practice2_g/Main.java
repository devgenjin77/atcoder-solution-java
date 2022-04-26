/*
 * AtCoder Library Practice Contest
 * G - SCC
 * https://atcoder.jp/contests/practice2/tasks/practice2_g
 *
 * verified:
 * - https://atcoder.jp/contests/practice2/submissions/31279414
 *
 */

package contests.practice2.practice2_g;

import java.io.PrintWriter;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int m = Integer.parseInt(sc.next());
    SCCGraph sccGraph = new SCCGraph(n);
    for (int i = 0; i < m; i++) {
      int from = Integer.parseInt(sc.next());
      int to = Integer.parseInt(sc.next());
      sccGraph.addEdge(from, to);
    }
    List<List<Integer>> scc_grp = sccGraph.scc();
    int cnt_grp = scc_grp.size();
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(cnt_grp);
    for (int i = 0; i < cnt_grp; i++) {
      List<Integer> scc_sub = scc_grp.get(i);
      StringBuilder sb = new StringBuilder();
      sb.append(scc_sub.size());
      for (int v : scc_sub) {
        sb.append(" ").append(v);
      }
      pw.println(sb.toString());
    }
    pw.close();
  }

  //SCCGraph ライブラリ
  static class SCCGraph {

    final int _n;
    final java.util.ArrayList<Edge> edge_list;

    private int nowOrd, grpNum;
    private int[] gid, start, low, ord, arr_edge_to;
    private java.util.Deque<Integer> visited;

    SCCGraph(int n) {
      this._n = n;
      this.edge_list = new java.util.ArrayList<>();
      this.start = new int[_n + 1];
    }

    void addEdge(int from, int to) {
      java.util.Objects.checkIndex(from, this._n);
      java.util.Objects.checkIndex(to, this._n);
      this.edge_list.add(new Edge(from, to));
      start[from + 1]++;
    }

    java.util.List<java.util.List<Integer>> scc() {
      for (int i = 1; i <= _n; i++) {
        start[i] += start[i - 1];
      }
      arr_edge_to = new int[edge_list.size()];
      int[] counter = java.util.Arrays.copyOf(start, start.length);
      for (Edge e : edge_list) {
        arr_edge_to[counter[e.from]++] = e.to;
      }
      nowOrd = 0;
      grpNum = 0;
      visited = new java.util.ArrayDeque<>();
      low = new int[_n];
      ord = new int[_n];
      gid = new int[_n];
      java.util.Arrays.fill(ord, -1);
      for (int i = 0; i < _n; i++) {
        if (ord[i] == -1) {
          dfs(i);
        }
      }
      java.util.List<java.util.List<Integer>> group_list = new java.util.ArrayList<>(grpNum);
      for (int g = 0; g < grpNum; g++) {
        group_list.add(new java.util.ArrayList<>());
      }
      for (int i = _n - 1; i >= 0; i--) {
        group_list.get(grpNum - 1 - gid[i]).add(i);
      }
      return group_list;
    }

    private void dfs(int v) {
      low[v] = ord[v] = nowOrd++;
      visited.add(v);
      for (int i = start[v]; i < start[v + 1]; i++) {
        int to = arr_edge_to[i];
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
          gid[u] = grpNum;
          if (u == v) {
            break;
          }
        }
        grpNum++;
      }
    }

    private static class Edge {

      int from, to;

      Edge(int from, int to) {
        this.from = from;
        this.to = to;
      }
    }
  }

  //NextScannerライブラリ
  static class NextScanner implements AutoCloseable {

    final private java.io.BufferedReader in;

    private java.util.StringTokenizer st;

    public NextScanner(java.io.InputStream is) {
      this.in = new java.io.BufferedReader(new java.io.InputStreamReader(is));
    }

    public String next() throws java.io.IOException {
      if (st == null || !st.hasMoreElements()) {
        st = new java.util.StringTokenizer(in.readLine());
      }
      return st.nextToken();
    }

    @Override
    public void close() throws Exception {
      in.close();
    }
  }
}
