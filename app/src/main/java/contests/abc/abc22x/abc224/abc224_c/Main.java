/*
 * AtCoder Beginner Contest 224
 * C - Triangle?
 * https://atcoder.jp/contests/abc224/tasks/abc224_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc224/submissions/33539243
 *
 * note:
 * 3点が同一直線上にあるか判定する
 *
 */

package contests.abc.abc22x.abc224.abc224_c;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final long[] array_x = new long[n];
    final long[] array_y = new long[n];
    for (int i = 0; i < n; i++) {
      array_x[i] = Long.parseLong(sc.next());
      array_y[i] = Long.parseLong(sc.next());
    }
    sc.close();
    int ans = 0;
    for (int i = 0; i < n - 2; i++) {
      for (int j = i + 1; j < n - 1; j++) {
        for (int k = j + 1; k < n; k++) {
          long dx1 = array_x[i] - array_x[j];
          long dx2 = array_x[i] - array_x[k];
          long dy1 = array_y[i] - array_y[j];
          long dy2 = array_y[i] - array_y[k];
          //同一直線上にあるかの判定
          if (dx1 * dy2 != dx2 * dy1) {
            ans++;
          }
        }
      }
    }
    System.out.println(ans);
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
