/*
 * AtCoder Beginner Contest 218
 * E - Destruction
 * https://atcoder.jp/contests/abc218/tasks/abc218_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc218/submissions/32802074
 *
 */

package contests.abc.abc21x.abc218.abc218_e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int m = Integer.parseInt(sc.next());
    final List<CostedEdge> list_edge = new ArrayList<>();
    final DisjointSetUnion dsu = new DisjointSetUnion(n);
    for (int i = 0; i < m; i++) {
      int a = Integer.parseInt(sc.next()) - 1;
      int b = Integer.parseInt(sc.next()) - 1;
      long c = Long.parseLong(sc.next());
      if (c <= 0) {
        dsu.merge(a, b);
      } else {
        list_edge.add(new CostedEdge(a, b, c));
      }
    }
    sc.close();
    long ans = 0;
    Collections.sort(list_edge);
    for (CostedEdge edge : list_edge) {
      if (!dsu.isSame(edge.a, edge.b)) {
        dsu.merge(edge.a, edge.b);
      } else {
        ans += edge.cost;
      }
    }
    System.out.println(ans);
  }

  static class CostedEdge implements Comparable<CostedEdge> {

    int a, b;
    long cost;

    CostedEdge(int a, int b, long cost) {
      this.a = a;
      this.b = b;
      this.cost = cost;
    }

    @Override
    public int compareTo(CostedEdge o) {
      int cmp_cost = Long.compare(cost, o.cost);
      if (cmp_cost != 0) {
        return cmp_cost;
      }
      int cmp_a = Integer.compare(a, o.a);
      if (cmp_a != 0) {
        return cmp_a;
      } else {
        return Integer.compare(b, o.b);
      }
    }
  }

  //DisjointSetUnionライブラリ
  static class DisjointSetUnion {

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
