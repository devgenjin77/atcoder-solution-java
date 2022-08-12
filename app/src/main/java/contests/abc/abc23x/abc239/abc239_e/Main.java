/*
 * デンソークリエイトプログラミングコンテスト2022
 * （AtCoder Beginner Contest 239）
 * E - Subtree K-th Max
 * https://atcoder.jp/contests/abc239/tasks/abc239_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc239/submissions/33965654
 *
 * note:
 *
 *
 */

package contests.abc.abc23x.abc239.abc239_e;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  static final int MAX_K = 20;

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int q = Integer.parseInt(sc.next());
    final int[] array_x = new int[n];
    for (int i = 0; i < n; i++) {
      array_x[i] = Integer.parseInt(sc.next());
    }
    final TreeGraph tree = new TreeGraph(array_x);
    for (int i = 0; i < n - 1; i++) {
      int a = Integer.parseInt(sc.next()) - 1;
      int b = Integer.parseInt(sc.next()) - 1;
      tree.addEdge(a, b);
    }
    tree.build();
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      int v = Integer.parseInt(sc.next()) - 1;
      int k = Integer.parseInt(sc.next()) - 1;
      pw.println(tree.query(v, k));
    }
    pw.close();
    sc.close();
  }

  static class TreeGraph {

    private final int _n;

    private final int[] array_x;

    private final List<List<Integer>> list_adj;

    private final List<List<Integer>> list_nums;

    public TreeGraph(int[] array_x) {
      this._n = array_x.length;
      this.array_x = new int[_n];
      System.arraycopy(array_x, 0, this.array_x, 0, _n);
      list_adj = new ArrayList<>(_n);
      list_nums = new ArrayList<>(_n);
      for (int i = 0; i < _n; i++) {
        list_adj.add(new ArrayList<>());
        list_nums.add(new ArrayList<>());
      }
    }

    public void addEdge(int u, int v) {
      list_adj.get(u).add(v);
      list_adj.get(v).add(u);
    }

    public int query(int v, int k) {
      return list_nums.get(v).get(k);
    }

    public void build() {
      dfs(0, -1);
    }

    private void dfs(int v, int p) {
      List<Integer> children = list_adj.get(v);
      List<Integer> nums_v = list_nums.get(v);
      for (int u : children) {
        if (u == p) {
          continue;
        }
        dfs(u, v);
        List<Integer> nums_u = list_nums.get(u);
        for (int i = 0; i < Math.min(nums_u.size(), MAX_K); i++) {
          //最大20個までを追加
          nums_v.add(nums_u.get(i));
        }
      }
      nums_v.add(array_x[v]);
      Collections.sort(nums_v, Collections.reverseOrder());
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
