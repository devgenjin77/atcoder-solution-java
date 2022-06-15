/*
 * AtCoder Beginner Contest 217
 * D - Cutting Woods
 * https://atcoder.jp/contests/abc217/tasks/abc217_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc217/submissions/32489267
 *
 */

package contests.abc.abc21x.abc217.abc217_d;

import java.io.PrintWriter;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int l = Integer.parseInt(sc.next());
    int q = Integer.parseInt(sc.next());
    TreeSet<Integer> set_len = new TreeSet<>();
    set_len.add(0);
    set_len.add(l);
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      int c = Integer.parseInt(sc.next());
      int x = Integer.parseInt(sc.next());
      if (c == 1) {
        set_len.add(x);
      } else if (c == 2) {
        pw.println(set_len.higher(x) - set_len.lower(x));
      }
    }
    pw.close();
    sc.close();
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
