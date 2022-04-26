/*
 * ac-library
 * MaxFlow
 *
 * https://atcoder.github.io/ac-library/production/document_ja/maxflow.html
 *
 */

package library.util;

//MaxFlowGraph ライブラリ
public class MaxFlowGraph {

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
    if (cap < 0) {
      String errMsg = String.format("given cap %d is negative.", cap);
      throw new IllegalArgumentException(errMsg);
    }
    int m = pos.size();
    pos.add(new Pair(from, g.get(from).size()));
    int from_id = g.get(from).size();
    int to_id = g.get(to).size();
    if (from == to) {
      to_id++;
    }
    g.get(from).add(new Edge(to, to_id, cap));
    g.get(to).add(new Edge(from, from_id, 0L));
    return m;
  }

  public MaxFlowGraphEdge getEdge(int i) {
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
    if (new_cap < 0) {
      String errMsg = String.format("given new_cap %d is negative.", new_cap);
      throw new IllegalArgumentException(errMsg);
    }
    if (new_flow < 0) {
      String errMsg = String.format("given new_flow %d is negative.", new_flow);
      throw new IllegalArgumentException(errMsg);
    }
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
    return flow(s, t, Long.MAX_VALUE);
  }

  public long flow(int s, int t, long limit) {
    java.util.Objects.checkIndex(s, this._n);
    java.util.Objects.checkIndex(t, this._n);
    if (s == t) {
      String errMsg = String.format("Invalid path: (%d -> %d).", s, t);
      throw new IllegalArgumentException(errMsg);
    }
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

final class MaxFlowGraphEdge {

  public final int from, to;
  public final long cap, flow;

  MaxFlowGraphEdge(int from, int to, long cap, long flow) {
    this.from = from;
    this.to = to;
    this.cap = cap;
    this.flow = flow;
  }
}
