/*
 * ABC245
 * E - Wrapping Chocolate
 * https://atcoder.jp/contests/abc245/tasks/abc245_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc245/submissions/31404596
 *
 */

package contests.abc.abc245.abc245_e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int m = Integer.parseInt(sc.next());
    int[] array_a = new int[n];
    int[] array_b = new int[n];
    int[] array_c = new int[m];
    int[] array_d = new int[m];
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
    List<RectangleShape> list_shape = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list_shape.add(new RectangleShape(RectangleShape.TYPE_CHOCO, array_a[i], array_b[i]));
    }
    for (int i = 0; i < m; i++) {
      list_shape.add(new RectangleShape(RectangleShape.TYPE_BOX, array_c[i], array_d[i]));
    }
    Collections.sort(list_shape);
    TreeMap<Integer, Integer> map_length_cnt = new TreeMap<>();
    boolean result = true;
    for (int idx = list_shape.size() - 1; idx >= 0; idx--) {
      RectangleShape rs = list_shape.get(idx);
      if (rs.type == RectangleShape.TYPE_BOX) {
        map_length_cnt.put(rs.length, map_length_cnt.getOrDefault(rs.length, 0) + 1);
      } else {
        Integer ceil_key = map_length_cnt.ceilingKey(rs.length);
        if (ceil_key == null) {
          result = false;
          break;
        } else {
          int stock_len = map_length_cnt.get(ceil_key) - 1;
          if (stock_len > 0) {
            map_length_cnt.put(ceil_key, stock_len);
          } else {
            map_length_cnt.remove(ceil_key);
          }
        }
      }
    }
    System.out.println(result ? "Yes" : "No");
  }
}

class RectangleShape implements Comparable<RectangleShape> {

  static final int TYPE_CHOCO = 1;

  static final int TYPE_BOX = 2;

  final int type, width, length;

  RectangleShape(int type, int width, int length) {
    this.type = type;
    this.width = width;
    this.length = length;
  }

  @Override
  public int compareTo(RectangleShape o) {
    int cmp = Integer.compare(width, o.width);
    if (cmp == 0) {
      if(type == o.type) {
        return Integer.compare(length, o.length);
      } else {
        return type == TYPE_BOX ? 1 : -1;
      }
    } else {
      return cmp;
    }
  }
}

//NextScannerライブラリ
class NextScanner implements AutoCloseable {

  private final java.io.BufferedReader br;

  private java.util.StringTokenizer st;

  private static final int BUF_SIZE = 1024;

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
