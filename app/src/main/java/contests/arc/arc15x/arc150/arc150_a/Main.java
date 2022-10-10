/*
 * AtCoder Regular Contest 150
 * A - Continuous 1
 * https://atcoder.jp/contests/arc150/tasks/arc150_a
 *
 * verified:
 * - https://atcoder.jp/contests/arc150/submissions/35565073
 *
 * note:
 *
 */

package contests.arc.arc15x.arc150.arc150_a;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int t = Integer.parseInt(sc.next());
    final PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(sc.next());
      int k = Integer.parseInt(sc.next());
      String s = sc.next();
      pw.println(solve(n, k, s) ? "Yes" : "No");
    }
    pw.close();
    sc.close();
  }

  static final boolean solve(int n, int k, String s) {
    //i文字目までに0,1が何個あるかを累積和で管理
    int[] cum_0 = new int[n + 1];
    int[] cum_1 = new int[n + 1];
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      cum_0[i + 1] = c == '0' ? cum_0[i] + 1 : cum_0[i];
      cum_1[i + 1] = c == '1' ? cum_1[i] + 1 : cum_1[i];
    }
    int cnt_ok = 0;
    for (int i = 0; i <= n - k; i++) {
      if (cum_1[i] != 0) {
        //決めた位置より左に1が出ていたら、あとは試す必要なし
        break;
      }
      if (cum_0[i + k] == cum_0[i] && cum_1[n] == cum_1[i + k]) {
        //決めた位置よりK文字の間0が出ない
        //決めた位置よりK文字以降に1が出ない
        cnt_ok++;
        if (cnt_ok > 1) {
          return false;
        }
      }
    }
    return cnt_ok == 1;
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
