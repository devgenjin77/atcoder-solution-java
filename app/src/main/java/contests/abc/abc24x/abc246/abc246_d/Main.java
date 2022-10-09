/*
 * AtCoder Beginner Contest 246
 * D - 2-variable Function
 * https://atcoder.jp/contests/abc246/tasks/abc246_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc246/submissions/35530891
 *
 * note:
 * 尺取法、三乗根
 */

package contests.abc.abc24x.abc246.abc246_d;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final long n = Long.parseLong(sc.next());
    sc.close();
    final long max = (long) Math.ceil(Math.cbrt(n));
    long ans = Long.MAX_VALUE;
    long a = 0, b = max;
    while (a <= b) {
      long tmp = func(a, b);
      if (tmp == n) {
        ans = tmp;
        break;
      } else if (tmp < n) {
        a++;
      } else {
        ans = Math.min(tmp, ans);
        b--;
      }
    }
    System.out.println(ans);
  }

  static final long func(long a, long b) {
    return (a * a * a) + (a * a * b) + (a * b * b) + (b * b * b);
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
