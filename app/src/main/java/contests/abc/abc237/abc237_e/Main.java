/*
 * ABC237
 * E - Skiing
 * https://atcoder.jp/contests/abc237/tasks/abc237_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc237/submissions/28993487
 *
 */
package contests.abc.abc237.abc237_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] head = br.readLine().split(" ");
    int n = Integer.parseInt(head[0]);
    int m = Integer.parseInt(head[1]);
    long[] array_h = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

    List<List<Edge>> list = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      list.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      String[] uv = br.readLine().split(" ");
      int u = Integer.parseInt(uv[0]) - 1;
      int v = Integer.parseInt(uv[1]) - 1;
      if (array_h[u] > array_h[v]) {
        list.get(u).add(new Edge(u, v, 0));
        list.get(v).add(new Edge(v, u, array_h[u] - array_h[v]));
      } else if (array_h[u] < array_h[v]) {
        list.get(u).add(new Edge(u, v, array_h[v] - array_h[u]));
        list.get(v).add(new Edge(v, u, 0));
      } else {
        list.get(u).add(new Edge(u, v, 0));
        list.get(v).add(new Edge(v, u, 0));
      }
    }
    br.close();

    long[] dist = new long[n];
    Arrays.fill(dist, Long.MAX_VALUE);
    Queue<Node> queue = new PriorityQueue<>();
    dist[0] = 0;
    queue.add(new Node(0, 0));
    //ダイクストラ法
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (dist[node.pos] < node.cost) {
        continue;
      }
      List<Edge> edge_list = list.get(node.pos);
      for (Edge edge : edge_list) {
        long next_cost = node.cost + edge.cost;
        if (dist[edge.to] > next_cost) {
          dist[edge.to] = next_cost;
          queue.add(new Node(next_cost, edge.to));
        }
      }
    }
    long ans = Long.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      ans = Math.max(array_h[0] - array_h[i] - dist[i], ans);
    }
    System.out.println(ans);
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
