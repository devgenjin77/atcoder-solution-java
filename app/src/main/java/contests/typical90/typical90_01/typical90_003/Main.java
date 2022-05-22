/*
 * 競プロ典型90問
 * 003 - Longest Circular Road（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_c
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31824672
 *
 * note:
 * グラフの直径を求める
 */

package contests.typical90.typical90_01.typical90_003;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    TreeGraph graph = new TreeGraph(n);
    for (int i = 0; i < n - 1; i++) {
      int u = Integer.parseInt(sc.next()) - 1;
      int v = Integer.parseInt(sc.next()) - 1;
      graph.addEdge(u, v);
    }
    sc.close();
    System.out.println(graph.diameter() + 1);
  }

  static class TreeGraph {

    private final int _n;
    private final List<List<Integer>> list_edge;
    private final int[] dist;
    private int max_depth;
    private int max_depth_v;

    public TreeGraph(int n) {
      this._n = n;
      this.dist = new int[n];
      list_edge = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        list_edge.add(new ArrayList<>());
      }
    }

    public void addEdge(int u, int v) {
      list_edge.get(u).add(v);
      list_edge.get(v).add(u);
    }

    public int diameter() {
      bfs(0);
      bfs(max_depth_v);
      return max_depth;
    }

    private void bfs(int v) {
      Arrays.fill(dist, -1);
      Queue<Integer> queue = new ArrayDeque<>();
      dist[v] = 0;
      max_depth = 0;
      max_depth_v = v;
      queue.add(v);
      while (!queue.isEmpty()) {
        int cur = queue.poll();
        for (int to : list_edge.get(cur)) {
          if (dist[to] == -1) {
            dist[to] = dist[cur] + 1;
            queue.add(to);
            if (dist[to] > max_depth) {
              max_depth = dist[to];
              max_depth_v = to;
            }
          }
        }
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
