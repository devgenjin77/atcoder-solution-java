/*
 * ABC213
 * D - Takahashi Tour
 * https://atcoder.jp/contests/abc213/tasks/abc213_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc213/submissions/31457947
 *
 */

package contests.abc.abc213.abc213_d;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  static List<List<Integer>> list_adj;

  static List<Integer> list_ans;

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    list_adj = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      list_adj.add(new ArrayList<>());
    }
    for (int i = 0; i < n - 1; i++) {
      int a = Integer.parseInt(sc.next()) - 1;
      int b = Integer.parseInt(sc.next()) - 1;
      list_adj.get(a).add(b);
      list_adj.get(b).add(a);
    }
    sc.close();

    list_ans = new ArrayList<>();
    dfs(0, -1);
    StringBuilder sb = new StringBuilder();
    for (int v : list_ans) {
      sb.append(v + 1).append(" ");
    }
    System.out.println(sb.deleteCharAt(sb.length() - 1));
  }

  static void dfs(int v, int p) {
    list_ans.add(v);
    List<Integer> list_to = list_adj.get(v);
    Collections.sort(list_to);
    for (int to : list_to) {
      if (to != p) {
        dfs(to, v);
        list_ans.add(v);
      }
    }
  }
}

//NextScannerライブラリ
class NextScanner implements AutoCloseable {

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
