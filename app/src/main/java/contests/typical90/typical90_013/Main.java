/*
 * 競プロ典型90問
 * 013 - Passing（★5）
 * https://atcoder.jp/contests/typical90/tasks/typical90_m
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/29131953
 *
 */
package contests.typical90.typical90_013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);

    List<List<Edge>> list = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      list.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      String[] edge = br.readLine().split(" ");
      int n1 = Integer.parseInt(edge[0]) - 1;
      int n2 = Integer.parseInt(edge[1]) - 1;
      long cost = Long.parseLong(edge[2]);
      list.get(n1).add(new Edge(n1, n2, cost));
      list.get(n2).add(new Edge(n2, n1, cost));
    }
    br.close();

    long[] dist_frm1 = solve(list, 0);
    long[] dist_frmn = solve(list, n - 1);

    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < n; i++) {
      pw.println(dist_frm1[i] + dist_frmn[i]);
    }
    pw.close();
  }

  static long[] solve(List<List<Edge>> edge_list, int start) {
    // 街startを起点としたダイクストラ法を実行
    long[] dist = new long[edge_list.size()];
    Arrays.fill(dist, Long.MAX_VALUE);
    dist[start] = 0;
    Queue<Node> queue = new PriorityQueue<>();
    queue.add(new Node(0, start));
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (node.cost > dist[node.pos]) {
        continue;
      }
      List<Edge> sub_edge_list = edge_list.get(node.pos);
      for (Edge edge : sub_edge_list) {
        long next_cost = edge.cost + node.cost;
        if (dist[edge.to] > next_cost) {
          dist[edge.to] = next_cost;
          queue.add(new Node(next_cost, edge.to));
        }
      }
    }
    return dist;
  }

  static class Node implements Comparable<Node> {

    long cost;
    int pos;

    Node(long cost, int pos) {
      this.cost = cost;
      this.pos = pos;
    }

    @Override
    public int compareTo(Node o) {
      return Long.compare(this.cost, o.cost);
    }
  }

  static class Edge {

    int from, to;
    long cost;

    Edge(int from, int to, long cost) {
      this.from = from;
      this.to = to;
      this.cost = cost;
    }
  }
}
