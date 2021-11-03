/*
 * 競プロ典型90問
 * 003 - Longest Circular Road（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_c
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/27012476
 *
 */
package contests.typical90.typical90_003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<List<Integer>> edges = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      edges.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      String[] ab = br.readLine().split(" ");
      int a = Integer.parseInt(ab[0]) - 1;
      int b = Integer.parseInt(ab[1]) - 1;
      edges.get(a).add(b);
      edges.get(b).add(a);
    }
    br.close();
    int[] depths = new int[n];
    int most_far1 = bfs(edges, 0, depths);
    int most_far2 = bfs(edges, most_far1, depths);
    System.out.println(depths[most_far2] + 1);
  }

  //最遠点を返却する
  static int bfs(List<List<Integer>> graph, int start, int[] depths) {
    Queue<Integer> queue = new ArrayDeque<>();
    Arrays.fill(depths, -1);
    depths[start] = 0;
    int ret = start;
    queue.add(start);
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for (int next : graph.get(cur)) {
        if (depths[next] < 0) {
          depths[next] = depths[cur] + 1;
          queue.add(next);
        }
        if (depths[ret] < depths[next]) {
          ret = next;
        }
      }
    }
    return ret;
  }
}
