/*
 * 競プロ典型90問
 * 081 - Friendly Group（★5）
 * https://atcoder.jp/contests/typical90/tasks/typical90_cc
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/32527307
 *
 * note:
 * -データを二次元にプロット
 * -二次元累積和
 *
 */

package contests.typical90.typical90_09.typical90_081;

public class Main {

  static final int MAX_AB = 5000;

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int k = Integer.parseInt(sc.next());
    final int[][] plot_ab = new int[MAX_AB + 1][MAX_AB + 1];
    int max_a = 0, max_b = 0;
    for (int i = 0; i < n; i++) {
      int a = Integer.parseInt(sc.next());
      int b = Integer.parseInt(sc.next());
      plot_ab[a][b] += 1;
    }
    sc.close();

    //二次元累積和
    for (int pos_a = 1; pos_a <= MAX_AB; pos_a++) {
      for (int pos_b = 1; pos_b <= MAX_AB; pos_b++) {
        plot_ab[pos_a][pos_b] += plot_ab[pos_a][pos_b - 1];
      }
    }
    for (int pos_b = 1; pos_b <= MAX_AB; pos_b++) {
      for (int pos_a = 1; pos_a <= MAX_AB; pos_a++) {
        plot_ab[pos_a][pos_b] += plot_ab[pos_a - 1][pos_b];
      }
    }

    int ans = 0, tmp = 0;
    for (int pos_a = k + 1; pos_a <= MAX_AB; pos_a++) {
      for (int pos_b = k + 1; pos_b <= MAX_AB; pos_b++) {
        tmp = plot_ab[pos_a][pos_b];
        tmp -= plot_ab[pos_a][pos_b - k - 1];
        tmp -= plot_ab[pos_a - k - 1][pos_b];
        tmp += plot_ab[pos_a - k - 1][pos_b - k - 1];
        ans = Math.max(tmp, ans);
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
