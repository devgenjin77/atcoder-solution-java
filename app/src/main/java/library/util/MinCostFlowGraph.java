/*
 * ac-library
 * MinCostFlow
 *
 * https://atcoder.github.io/ac-library/production/document_ja/mincostflow.html
 *
 */

package library.util;

//MinCostFlowGraph ライブラリ
public class MinCostFlowGraph {

  private final int _n;

  private final java.util.List<Pair> pos;

  private final java.util.List<java.util.List<Edge>> g;

  public MinCostFlowGraph(int n) {
    this._n = n;
    this.pos = new java.util.ArrayList<>();
    this.g = new java.util.ArrayList<>();
    for (int i = 0; i < _n; i++) {
      g.add(new java.util.ArrayList<>());
    }
  }

  public int addEdge(int from, int to, long cap, long cost) {
    java.util.Objects.checkIndex(from, _n);
    java.util.Objects.checkIndex(to, _n);
    if (cap < 0) {
      String errMsg = String.format("given cap %d is negative.", cap);
      throw new IllegalArgumentException(errMsg);
    }
    if (cost < 0) {
      String errMsg = String.format("given cost %d is negative.", cost);
      throw new IllegalArgumentException(errMsg);
    }
    int m = pos.size();
    pos.add(new Pair(from, g.get(from).size()));
    int from_id = g.get(from).size();
    int to_id = g.get(to).size();
    if (from == to) {
      to_id++;
    }
    g.get(from).add(new Edge(to, to_id, cap, cost));
    g.get(to).add(new Edge(from, from_id, 0, -cost));
    return m;
  }

  public MinCostFlowGraphEdge getEdge(int i) {
    java.util.Objects.checkIndex(i, pos.size());
    Pair p = pos.get(i);
    Edge e = g.get(p.first).get(p.second);
    Edge re = g.get(e.to).get(e.rev);
    return new MinCostFlowGraphEdge(pos.get(i).first, e.to, e.cap + re.cap, re.cap, e.cost);
  }

  public java.util.List<MinCostFlowGraphEdge> edges() {
    java.util.List<MinCostFlowGraphEdge> res = new java.util.ArrayList<>();
    for (int i = 0; i < pos.size(); i++) {
      res.add(getEdge(i));
    }
    return res;
  }

  public MinCostFlowResult flowMax(int s, int t) {
    return flow(s, t, Long.MAX_VALUE);
  }

  public MinCostFlowResult flow(int s, int t, long limit) {
    java.util.List<MinCostFlowResult> res = slope(s, t, limit);
    return res.get(res.size() - 1);
  }

  public java.util.List<MinCostFlowResult> slopeMax(int s, int t) {
    return slope(s, t, Long.MAX_VALUE);
  }

  public java.util.List<MinCostFlowResult> slope(int s, int t, long flow_limit) {
    java.util.Objects.checkIndex(s, this._n);
    java.util.Objects.checkIndex(t, this._n);
    if (s == t) {
      String errMsg = String.format("Invalid path: (%d -> %d).", s, t);
      throw new IllegalArgumentException(errMsg);
    }
    long[] dual = new long[_n];
    long[] dist = new long[_n];
    int[] pv = new int[_n];
    int[] pe = new int[_n];
    boolean[] vis = new boolean[_n];
    long flow = 0;
    long cost = 0;
    long prev_cost_per_flow = -1;
    java.util.LinkedList<MinCostFlowResult> result = new java.util.LinkedList<>();
    result.addLast(new MinCostFlowResult(flow, cost));
    while (flow < flow_limit) {
      if (!dualRef(s, t, dual, dist, pv, pe, vis)) {
        break;
      }
      long c = flow_limit - flow;
      for (int v = t; v != s; v = pv[v]) {
        c = Math.min(c, g.get(pv[v]).get(pe[v]).cap);
      }
      for (int v = t; v != s; v = pv[v]) {
        Edge e = g.get(pv[v]).get(pe[v]);
        e.cap -= c;
        g.get(v).get(e.rev).cap += c;
      }
      long d = -dual[s];
      flow += c;
      cost += c * d;
      if (prev_cost_per_flow == d) {
        result.removeLast();
      }
      result.add(new MinCostFlowResult(flow, cost));
      prev_cost_per_flow = d;
    }
    return result;
  }

  private boolean dualRef(int s, int t, long[] dual, long[] dist, int[] pv, int[] pe,
      boolean[] vis) {
    java.util.Arrays.fill(dist, Long.MAX_VALUE);
    java.util.Arrays.fill(pv, -1);
    java.util.Arrays.fill(pe, -1);
    java.util.Arrays.fill(vis, false);

    java.util.PriorityQueue<Q> pq = new java.util.PriorityQueue<>();
    dist[s] = 0;
    pq.add(new Q(0L, s));
    while (!pq.isEmpty()) {
      int v = pq.poll().to;
      if (vis[v]) {
        continue;
      }
      vis[v] = true;
      if (v == t) {
        break;
      }
      for (int i = 0; i < g.get(v).size(); i++) {
        Edge e = g.get(v).get(i);
        if (vis[e.to] || e.cap == 0) {
          continue;
        }
        long cost = e.cost - dual[e.to] + dual[v];
        if (dist[e.to] - dist[v] > cost) {
          dist[e.to] = dist[v] + cost;
          pv[e.to] = v;
          pe[e.to] = i;
          pq.add(new Q(dist[e.to], e.to));
        }
      }
    }
    if (!vis[t]) {
      return false;
    }
    for (int v = 0; v < _n; v++) {
      if (!vis[v]) {
        continue;
      }
      dual[v] -= dist[t] - dist[v];
    }
    return true;
  }

  private static final class Q implements Comparable<Q> {

    final long key;
    final int to;

    Q(long key, int to) {
      this.key = key;
      this.to = to;
    }

    @Override
    public int compareTo(Q o) {
      return Long.compare(key, o.key);
    }
  }

  private static final class Edge {

    final int to, rev;
    long cap, cost;

    Edge(int to, int rev, long cap, long cost) {
      this.to = to;
      this.rev = rev;
      this.cap = cap;
      this.cost = cost;
    }
  }

  private static final class Pair {

    final int first, second;

    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }
}

final class MinCostFlowGraphEdge {

  public final int from, to;
  public final long cap, flow, cost;

  MinCostFlowGraphEdge(int from, int to, long cap, long flow, long cost) {
    this.from = from;
    this.to = to;
    this.cap = cap;
    this.flow = flow;
    this.cost = cost;
  }
}

final class MinCostFlowResult {

  public final long flow, cost;

  MinCostFlowResult(long flow, long cost) {
    this.flow = flow;
    this.cost = cost;
  }
}