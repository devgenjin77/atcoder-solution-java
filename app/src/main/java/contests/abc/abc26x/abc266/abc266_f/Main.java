/*
 * AtCoder Beginner Contest 266
 * F - Well-defined Path Queries on a Namori
 * https://atcoder.jp/contests/abc266/tasks/abc266_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc266/submissions/35052794
 *
 * note:
 **
 */

package contests.abc.abc26x.abc266.abc266_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final List<List<Integer>> list_adj = new ArrayList<>();
    final int[] deg = new int[n];
    final Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      list_adj.add(new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
      StringTokenizer st_uv = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st_uv.nextToken()) - 1;
      int v = Integer.parseInt(st_uv.nextToken()) - 1;
      list_adj.get(u).add(v);
      list_adj.get(v).add(u);
      deg[u]++;
      deg[v]++;
    }
    DisjointSetUnion dsu = new DisjointSetUnion(n);
    //次数１の頂点をキューに入れる
    for (int i = 0; i < n; i++) {
      if (deg[i] == 1) {
        queue.add(i);
      }
    }
    while (!queue.isEmpty()) {
      int p = queue.poll();
      deg[p]--;
      for (int v : list_adj.get(p)) {
        dsu.merge(p, v);
        if (deg[v] > 1) {
          deg[v]--;
          if (deg[v] == 1) {
            queue.add(v);
          }
        }
      }
    }
    final int q = Integer.parseInt(br.readLine());
    final PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      StringTokenizer st_xy = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st_xy.nextToken()) - 1;
      int y = Integer.parseInt(st_xy.nextToken()) - 1;
      pw.println(dsu.isSame(x, y) ? "Yes" : "No");
    }
    pw.close();
    br.close();
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
}
