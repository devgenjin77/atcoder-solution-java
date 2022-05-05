/*
 * ABC223
 * D - Restricted Permutation
 * https://atcoder.jp/contests/abc223/tasks/abc223_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc223/submissions/31448934
 *
 * note:
 * トポロジカルソート
 */

package contests.abc.abc223.abc223_d;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int m = Integer.parseInt(sc.next());
    List<List<Integer>> list_adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list_adj.add(new ArrayList<>());
    }
    //入次数
    int[] indegree = new int[n];
    for (int i = 0; i < m; i++) {
      int a = Integer.parseInt(sc.next()) - 1;
      int b = Integer.parseInt(sc.next()) - 1;
      list_adj.get(a).add(b);
      indegree[b]++;
    }
    sc.close();

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int i = 0; i < n; i++) {
      if (indegree[i] == 0) {
        queue.add(i);
      }
    }
    List<String> list_ans = new ArrayList<>();
    while (!queue.isEmpty()) {
      int u = queue.poll();
      list_ans.add(String.valueOf(u + 1));
      for (int v : list_adj.get(u)) {
        indegree[v] -= 1;
        if (indegree[v] == 0) {
          queue.add(v);
        }
      }
    }
    if (list_ans.size() == n) {
      System.out.println(list_ans.stream().collect(Collectors.joining(" ")));
    } else {
      System.out.println(-1);
    }
  }
}

//NextScannerライブラリ
class NextScanner implements AutoCloseable {

  private final java.io.BufferedReader br;

  private java.util.StringTokenizer st;

  private static final int BUF_SIZE = 1024;

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
