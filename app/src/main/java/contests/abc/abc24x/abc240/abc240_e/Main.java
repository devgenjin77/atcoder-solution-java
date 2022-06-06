/*
 * ABC240
 * E - Ranges on Tree
 * https://atcoder.jp/contests/abc240/tasks/abc240_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc240/submissions/32291220
 *
 */

package contests.abc.abc24x.abc240.abc240_e;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

  static List<List<Integer>> list_adj;

  static int[] array_l;

  static int[] array_r;

  static int counter;

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    list_adj = new ArrayList<>();
    array_l = new int[n];
    array_r = new int[n];
    counter = 1;
    for (int i = 0; i < n; i++) {
      list_adj.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int u = Integer.parseInt(sc.next()) - 1;
      int v = Integer.parseInt(sc.next()) - 1;
      list_adj.get(u).add(v);
      list_adj.get(v).add(u);
    }
    sc.close();
    dfs(0, -1);
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      sb.append(array_l[i]).append(' ').append(array_r[i]);
      pw.println(sb.toString());
    }
    pw.close();
  }

  static void dfs(int v, int p) {
    if (p >= 0 && list_adj.get(v).size() == 1) {
      //葉の場合
      array_l[v] = counter;
      array_r[v] = counter;
      counter++;
    } else {
      int l = list_adj.size(), r = 0;
      for (int next_v : list_adj.get(v)) {
        if (next_v == p) {
          continue;
        }
        dfs(next_v, v);
        l = Math.min(array_l[next_v], l);
        r = Math.max(array_r[next_v], r);
      }
      array_l[v] = l;
      array_r[v] = r;
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
