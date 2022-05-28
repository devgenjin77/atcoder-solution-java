/*
 * 競プロ典型90問
 * 079 - Two by Two（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ca
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31996388
 *
 * note:
 * -操作の順序によらないことを見抜く
 *
 */

package contests.typical90.typical90_08.typical90_079;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int h = Integer.parseInt(sc.next());
    int w = Integer.parseInt(sc.next());
    long[][] array_a = new long[h][w];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        array_a[i][j] = Long.parseLong(sc.next());
      }
    }
    long[][] array_b = new long[h][w];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        array_b[i][j] = Long.parseLong(sc.next());
      }
    }
    sc.close();
    long ans = 0;
    for (int i = 0; i < h - 1; i++) {
      for (int j = 0; j < w - 1; j++) {
        long diff = array_b[i][j] - array_a[i][j];
        if (diff != 0) {
          array_a[i][j] += diff;
          array_a[i + 1][j] += diff;
          array_a[i][j + 1] += diff;
          array_a[i + 1][j + 1] += diff;
          ans += Math.abs(diff);
        }
      }
    }
    boolean ret = true;
    main_loop:
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        if (array_a[i][j] != array_b[i][j]) {
          ret = false;
          break main_loop;
        }
      }
    }
    if (ret) {
      System.out.println("Yes");
      System.out.println(ans);
    } else {
      System.out.println("No");
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
