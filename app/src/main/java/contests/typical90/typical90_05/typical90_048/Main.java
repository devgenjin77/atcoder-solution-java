/*
 * 競プロ典型90問
 * 048 - I will not drop out（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_av
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31933455
 *
 * note:
 * -上界と下界を見積もる
 *
 */

package contests.typical90.typical90_05.typical90_048;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int k = Integer.parseInt(sc.next());
    long[] array_score = new long[2 * n];
    for (int i = 0; i < n; i++) {
      long a = Long.parseLong(sc.next());
      long b = Long.parseLong(sc.next());
      array_score[2 * i] = b;
      array_score[(2 * i) + 1] = a - b;
    }
    sc.close();
    Arrays.sort(array_score);
    long total_score = 0;
    for (int i = (2 * n) - k; i < 2 * n; i++) {
      total_score += array_score[i];
    }
    System.out.println(total_score);
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
