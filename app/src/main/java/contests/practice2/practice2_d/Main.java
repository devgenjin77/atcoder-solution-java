/*
 * AtCoder Library Practice Contest
 * D - Maxflow
 * https://atcoder.jp/contests/practice2/tasks/practice2_d
 *
 * verified:
 * - https://atcoder.jp/contests/practice2/submissions/31173644
 *
 */

package contests.practice2.practice2_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  static final int[] di = {-1, 1, 0, 0};
  static final int[] dj = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);
    StringBuilder[] grid = new StringBuilder[n];
    for (int i = 0; i < n; i++) {
      grid[i] = new StringBuilder(br.readLine());
    }
    br.close();
    int cnt_node = (n * m) + 2;
    MaxFlowGraph graph = new MaxFlowGraph(cnt_node);
    int s = (n * m), t = (n * m) + 1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i].charAt(j) == '#') {
          continue;
        }
        int v = (i * m) + j;
        if ((i + j) % 2 == 0) {
          // s -> even
          graph.addEdge(s, v, 1);
          //even -> odd
          for (int idx = 0; idx < 4; idx++) {
            int ni = i + di[idx], nj = j + dj[idx];
            if (ni >= 0 && ni < n && nj >= 0 && nj < m && grid[ni].charAt(nj) == '.') {
              int v1 = (ni * m) + nj;
              graph.addEdge(v, v1, 1);
            }
          }
        } else {
          // odd -> t
          graph.addEdge(v, t, 1);
        }
      }
    }
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(graph.flowMax(s, t));
    for (MaxFlowGraphEdge e : graph.edges()) {
      if (e.from == s || e.to == t || e.flow == 0) {
        continue;
      }
      int v_s = Math.min(e.from, e.to), v_t = Math.max(e.from, e.to);
      int s_i = v_s / m, s_j = v_s % m;
      int t_i = v_t / m, t_j = v_t % m;
      if (s_i == t_i) {
        //ヨコ
        grid[s_i].setCharAt(s_j, '>');
        grid[t_i].setCharAt(t_j, '<');
      } else {
        //タテ
        grid[s_i].setCharAt(s_j, 'v');
        grid[t_i].setCharAt(t_j, '^');
      }
    }
    for (StringBuilder sb : grid) {
      pw.println(sb);
    }
    pw.close();
  }

  //MaxFlowGraph ライブラリ
  static final class MaxFlowGraph {

    private final int _n;

    private final java.util.List<Pair> pos;

    private final java.util.List<java.util.List<Edge>> g;

    public MaxFlowGraph(int n) {
      this._n = n;
      this.pos = new java.util.ArrayList<>();
      this.g = new java.util.ArrayList<>();
      for (int i = 0; i < this._n; i++) {
        g.add(new java.util.ArrayList<>());
      }
    }

    public int addEdge(int from, int to, long cap) {
      java.util.Objects.checkIndex(from, this._n);
      java.util.Objects.checkIndex(to, this._n);
      //Todo Non Negative Check
      int m = pos.size();
      pos.add(new Pair(from, g.get(from).size()));
      g.get(from).add(new Edge(to, g.get(to).size(), cap));
      g.get(to).add(new Edge(from, g.get(from).size() - 1, 0L));
      return m;
    }

    private MaxFlowGraphEdge getEdge(int i) {
      java.util.Objects.checkIndex(i, this.pos.size());
      Pair p = pos.get(i);
      Edge e = g.get(p.first).get(p.second);
      Edge re = g.get(e.to).get(e.rev);
      return new MaxFlowGraphEdge(re.to, e.to, e.cap + re.cap, re.cap);
    }

    public java.util.List<MaxFlowGraphEdge> edges() {
      java.util.List<MaxFlowGraphEdge> res = new java.util.ArrayList<>();
      for (int i = 0; i < pos.size(); i++) {
        res.add(getEdge(i));
      }
      return res;
    }

    public void changeEdge(int i, long new_cap, long new_flow) {
      java.util.Objects.checkIndex(i, this.pos.size());
      //Todo Non Negative Check
      if (new_cap < new_flow) {
        String msg = String.format("Flow %d is greather than the capacity %d", new_flow, new_cap);
        throw new IllegalArgumentException(msg);
      }
      Pair p = pos.get(i);
      Edge e = g.get(p.first).get(p.second);
      Edge re = g.get(e.to).get(e.rev);
      e.cap = new_cap - new_flow;
      re.cap = new_flow;
    }

    public long flowMax(int s, int t) {
      return flow(s, t, Long.MAX_VALUE / 2);
    }

    public long flow(int s, int t, long limit) {
      java.util.Objects.checkIndex(s, this._n);
      java.util.Objects.checkIndex(t, this._n);
      // Todo assertion s != t
      long flow = 0L;
      int[] level = new int[_n];
      int[] iter = new int[_n];
      while (flow < limit) {
        bfs(s, t, level);
        if (level[t] < 0) {
          break;
        }
        java.util.Arrays.fill(iter, 0);
        while (flow < limit) {
          long d = dfs(t, s, limit - flow, iter, level);
          if (d == 0) {
            break;
          }
          flow += d;
        }
      }
      return flow;
    }

    private void bfs(int s, int t, int[] level) {
      java.util.Deque<Integer> queue = new java.util.ArrayDeque<>();
      java.util.Arrays.fill(level, -1);
      queue.add(s);
      level[s] = 0;
      while (!queue.isEmpty()) {
        int v = queue.pollFirst();
        for (Edge e : g.get(v)) {
          if (e.cap == 0L || level[e.to] >= 0) {
            continue;
          }
          level[e.to] = level[v] + 1;
          if (e.to == t) {
            return;
          }
          queue.add(e.to);
        }
      }
    }

    private long dfs(int v, int s, long limit, int[] iter, int[] level) {
      if (s == v) {
        return limit;
      }
      long res = 0L;
      int level_v = level[v];
      while (iter[v] < g.get(v).size()) {
        Edge e = g.get(v).get(iter[v]++);
        Edge re = g.get(e.to).get(e.rev);
        if (!(level[e.to] < level_v && re.cap > 0L)) {
          continue;
        }
        long d = dfs(e.to, s, Math.min(limit - res, re.cap), iter, level);
        if (d <= 0) {
          continue;
        }
        e.cap += d;
        re.cap -= d;
        res += d;
        if (res == limit) {
          break;
        }
      }
      return res;
    }

    public boolean[] minCut(int s) {
      java.util.Objects.checkIndex(s, this._n);
      boolean[] visited = new boolean[_n];
      java.util.Deque<Integer> queue = new java.util.ArrayDeque<>();
      queue.add(s);
      while (!queue.isEmpty()) {
        int p = queue.pollFirst();
        visited[p] = true;
        for (Edge e : g.get(p)) {
          if (!visited[e.to] && e.cap > 0) {
            visited[e.to] = true;
            queue.add(e.to);
          }
        }
      }
      return visited;
    }

    private final class Edge {

      final int to, rev;
      long cap;

      Edge(int to, int rev, long cap) {
        this.to = to;
        this.rev = rev;
        this.cap = cap;
      }
    }

    private final class Pair {

      final int first, second;

      Pair(int first, int second) {
        this.first = first;
        this.second = second;
      }
    }
  }

  static final class MaxFlowGraphEdge {

    public final int from, to;
    public final long cap, flow;

    MaxFlowGraphEdge(int from, int to, long cap, long flow) {
      this.from = from;
      this.to = to;
      this.cap = cap;
      this.flow = flow;
    }
  }
}
