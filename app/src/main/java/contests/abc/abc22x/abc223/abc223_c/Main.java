/*
 * AtCoder Beginner Contest 223
 * C - Doukasen
 * https://atcoder.jp/contests/abc223/tasks/abc223_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc223/submissions/33500199
 *
 * note:
 * 全体を焼き切る秒数を求めてから、その半分の秒数で焼き切れる長さを求める
 *
 */

package contests.abc.abc22x.abc223.abc223_c;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int[] array_a = new int[n];
    final int[] array_b = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(sc.next());
      array_b[i] = Integer.parseInt(sc.next());
    }
    sc.close();
    //i本目が全て燃え切る時の秒数
    final double[] array_c = new double[n];
    double sec_total = 0.0;
    for (int i = 0; i < n; i++) {
      array_c[i] = (double) array_a[i] / array_b[i];
      sec_total += array_c[i];
    }
    double sec_remain = sec_total * 0.5;
    double ans = 0.0;
    for (int i = 0; i < n; i++) {
      ans += Math.min(array_c[i], sec_remain) * array_b[i];
      sec_remain -= array_c[i];
      if (sec_remain <= 0.0) {
        break;
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
