/*
 * AtCoder Beginner Contest 245
 * E - Wrapping Chocolate
 * https://atcoder.jp/contests/abc245/tasks/abc245_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc245/submissions/35438331
 *
 * note:
 *
 */

package contests.abc.abc24x.abc245.abc245_e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int m = Integer.parseInt(sc.next());
    final int[] array_a = new int[n];
    final int[] array_b = new int[n];
    final int[] array_c = new int[m];
    final int[] array_d = new int[m];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(sc.next());
    }
    for (int i = 0; i < n; i++) {
      array_b[i] = Integer.parseInt(sc.next());
    }
    for (int i = 0; i < m; i++) {
      array_c[i] = Integer.parseInt(sc.next());
    }
    for (int i = 0; i < m; i++) {
      array_d[i] = Integer.parseInt(sc.next());
    }
    sc.close();

    List<RectangularShape> list_choco = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list_choco.add(new RectangularShape(array_a[i], array_b[i]));
    }
    List<RectangularShape> list_box = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      list_box.add(new RectangularShape(array_c[i], array_d[i]));
    }
    Collections.sort(list_choco);
    Collections.sort(list_box);
    TreeMap<Integer, Integer> t_map_s = new TreeMap<>();
    int idx_last_choco = n - 1;
    int idx_last_box = m - 1;
    while (idx_last_choco >= 0) {
      int c_width = list_choco.get(idx_last_choco).width;
      while (idx_last_box >= 0 && list_box.get(idx_last_box).width >= c_width) {
        int b_length = list_box.get(idx_last_box).length;
        t_map_s.put(b_length, t_map_s.getOrDefault(b_length, 0) + 1);
        idx_last_box--;
      }
      int c_length = list_choco.get(idx_last_choco).length;
      Integer ceil = t_map_s.ceilingKey(c_length);
      if (ceil != null) {
        int remain = t_map_s.get(ceil);
        if (remain == 1) {
          t_map_s.remove(ceil);
        } else {
          t_map_s.put(ceil, remain - 1);
        }
      } else {
        break;
      }
      idx_last_choco--;
    }
    System.out.println(idx_last_choco < 0 ? "Yes" : "No");
  }

  static class RectangularShape implements Comparable<RectangularShape> {

    int width, length;

    public RectangularShape(int width, int length) {
      this.width = width;
      this.length = length;
    }

    @Override
    public int compareTo(RectangularShape o) {
      int ret = Integer.compare(this.width, o.width);
      if (ret == 0) {
        ret = Integer.compare(this.length, o.length);
      }
      return ret;
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
