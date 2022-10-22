/*
 * 京セラプログラミングコンテスト2022
 * （AtCoder Beginner Contest 271）
 * D - Flip and Adjust
 * https://atcoder.jp/contests/abc271/tasks/abc271_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc271/submissions/35855345
 *
 */

package contests.abc.abc27x.abc271.abc271_d;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int s = Integer.parseInt(sc.next());
    final int[] array_a = new int[n];
    final int[] array_b = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(sc.next());
      array_b[i] = Integer.parseInt(sc.next());
    }
    sc.close();
    final boolean[][] can_make = new boolean[n + 1][s + 1];
    can_make[0][0] = true;
    int max = 0, next_max = 0;
    for (int i = 1; i <= n; i++) {
      max = next_max;
      for (int j = 0; j <= max; j++) {
        if (!can_make[i - 1][j]) {
          continue;
        }
        int use_a = j + array_a[i - 1];
        if (use_a <= s) {
          can_make[i][use_a] = true;
          next_max = Math.max(use_a, next_max);
        }
        int use_b = j + array_b[i - 1];
        if (use_b <= s) {
          can_make[i][use_b] = true;
          next_max = Math.max(use_b, next_max);
        }
      }
    }
    if (can_make[n][s]) {
      System.out.println("Yes");
      StringBuilder ans = new StringBuilder();
      int tmp = s;
      for (int i = n; i > 0; i--) {
        int rev_use_a = tmp - array_a[i - 1];
        if (rev_use_a >= 0 && can_make[i - 1][rev_use_a]) {
          ans.append('H');
          tmp = rev_use_a;
        } else {
          ans.append('T');
          tmp = tmp - array_b[i - 1];
        }
      }
      System.out.println(ans.reverse());
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
