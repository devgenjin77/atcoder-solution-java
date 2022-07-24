/*
 * AtCoder Beginner Contest 223
 * D - Restricted Permutation
 * https://atcoder.jp/contests/abc223/tasks/abc223_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc223/submissions/33502547
 *
 * note:
 * トポロジカルソートする
 *
 */

package contests.abc.abc22x.abc223.abc223_d;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int m = Integer.parseInt(sc.next());
    //入次数
    final int[] in_degree = new int[n];
    List<List<Integer>> list_adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list_adj.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int a = Integer.parseInt(sc.next()) - 1;
      int b = Integer.parseInt(sc.next()) - 1;
      in_degree[b]++;
      list_adj.get(a).add(b);
    }
    sc.close();

    //入力辺を持たないすべてのノードの集合
    PriorityQueue<Integer> queue_s = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      if (in_degree[i] == 0) {
        queue_s.add(i);
      }
    }

    //トポロジカルソートした結果を蓄積する空リスト
    List<Integer> list_l = new ArrayList<>();
    while (!queue_s.isEmpty()) {
      int cur = queue_s.poll();
      list_l.add(cur);
      for (int v : list_adj.get(cur)) {
        in_degree[v]--;
        if (in_degree[v] == 0) {
          queue_s.add(v);
        }
      }
    }
    if (list_l.size() == n) {
      StringBuilder sb = new StringBuilder();
      for (int v : list_l) {
        sb.append(v + 1).append(' ');
      }
      System.out.println(sb.deleteCharAt(sb.length() - 1));
    } else {
      System.out.println(-1);
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
