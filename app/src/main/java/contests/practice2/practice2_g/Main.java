/*
 * AtCoder Library Practice Contest
 * G - SCC
 * https://atcoder.jp/contests/practice2/tasks/practice2_g
 *
 * verified:
 * - https://atcoder.jp/contests/practice2/submissions/30388656
 *
 */
package contests.practice2.practice2_g;

import java.io.PrintWriter;
import java.util.List;

public class Main {

  static void solve(FastScanner sc, PrintWriter pw) throws Exception {
    int n = sc.nextInt();
    int m = sc.nextInt();
    SCCGraph sccGraph = new SCCGraph(n);
    for (int i = 0; i < m; i++) {
      int from = sc.nextInt();
      int to = sc.nextInt();
      sccGraph.addEdge(from, to);
    }
    List<List<Integer>> scc_grp = sccGraph.scc();
    int cnt_grp = scc_grp.size();
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
    pw.flush();
  }

  public static void main(String[] args) {
    try (
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out)) {
      solve(sc, pw);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //SCCGraph ライブラリ
  static class SCCGraph {

    final int _n;
    final java.util.ArrayList<Edge> edge_list;

    private int nowOrd, groupNum;
    private int[] gid, start, low, ord;
    private java.util.Deque<Integer> visited;
    private Edge[] arr_edge;

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
      arr_edge = new Edge[edge_list.size()];
      int[] counter = java.util.Arrays.copyOf(start, start.length);
      for (Edge e : edge_list) {
        arr_edge[counter[e.from]++] = e;
      }
      nowOrd = 0;
      groupNum = 0;
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
      for (int i = 0; i < _n; i++) {
        gid[i] = groupNum - 1 - gid[i];
      }
      java.util.List<java.util.List<Integer>> group_list = new java.util.ArrayList<>(groupNum);
      for (int g = 0; g < groupNum; g++) {
        group_list.add(new java.util.ArrayList<>());
      }
      for (int i = _n - 1; i >= 0; i--) {
        group_list.get(gid[i]).add(i);
      }
      return group_list;
    }

    private void dfs(int v) {
      low[v] = ord[v] = nowOrd++;
      visited.add(v);
      for (int i = start[v]; i < start[v + 1]; i++) {
        int to = arr_edge[i].to;
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
          gid[u] = groupNum;
          if (u == v) {
            break;
          }
        }
        groupNum++;
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

  //FastScanner ライブラリ
  static class FastScanner implements AutoCloseable {

    private final java.io.InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buf_len = 0;

    private boolean hasNextByte() {
      if (ptr < buf_len) {
        return true;
      } else {
        ptr = 0;
        try {
          buf_len = in.read(buffer);
        } catch (java.io.IOException e) {
          e.printStackTrace();
        }
        if (buf_len <= 0) {
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
