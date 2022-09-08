/*
 * NECプログラミングコンテスト2022
 * （AtCoder Beginner Contest 267）
 * E - Erasing Vertices 2
 * https://atcoder.jp/contests/abc267/tasks/abc267_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc267/submissions/34694256
 *
 */

package contests.abc.abc26x.abc267.abc267_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    long[] cost = new long[n];
    long[] total_cost = new long[n];
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      cost[i] = Long.parseLong(st_a.nextToken());
    }
    boolean[] isDeleted = new boolean[n];
    List<List<Integer>> list_adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list_adj.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      StringTokenizer st_uv = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st_uv.nextToken()) - 1;
      int v = Integer.parseInt(st_uv.nextToken()) - 1;
      list_adj.get(u).add(v);
      list_adj.get(v).add(u);
      total_cost[u] += cost[v];
      total_cost[v] += cost[u];
    }
    br.close();
    PriorityQueue<Node> queue = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      queue.add(new Node(i, total_cost[i]));
    }
    long ans = 0;
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (isDeleted[node.no]) {
        continue;
      }
      for (int no : list_adj.get(node.no)) {
        if (!isDeleted[no]) {
          total_cost[no] -= cost[node.no];
          queue.add(new Node(no, total_cost[no]));
        }
      }
      ans = Math.max(node.cost, ans);
      isDeleted[node.no] = true;
    }
    System.out.println(ans);
  }

  static class Node implements Comparable<Node> {

    int no;
    long cost;

    Node(int no, long cost) {
      this.no = no;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      return Long.compare(this.cost, o.cost);
    }
  }
}
