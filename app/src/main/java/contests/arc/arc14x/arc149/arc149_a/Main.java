/*
 * AtCoder Regular Contest 149
 * A - Repdigit Number
 * https://atcoder.jp/contests/arc149/tasks/arc149_a
 *
 * verified:
 * - https://atcoder.jp/contests/arc149/submissions/35605501
 *
 * note:
 *
 */

package contests.arc.arc14x.arc149.arc149_a;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final long m = Long.parseLong(sc.next());
    sc.close();
    final long[][] dp = new long[n + 1][10];
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= 9; j++) {
        dp[i][j] = (dp[i - 1][j] * 10) + j;
        dp[i][j] %= m;
      }
    }
    boolean found = false;
    int d = 0, cnt = 0;
    main_loop:
    for (int i = n; i >= 1; i--) {
      for (int j = 9; j >= 1; j--) {
        if (dp[i][j] == 0) {
          found = true;
          d = j;
          cnt = i;
          break main_loop;
        }
      }
    }
    if (found) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < cnt; i++) {
        sb.append(d);
      }
      System.out.println(sb);
    } else {
      System.out.println(-1);
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
