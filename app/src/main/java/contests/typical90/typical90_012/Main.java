/*
 * 競プロ典型90問
 * 012 - Red Painting（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_l
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/27941567
 *
 */
package contests.typical90.typical90_012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] hw = br.readLine().split(" ");
    int h = Integer.parseInt(hw[0]);
    int w = Integer.parseInt(hw[1]);
    int q = Integer.parseInt(br.readLine());
    int area = h * w;
    boolean[][] used_pos = new boolean[h][w];
    DisjointSetUnion dsu = new DisjointSetUnion(area);
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      String[] query = br.readLine().split(" ");
      if ("1".equals(query[0])) {
        int ri = Integer.parseInt(query[1]) - 1;
        int ci = Integer.parseInt(query[2]) - 1;
        used_pos[ri][ci] = true;
        int pos = (ri * w) + ci;
        for (int diff_r = -1; diff_r <= 1; diff_r++) {
          for (int diff_c = -1; diff_c <= 1; diff_c++) {
            if (Math.abs(diff_r) + Math.abs(diff_c) != 1) {
              continue;
            }
            int next_ri = ri + diff_r;
            int next_ci = ci + diff_c;
            if (next_ri < 0 || next_ri >= h || next_ci < 0 || next_ci >= w) {
              continue;
            }
            if (used_pos[next_ri][next_ci]) {
              dsu.merge(pos, (next_ri * w) + next_ci);
            }
          }
        }
      } else if ("2".equals(query[0])) {
        int rai = Integer.parseInt(query[1]) - 1;
        int cai = Integer.parseInt(query[2]) - 1;
        int rbi = Integer.parseInt(query[3]) - 1;
        int cbi = Integer.parseInt(query[4]) - 1;
        int pos_a = (rai * w) + cai;
        int pos_b = (rbi * w) + cbi;
        if (used_pos[rai][cai] && used_pos[rbi][cbi] && dsu.isSame(pos_a, pos_b)) {
          pw.println("Yes");
        } else {
          pw.println("No");
        }
      }
    }
    pw.close();
    br.close();
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
