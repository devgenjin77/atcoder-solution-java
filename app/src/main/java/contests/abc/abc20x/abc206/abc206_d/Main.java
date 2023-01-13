/*
 * AtCoder Beginner Contest 206
 * （Sponsored by Panasonic）
 * D - KAIBUNsyo
 * https://atcoder.jp/contests/abc206/tasks/abc206_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc206/submissions/37985579
 *
 * note:
 *
 */

package contests.abc.abc20x.abc206.abc206_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static final int MAX = 200_000;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken()) - 1;
    }
    br.close();

    final DisjointSetUnion dsu = new DisjointSetUnion(MAX);
    int idx = 0;
    while (true) {
      int p = n - 1 - idx;
      if (idx >= p) {
        break;
      } else {
        dsu.merge(array_a[idx], array_a[p]);
      }
      idx++;
    }
    int ans = 0;
    final boolean[] seen = new boolean[MAX];
    for (int i = 0; i < n; i++) {
      if (!seen[dsu.leader(array_a[i])] && dsu.size(array_a[i]) > 1) {
        seen[dsu.leader(array_a[i])] = true;
        ans += dsu.size(array_a[i]) - 1;
      }
    }
    System.out.println(ans);
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
