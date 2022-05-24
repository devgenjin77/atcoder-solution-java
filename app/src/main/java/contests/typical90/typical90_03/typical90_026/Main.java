/*
 * 競プロ典型90問
 * 026 - Independent Set on a Tree（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_z
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31926466
 *
 * note:
 * - 二部グラフの性質
 *
 */

package contests.typical90.typical90_03.typical90_026;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    List<List<Integer>> list_adj = new ArrayList<>();
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
    int[] color = new int[n];
    int[] cnt_color = new int[2];
    Arrays.fill(color, -1);
    color[0] = 0;
    cnt_color[0] = 1;
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    while (!queue.isEmpty()) {
      int v = queue.poll();
      for (int to : list_adj.get(v)) {
        int next_color = 1 - color[v];
        if (color[to] == -1) {
          color[to] = next_color;
          cnt_color[next_color] += 1;
          queue.add(to);
        }
      }
    }
    int target = cnt_color[0] > cnt_color[1] ? 0 : 1;
    StringBuilder sb = new StringBuilder();
    int cnt_ans = 0;
    for (int i = 0; i < n; i++) {
      if (color[i] == target) {
        sb.append(i + 1).append(' ');
        cnt_ans++;
        if (cnt_ans >= n / 2) {
          break;
        }
      }
    }
    System.out.println(sb.deleteCharAt(sb.length() - 1));
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
