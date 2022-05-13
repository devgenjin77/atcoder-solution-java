/*
 * ABC212
 * D - Querying Multiset
 * https://atcoder.jp/contests/abc212/tasks/abc212_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc212/submissions/31641490
 */

package contests.abc.abc21x.abc212.abc212_d;

import java.io.PrintWriter;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int q = Integer.parseInt(sc.next());
    PriorityQueue<Long> queue = new PriorityQueue<>();
    PrintWriter pw = new PrintWriter(System.out);
    long sum = 0;
    for (int i = 0; i < q; i++) {
      switch (Integer.parseInt(sc.next())) {
        case 1:
          queue.add(Long.parseLong(sc.next()) - sum);
          break;
        case 2:
          sum += Long.parseLong(sc.next());
          break;
        case 3:
          pw.println(queue.poll() + sum);
          break;
        default:
          break;
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
