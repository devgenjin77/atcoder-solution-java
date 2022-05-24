/*
 * 競プロ典型90問
 * 061 - Deck（★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bi
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31938129
 *
 * note:
 * -dequeをつかうとTLEするので、配列操作でなんとか凌ぐ
 *
 */

package contests.typical90.typical90_07.typical90_061;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int q = Integer.parseInt(sc.next());
    int[] dummy_queue = new int[q * 2];
    int offset_l = q, offset_r = q;
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      int type = Integer.parseInt(sc.next());
      int x = Integer.parseInt(sc.next());
      if (type == 1) {
        dummy_queue[--offset_l] = x;
      } else if (type == 2) {
        dummy_queue[offset_r++] = x;
      } else if (type == 3) {
        pw.println(dummy_queue[offset_l + x - 1]);
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
