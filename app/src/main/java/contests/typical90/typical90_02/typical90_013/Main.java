/*
 * 競プロ典型90問
 * 013 - Passing（★5）
 * https://atcoder.jp/contests/typical90/tasks/typical90_m
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31898644
 *
 * note:
 * ダイクストラ法を二回使う
 *
 */

package contests.typical90.typical90_02.typical90_013;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int m = Integer.parseInt(sc.next());
    DijkstraGraph graph = new DijkstraGraph(n);
    for (int i = 0; i < m; i++) {
      int a = Integer.parseInt(sc.next()) - 1;
      int b = Integer.parseInt(sc.next()) - 1;
      int c = Integer.parseInt(sc.next());
      graph.addCostedEdge(a, b, c);
    }
    sc.close();
    int[] dist_frm_1 = graph.dijkstra(0);
    int[] dist_frm_n = graph.dijkstra(n - 1);
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < n; i++) {
      pw.println(dist_frm_1[i] + dist_frm_n[i]);
    }
    pw.close();
  }

  static class DijkstraGraph {

    private final int _n;

    List<List<CostedEdge>> edge_list;

    public DijkstraGraph(int n) {
      this._n = n;
      this.edge_list = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        this.edge_list.add(new ArrayList<>());
      }
    }

    public void addCostedEdge(int u, int v, int cost) {
      this.edge_list.get(u).add(new CostedEdge(v, cost));
      this.edge_list.get(v).add(new CostedEdge(u, cost));
    }

    public int[] dijkstra(int start) {
      //始点を決めてダイクストラ法を行う
      int[] dist = new int[_n];
      Arrays.fill(dist, Integer.MAX_VALUE);
      dist[start] = 0;
      PriorityQueue<Path> queue = new PriorityQueue<>();
      queue.add(new Path(start, 0));
      while (!queue.isEmpty()) {
        Path p = queue.poll();
        if (dist[p.v] < p.cost) {
          continue;
        }
        for (CostedEdge edge : edge_list.get(p.v)) {
          if (dist[edge.to] > p.cost + edge.cost) {
            dist[edge.to] = p.cost + edge.cost;
            queue.add(new Path(edge.to, p.cost + edge.cost));
          }
        }
      }
      return dist;
    }
  }

  static class CostedEdge {

    int to, cost;

    public CostedEdge(int to, int cost) {
      this.to = to;
      this.cost = cost;
    }
  }

  static class Path implements Comparable<Path> {

    int cost, v;

    public Path(int v, int cost) {
      this.v = v;
      this.cost = cost;
    }

    @Override
    public int compareTo(Path o) {
      if (cost != o.cost) {
        return Integer.compare(cost, o.cost);
      } else {
        return Integer.compare(v, o.v);
      }
    }
  }

  //NextScannerライブラリ
  static class NextScanner implements AutoCloseable {

    private final java.io.BufferedReader br;

    private java.util.StringTokenizer st;

    private static final int BUF_SIZE = 1 << 16;

    private static final char[] c_buf = new char[BUF_SIZE];

    public NextScanner(java.io.InputStream input) {
      this.br = new java.io.BufferedReader(new java.io.InputStreamReader(input));
    }

    private java.util.StringTokenizer readInput() {
      java.util.StringTokenizer st;
      try {
        int b = br.read(c_buf);
        if (b == BUF_SIZE) {
          StringBuilder sb = new StringBuilder();
          sb.append(c_buf);
          sb.append(br.readLine());
          st = new java.util.StringTokenizer(sb.toString());
        } else if (b < 0) {
          throw new java.util.NoSuchElementException();
        } else {
          st = new java.util.StringTokenizer(new String(c_buf, 0, b));
        }
      } catch (java.io.IOException e) {
        throw new java.util.InputMismatchException(e.getMessage());
      }
      return st;
    }

    public String next() throws java.io.IOException {
      if (st == null || !st.hasMoreElements()) {
        st = readInput();
      }
      return st.nextToken();
    }

    @Override
    public void close() throws Exception {
      br.close();
    }
  }
}
