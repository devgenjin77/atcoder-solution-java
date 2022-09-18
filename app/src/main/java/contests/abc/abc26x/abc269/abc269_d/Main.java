/*
 * UNICORNプログラミングコンテスト2022
 * （AtCoder Beginner Contest 269）
 * D - Do use hexagon grid
 * https://atcoder.jp/contests/abc269/tasks/abc269_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc269/submissions/34972045
 *
 */

package contests.abc.abc26x.abc269.abc269_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static final int[] dx = {-1, -1, 0, 0, 1, 1};

  private static final int[] dy = {-1, 0, -1, 1, 0, 1};

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final int[] array_x = new int[n];
    final int[] array_y = new int[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st_xy = new StringTokenizer(br.readLine());
      array_x[i] = Integer.parseInt(st_xy.nextToken());
      array_y[i] = Integer.parseInt(st_xy.nextToken());
    }
    br.close();

    DisjointSetUnion dsu = new DisjointSetUnion(n);
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (dsu.isSame(i, j)) {
          continue;
        }
        for (int k = 0; k < 6; k++) {
          if (array_x[i] + dx[k] == array_x[j] && array_y[i] + dy[k] == array_y[j]) {
            dsu.merge(i, j);
            break;
          }
        }
      }
    }
    System.out.println(dsu.groups().size());
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
