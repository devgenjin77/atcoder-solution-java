/*
 * ABC218
 * E - Destruction
 * https://atcoder.jp/contests/abc218/tasks/abc218_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc218/submissions/31447172
 */

package contests.abc.abc218.abc218_e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int m = Integer.parseInt(sc.next());
    DisjointSetUnion dsu = new DisjointSetUnion(n);
    List<Edge> costed_edge = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      int u = Integer.parseInt(sc.next()) - 1;
      int v = Integer.parseInt(sc.next()) - 1;
      long cost = Long.parseLong(sc.next());
      if (cost <= 0) {
        dsu.merge(u, v);
      } else {
        costed_edge.add(new Edge(u, v, cost));
      }
    }
    sc.close();
    Collections.sort(costed_edge);
    long score = 0;
    for (int i = 0; i < costed_edge.size(); i++) {
      Edge e = costed_edge.get(i);
      if (dsu.isSame(e.u, e.v)) {
        score += e.cost;
      } else {
        dsu.merge(e.u, e.v);
      }
    }
    System.out.println(score);
  }

  static final class Edge implements Comparable<Edge> {

    final int u, v;
    final long cost;

    Edge(int u, int v, long cost) {
      this.u = u;
      this.v = v;
      this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
      int cmp_cost = Long.compare(cost, o.cost);
      if (cmp_cost != 0) {
        return cmp_cost;
      }
      int cmp_u = Integer.compare(u, o.u);
      if (cmp_u != 0) {
        return cmp_u;
      } else {
        return Integer.compare(v, o.v);
      }
    }
  }
}

//DisjointSetUnionライブラリ
class DisjointSetUnion {

  private final int n;
  private final int[] parent_or_size;

  public DisjointSetUnion(int n) {
    this.n = n;
    parent_or_size = new int[n];
    java.util.Arrays.fill(parent_or_size, -1);
  }

  public int merge(int a, int b) {
    if (!(0 <= a && a < n) || !(0 <= b && b < n)) {
      return -1;
    }
    int x = leader(a);
    int y = leader(b);
    if (x == y) {
      return x;
    }
    if (-parent_or_size[x] < -parent_or_size[y]) {
      int temp = x;
      x = y;
      y = temp;
    }
    parent_or_size[x] += parent_or_size[y];
    parent_or_size[y] = x;
    return x;
  }

  public boolean isSame(int a, int b) {
    if (!(0 <= a && a < n) || !(0 <= b && b < n)) {
      return false;
    }
    return leader(a) == leader(b);
  }

  public int leader(int a) {
    if (parent_or_size[a] < 0) {
      return a;
    } else {
      parent_or_size[a] = leader(parent_or_size[a]);
      return parent_or_size[a];
    }
  }

  public int size(int a) {
    if (!(0 <= a && a < n)) {
      return -1;
    }
    return -parent_or_size[leader(a)];
  }

  public java.util.List<java.util.List<Integer>> groups() {
    int m = 0;
    java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
    java.util.Map<Integer, Integer> map_leader = new java.util.HashMap<>();
    for (int i = 0; i < n; i++) {
      int lead = leader(i);
      if (!map_leader.containsKey(lead)) {
        map_leader.put(lead, m++);
        result.add(new java.util.ArrayList<>());
      }
      result.get(map_leader.get(lead)).add(i);
    }
    return result;
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
