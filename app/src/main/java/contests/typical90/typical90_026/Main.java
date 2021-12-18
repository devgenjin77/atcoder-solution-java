/*
 * 競プロ典型90問
 * 026 - Independent Set on a Tree（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_z
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/27972859
 *
 */
package contests.typical90.typical90_026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

  static final int COLOR_NONE = 0;
  static final int COLOR_RED = 1;
  static final int COLOR_BLACK = 2;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<List<Integer>> edge_list = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      edge_list.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      String[] ab = br.readLine().split(" ");
      int a = Integer.parseInt(ab[0]) - 1;
      int b = Integer.parseInt(ab[1]) - 1;
      edge_list.get(a).add(b);
      edge_list.get(b).add(a);
    }
    br.close();
    int[] colors = new int[n];
    List<Integer> red = new ArrayList<>();
    List<Integer> black = new ArrayList<>();
    Deque<Integer> deque = new ArrayDeque<>();
    colors[0] = COLOR_RED;
    red.add(0);
    deque.push(0);
    while (!deque.isEmpty()) {
      int node = deque.pop();
      int next_color = colors[node] == COLOR_RED ? COLOR_BLACK : COLOR_RED;
      for (int next : edge_list.get(node)) {
        if (colors[next] == COLOR_NONE) {
          colors[next] = next_color;
          deque.push(next);
          if (next_color == COLOR_RED) {
            red.add(next);
          } else {
            black.add(next);
          }
        }
      }
    }
    List<Integer> ans_list = red.size() * 2 >= n ? red : black;
    StringBuilder sb = new StringBuilder();
    sb.append(ans_list.get(0) + 1);
    for (int idx = 1; idx < n / 2; idx++) {
      sb.append(" ").append(ans_list.get(idx) + 1);
    }
    System.out.println(sb.toString());
  }
}
