/*
 * 競プロ典型90問
 * 066 - Various Arrays（★5）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bn
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/32522717
 *
 * note:
 * -期待値の線形性
 * -全てのi,jに対して、転倒数がプラス１となる場合の数を求めて合算
 *
 */

package contests.typical90.typical90_07.typical90_066;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int[] array_l = new int[n];
    int[] array_r = new int[n];
    for (int i = 0; i < n; i++) {
      array_l[i] = Integer.parseInt(sc.next());
      array_r[i] = Integer.parseInt(sc.next());
    }
    sc.close();

    double ans = 0.0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        double now = 0;
        for (int k = array_l[i]; k <= array_r[i]; k++) {
          now += Math.min(k, array_r[j] + 1) - Math.min(k, array_l[j]);
        }
        ans += now / ((array_r[i] + 1 - array_l[i]) * (array_r[j] + 1 - array_l[j]));
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
