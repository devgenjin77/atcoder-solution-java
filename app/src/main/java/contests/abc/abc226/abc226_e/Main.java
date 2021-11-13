/*
 * ABC226
 * E - Just one
 * https://atcoder.jp/contests/abc226/tasks/abc226_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc226/submissions/27203084
 */
package contests.abc.abc226.abc226_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

  final static long MOD = 998244353;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);
    int[][] edges = new int[m][2];
    DisjointSetUnion dsu = new DisjointSetUnion(n);
    for (int i = 0; i < m; i++) {
      String[] edge = br.readLine().split(" ");
      edges[i][0] = Integer.parseInt(edge[0]) - 1;
      edges[i][1] = Integer.parseInt(edge[1]) - 1;
      dsu.merge(edges[i][0], edges[i][1]);
    }
    br.close();

    int[] num_edges = new int[n];
    int[] num_vertexes = new int[n];
    for (int i = 0; i < m; i++) {
      num_edges[dsu.leader(edges[i][0])] += 1;
    }
    for (int i = 0; i < n; i++) {
      num_vertexes[dsu.leader(i)] += 1;
    }
    long cycle_cnt = 0;
    for (int i = 0; i < n; i++) {
      if (num_vertexes[i] == 0) {
        continue;
      }
      if (num_edges[i] == num_vertexes[i]) {
        cycle_cnt += 1;
      } else {
        cycle_cnt = 0;
        break;
      }
    }
    if (cycle_cnt != 0) {
      System.out.println(pow(2, cycle_cnt, MOD));
    } else {
      System.out.println(0);
    }
  }

  static long pow(long x, long n, long mod) {
    long answer = 1;
    while (n > 0) {
      if ((n & 1) == 1) {
        answer = answer * x % mod;
      }
      x = x * x % mod;
      n >>= 1;
    }
    return answer;
  }
}

class DisjointSetUnion {

  private final int n;
  private int[] parent_or_size;

  DisjointSetUnion(int n) {
    this.n = n;
    parent_or_size = new int[n];
    Arrays.fill(parent_or_size, -1);
  }

  int merge(int a, int b) {
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

  boolean isSame(int a, int b) {
    if (!(0 <= a && a < n) || !(0 <= b && b < n)) {
      return false;
    }
    return leader(a) == leader(b);
  }

  int leader(int a) {
    if (parent_or_size[a] < 0) {
      return a;
    } else {
      parent_or_size[a] = leader(parent_or_size[a]);
      return parent_or_size[a];
    }
  }

  int size(int a) {
    if (!(0 <= a && a < n)) {
      return -1;
    }
    return -parent_or_size[leader(a)];
  }

  List<List<Integer>> groups() {
    int[] leader_buf = new int[n];
    int[] group_size = new int[n];
    for (int i = 0; i < n; i++) {
      leader_buf[i] = leader(i);
      group_size[leader_buf[i]]++;
    }
    List<List<Integer>> result = new ArrayList<>();
    HashMap<Integer, ArrayList<Integer>> list_map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      if (i == leader_buf[i]) {
        list_map.put(i, new ArrayList<>());
      }
    }
    for (int i = 0; i < n; i++) {
      list_map.get(leader_buf[i]).add(i);
    }
    for (Integer key : list_map.keySet()) {
      result.add(list_map.get(key));
    }
    return result;
  }
}
