/*
 * AtCoder Beginner Contest 216
 * D - Pair of Balls
 * https://atcoder.jp/contests/abc216/tasks/abc216_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc216/submissions/32480085
 *
 */

package contests.abc.abc21x.abc216.abc216_d;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int m = Integer.parseInt(sc.next());
    //各筒の状態を表すキュー
    final List<Queue<Integer>> list_tube = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      list_tube.add(new ArrayDeque<>());
    }
    //取り出せる番号を溜めておくキュー
    final Queue<Integer> queue = new ArrayDeque<>();
    //筒の先頭にある個数
    final int[] cnt_visible = new int[n];
    int[][] num_to_tube_idx = new int[n][2];
    for (int i = 0; i < n; i++) {
      Arrays.fill(num_to_tube_idx[i], -1);
    }
    for (int i = 0; i < m; i++) {
      int k = Integer.parseInt(sc.next());
      for (int j = 0; j < k; j++) {
        int a = Integer.parseInt(sc.next()) - 1;
        list_tube.get(i).add(a);
        if (num_to_tube_idx[a][0] == -1) {
          num_to_tube_idx[a][0] = i;
        } else {
          num_to_tube_idx[a][1] = i;
        }
      }
    }
    sc.close();

    for (Queue<Integer> q : list_tube) {
      int a = q.peek();
      cnt_visible[a]++;
      if (cnt_visible[a] > 1) {
        queue.add(a);
      }
    }

    int cnt = 0;
    while (!queue.isEmpty()) {
      int a = queue.poll();
      cnt++;
      for (int idx : num_to_tube_idx[a]) {
        Queue<Integer> tube = list_tube.get(idx);
        tube.poll();
        if (!tube.isEmpty()) {
          int next_a = tube.peek();
          cnt_visible[next_a]++;
          if (cnt_visible[next_a] > 1) {
            queue.add(next_a);
          }
        }
      }
    }
    System.out.println(cnt == n ? "Yes" : "No");
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
