package library.util;

//SCCGraph ライブラリ
public class SCCGraph {

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
    if(!(i >= 0 && i < this._n)) {
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
