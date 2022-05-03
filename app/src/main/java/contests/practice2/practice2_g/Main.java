/*
 * AtCoder Library Practice Contest
 * G - SCC
 * https://atcoder.jp/contests/practice2/tasks/practice2_g
 *
 * verified:
 * - https://atcoder.jp/contests/practice2/submissions/31420128
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
}

//SCCGraph ライブラリ
class SCCGraph {

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
    java.util.Objects.checkIndex(from, this._n);
    java.util.Objects.checkIndex(to, this._n);
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

  private static final class Edge {

    final int from, to;

    Edge(int from, int to) {
      this.from = from;
      this.to = to;
    }
  }
}

//NextScannerライブラリ
class NextScanner implements AutoCloseable {

  private final java.io.BufferedReader br;

  private java.util.StringTokenizer st;

  private static final int BUF_SIZE = 1024;

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
