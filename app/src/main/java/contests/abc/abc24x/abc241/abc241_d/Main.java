/*
 * ABC241
 * D - Sequence Query
 * https://atcoder.jp/contests/abc241/tasks/abc241_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc241/submissions/32310187
 *
 */

package contests.abc.abc24x.abc241.abc241_d;

import java.io.PrintWriter;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int q = Integer.parseInt(sc.next());
    TreeMap<Long, Integer> t_map = new TreeMap<>();
    PrintWriter pw = new PrintWriter(System.out);
    for (int cnt = 0; cnt < q; cnt++) {
      int type = Integer.parseInt(sc.next());
      long x = Long.parseLong(sc.next());
      if (type == 1) {
        t_map.put(x, t_map.getOrDefault(x, 0) + 1);
      } else if (type == 2) {
        int k = Integer.parseInt(sc.next());
        while (true) {
          Long f_key = t_map.floorKey(x);
          if (f_key == null) {
            pw.println(-1);
            break;
          } else {
            int cnt_key = t_map.get(f_key);
            if (cnt_key >= k) {
              pw.println(f_key);
              break;
            } else {
              k -= cnt_key;
              x = f_key - 1;
            }
          }
        }
      } else if (type == 3) {
        int k = Integer.parseInt(sc.next());
        while (true) {
          Long f_key = t_map.ceilingKey(x);
          if (f_key == null) {
            pw.println(-1);
            break;
          } else {
            int cnt_key = t_map.get(f_key);
            if (cnt_key >= k) {
              pw.println(f_key);
              break;
            } else {
              k -= cnt_key;
              x = f_key + 1;
            }
          }
        }
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
