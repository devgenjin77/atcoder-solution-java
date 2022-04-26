package library.util;

//SCCGraph ライブラリ
public class SCCGraph {

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
