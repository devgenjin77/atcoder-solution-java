/*
 * UNICORNプログラミングコンテスト2021
 * （AtCoder Beginner Contest 225）
 * D - Play Train
 * https://atcoder.jp/contests/abc225/tasks/abc225_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc225/submissions/33651065
 *
 * note:
 *
 *
 */

package contests.abc.abc22x.abc225.abc225_d;

import java.io.PrintWriter;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int q = Integer.parseInt(sc.next());
    //後に連結している車
    final int[] next = new int[n];
    //前に連結している車
    final int[] prev = new int[n];
    Arrays.fill(next, -1);
    Arrays.fill(prev, -1);
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      int t = Integer.parseInt(sc.next());
      int x = Integer.parseInt(sc.next()) - 1;
      if (t == 1) {
        int y = Integer.parseInt(sc.next()) - 1;
        next[x] = y;
        prev[y] = x;
      } else if (t == 2) {
        int y = Integer.parseInt(sc.next()) - 1;
        next[x] = -1;
        prev[y] = -1;
      } else if (t == 3) {
        int cur = x;
        //先頭車両をサーチ
        while (prev[cur] != -1) {
          cur = prev[cur];
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (cur != -1) {
          sb.append(' ').append(cur + 1);
          cnt++;
          cur = next[cur];
        }
        sb.insert(0, cnt);
        pw.println(sb.toString());
      }
    }
    pw.close();
    sc.close();
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
