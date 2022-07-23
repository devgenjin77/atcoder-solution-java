/*
 * サイシードプログラミングコンテスト2021
 * （AtCoder Beginner Contest 219）
 * E - Moat
 * https://atcoder.jp/contests/abc219/tasks/abc219_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc219/submissions/33422048
 *
 * note:
 * bit全探索
 */

package contests.abc.abc21x.abc219.abc219_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int[][] grid_a = new int[4][4];
    for (int i = 0; i < 4; i++) {
      String[] a = br.readLine().split(" ");
      for (int j = 0; j < 4; j++) {
        grid_a[i][j] = Integer.parseInt(a[j]);
      }
    }
    br.close();
    int ans = 0;
    int[][] grid_map = new int[6][6];
    int village1 = -1;
    for (int bit = 1; bit < 1 << 16; bit++) {
      boolean isOk = true;
      for (int i = 0; i < 16; i++) {
        int a = grid_a[i / 4][i % 4];
        int b = (bit >> i) & 1;
        if (b == 0 && a == 1) {
          // 村が堀の外側にあるパターン
          isOk = false;
          break;
        }
        if (village1 < 0 && a == 1) {
          village1 = (((i / 4) + 1) * 6) + ((i % 4) + 1);
        }
        grid_map[(i / 4) + 1][(i % 4) + 1] = b;
      }
      if (!isOk) {
        continue;
      }
      DisjointSetUnion dsu = new DisjointSetUnion(36);
      for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
          if (i < 5 && grid_map[i][j] == grid_map[i + 1][j]) {
            //右に隣接するマスと同じ値か
            dsu.merge((i * 6) + j, ((i + 1) * 6) + j);
          }
          if (j < 5 && grid_map[i][j] == grid_map[i][j + 1]) {
            //下に隣接するマスと同じ値か
            dsu.merge((i * 6) + j, (i * 6) + (j + 1));
          }
        }
      }
      if (dsu.size(0) + dsu.size(village1) == 36) {
        ans++;
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
