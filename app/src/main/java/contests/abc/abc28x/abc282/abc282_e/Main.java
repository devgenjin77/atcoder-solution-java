/*
 * HHKBプログラミングコンテスト2022 Winter
 * （AtCoder Beginner Contest 282）
 * E - Choose Two and Eat One
 * https://atcoder.jp/contests/abc282/tasks/abc282_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc282/submissions/37382407
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc282.abc282_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final long m = Long.parseLong(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final long[] array_a = new long[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
    }
    br.close();
    final PriorityQueue<CostedEdge> queue = new PriorityQueue<>(Collections.reverseOrder());
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        long score = (pow(array_a[i], array_a[j], m) + pow(array_a[j], array_a[i], m)) % m;
        queue.add(new CostedEdge(i, j, score));
      }
    }
    final DisjointSetUnion dsu = new DisjointSetUnion(n);
    long ans = 0;
    while (!queue.isEmpty()) {
      CostedEdge edge = queue.poll();
      if (!dsu.isSame(edge.x, edge.y)) {
        dsu.merge(edge.x, edge.y);
        ans += edge.cost;
      }
    }
    System.out.println(ans);
  }

  static long pow(long x, long n, long mod) {
    long answer = 1l;
    while (n > 0) {
      if ((n & 1) == 1) {
        answer = answer * x % mod;
      }
      x = x * x % mod;
      n >>= 1;
    }
    return answer;
  }

  static class CostedEdge implements Comparable<CostedEdge> {

    int x, y;
    long cost;


    public CostedEdge(int x, int y, long cost) {
      this.x = x;
      this.y = y;
      this.cost = cost;
    }

    @Override
    public int compareTo(CostedEdge o) {
      if (this.cost != o.cost) {
        return Long.compare(this.cost, o.cost);
      }
      if (this.x != o.x) {
        return Integer.compare(this.x, o.x);
      }
      return Integer.compare(this.y, o.y);
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
}
