/*
 * ABC240
 * E - Ranges on Tree
 * https://atcoder.jp/contests/abc240/tasks/abc240_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc240/submissions/29831083
 *
 */
package contests.abc.abc240.abc240_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  static int leaf_counter;

  static int[][] lr;

  static List<List<Integer>> edge_list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    edge_list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      edge_list.add(new ArrayList<>());
    }
    for (int cnt = 1; cnt <= n - 1; cnt++) {
      String[] uv = br.readLine().split(" ");
      int u = Integer.parseInt(uv[0]) - 1;
      int v = Integer.parseInt(uv[1]) - 1;
      edge_list.get(u).add(v);
      edge_list.get(v).add(u);
    }
    br.close();

    leaf_counter = 0;
    lr = new int[2][n];
    Arrays.fill(lr[0], Integer.MAX_VALUE);
    Arrays.fill(lr[1], 0);
    dfs(0, -1);
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < n; i++) {
      pw.print(lr[0][i]);
      pw.print(" ");
      pw.println(lr[1][i]);
    }
    pw.close();
  }

  static void dfs(int current, int parent) {
    List<Integer> child_list = edge_list.get(current);
    if (child_list.size() == 1 && child_list.get(0) == parent) {
      lr[0][current] = lr[1][current] = ++leaf_counter;
      return;
    }
    for (int child : child_list) {
      if (child != parent) {
        dfs(child, current);
        lr[0][current] = Math.min(lr[0][child], lr[0][current]);
        lr[1][current] = Math.max(lr[1][child], lr[1][current]);
      }
    }
  }
}
