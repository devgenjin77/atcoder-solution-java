/*
 * AtCoder Beginner Contest 233
 * C - Product
 * https://atcoder.jp/contests/abc233/tasks/abc233_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc233/submissions/33906314
 *
 * note:
 * DFSで全パターン探索する
 *
 */

package contests.abc.abc23x.abc233.abc233_c;

import java.util.ArrayList;
import java.util.List;

public class Main {

  static long ans;

  static List<List<Long>> list_ball;

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final long x = Long.parseLong(sc.next());
    list_ball = new ArrayList<>();
    ans = 0;
    for (int i = 0; i < n; i++) {
      List<Long> balls = new ArrayList<>();
      int l = Integer.parseInt(sc.next());
      for (int j = 0; j < l; j++) {
        balls.add(Long.parseLong(sc.next()));
      }
      list_ball.add(balls);
    }
    sc.close();
    dfs(x, 0);
    System.out.println(ans);
  }

  static void dfs(long xx, int level) {
    if (level == list_ball.size()) {
      if (xx == 1) {
        ans++;
      }
      return;
    }
    for (long a : list_ball.get(level)) {
      if (xx >= a && xx % a == 0) {
        dfs(xx / a, level + 1);
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
