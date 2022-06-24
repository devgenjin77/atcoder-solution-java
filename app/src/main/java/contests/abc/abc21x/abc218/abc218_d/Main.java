/*
 * AtCoder Beginner Contest 218
 * D - Rectangles
 * https://atcoder.jp/contests/abc218/tasks/abc218_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc218/submissions/32691629
 *
 */

package contests.abc.abc21x.abc218.abc218_d;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int[] pt_x = new int[n];
    int[] pt_y = new int[n];
    Map<Integer, Set<Integer>> x_to_y = new HashMap<>();
    Map<Integer, Set<Integer>> y_to_x = new HashMap<>();
    for (int i = 0; i < n; i++) {
      pt_x[i] = Integer.parseInt(sc.next());
      pt_y[i] = Integer.parseInt(sc.next());
      if (!x_to_y.containsKey(pt_x[i])) {
        x_to_y.put(pt_x[i], new HashSet<>());
      }
      x_to_y.get(pt_x[i]).add(pt_y[i]);

      if (!y_to_x.containsKey(pt_y[i])) {
        y_to_x.put(pt_y[i], new HashSet<>());
      }
      y_to_x.get(pt_y[i]).add(pt_x[i]);
    }
    sc.close();
    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (pt_x[i] < pt_x[j] && pt_y[i] < pt_y[j]) {
          if (x_to_y.get(pt_x[i]).contains(pt_y[j]) && y_to_x.get(pt_y[i]).contains(pt_x[j])) {
            ans++;
          }
        }
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
