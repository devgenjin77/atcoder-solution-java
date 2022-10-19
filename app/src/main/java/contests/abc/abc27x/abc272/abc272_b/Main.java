/*
 * AtCoder Beginner Contest 272
 * B - Everyone is Friends
 * https://atcoder.jp/contests/abc272/tasks/abc272_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc272/submissions/35793668
 *
 * note:
 *
 *
 */

package contests.abc.abc27x.abc272.abc272_b;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int m = Integer.parseInt(sc.next());
    final boolean[][] is_attended = new boolean[n][n];
    for (int i = 0; i < m; i++) {
      int k = Integer.parseInt(sc.next());
      int[] attend = new int[k];
      for (int j = 0; j < k; j++) {
        attend[j] = Integer.parseInt(sc.next()) - 1;
      }
      for (int x1 = 0; x1 < k - 1; x1++) {
        for (int x2 = x1 + 1; x2 < k; x2++) {
          is_attended[attend[x1]][attend[x2]] = true;
        }
      }
    }
    sc.close();
    boolean isOk = true;
    main_loop:
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (!is_attended[i][j]) {
          isOk = false;
          break main_loop;
        }
      }
    }
    System.out.println(isOk ? "Yes" : "No");
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
