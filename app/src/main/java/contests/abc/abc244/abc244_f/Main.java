/*
 * ABC244
 * F - Shortest Good Path
 * https://atcoder.jp/contests/abc244/tasks/abc244_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc244/submissions/31387356
 *
 */

package contests.abc.abc244.abc244_f;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int m = Integer.parseInt(sc.next());
    int[][] matrix = new int[n][n];
    for (int i = 0; i < m; i++) {
      int u = Integer.parseInt(sc.next()) - 1;
      int v = Integer.parseInt(sc.next()) - 1;
      matrix[u][v] = 1;
      matrix[v][u] = 1;
    }
    sc.close();
    int[][] dp = new int[n][1 << n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
    Queue<Pair> queue = new ArrayDeque<>();
    for (int s = 0; s < n; s++) {
      dp[s][1 << s] = 1;
      queue.add(new Pair(s, 1 << s));
    }
    while (!queue.isEmpty()) {
      Pair p = queue.poll();
      for (int to = 0; to < n; to++) {
        if (matrix[p.vertex][to] == 1) {
          int bit_next = p.bit ^ (1 << to);
          if (dp[to][bit_next] == Integer.MAX_VALUE) {
            dp[to][bit_next] = dp[p.vertex][p.bit] + 1;
            queue.add(new Pair(to, bit_next));
          }
        }
      }
    }
    long ans = 0;
    for (int bit = 1; bit < 1 << n; bit++) {
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        min = Math.min(dp[i][bit], min);
      }
      ans += min;
    }
    System.out.println(ans);
  }

  static class Pair {

    final int vertex, bit;

    Pair(int vertex, int bit) {
      this.vertex = vertex;
      this.bit = bit;
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
