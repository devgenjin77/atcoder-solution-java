/*
 * ABC212
 * F - Greedy Takahashi
 * https://atcoder.jp/contests/abc212/tasks/abc212_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc212/submissions/31760357
 */

package contests.abc.abc21x.abc212.abc212_f;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int m = Integer.parseInt(sc.next());
    int q = Integer.parseInt(sc.next());
    List<List<IntPair>> list_bus = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list_bus.add(new ArrayList<>());
    }
    int[] arr_a = new int[m];
    int[] arr_b = new int[m];
    int[] arr_s = new int[m];
    int[] arr_t = new int[m];
    for (int i = 0; i < m; i++) {
      arr_a[i] = Integer.parseInt(sc.next()) - 1;
      arr_b[i] = Integer.parseInt(sc.next()) - 1;
      arr_s[i] = Integer.parseInt(sc.next());
      arr_t[i] = Integer.parseInt(sc.next());
      list_bus.get(arr_a[i]).add(new IntPair(arr_s[i], i));
    }
    for (List<IntPair> list : list_bus) {
      Collections.sort(list);
    }
    int log2m = Integer.toString(m, 2).length();
    //ダブリング
    int[][] doubling = new int[log2m][m];
    for (int i = 0; i < m; i++) {
      List<IntPair> list = list_bus.get(arr_b[i]);
      //各バスについて、到着地点からでる次のバスがを確認し、最も出発時刻が早いものを探す
      int next_pos = Collections.binarySearch(list, new IntPair(arr_t[i], -1));
      next_pos = ~next_pos;
      if (next_pos < list.size()) {
        //到着地点からでる次のバスのうち最も出発時刻が早いもの
        doubling[0][i] = list.get(next_pos).id;
      } else {
        //次のバスがない
        doubling[0][i] = i;
      }
    }
    for (int p = 1; p < log2m; p++) {
      for (int i = 0; i < m; i++) {
        //ダブリング定型
        doubling[p][i] = doubling[p - 1][doubling[p - 1][i]];
      }
    }
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      int x = Integer.parseInt(sc.next());
      int y = Integer.parseInt(sc.next()) - 1;
      int z = Integer.parseInt(sc.next());
      //都市yを時刻x以降に出る一番はやいバスをみる。
      List<IntPair> list = list_bus.get(y);
      int next_pos = Collections.binarySearch(list, new IntPair(x, -1));
      next_pos = ~next_pos;
      if (next_pos < list.size() && list.get(next_pos).start < z) {
        //最初のバスに乗る
        int bus_id = list.get(next_pos).id;
        for (int j = log2m - 1; j >= 0; j--) {
          if (arr_s[doubling[j][bus_id]] < z) {
            bus_id = doubling[j][bus_id];
          }
        }
        if (arr_t[bus_id] < z) {
          pw.println(arr_b[bus_id] + 1);
        } else {
          pw.println(String.format("%d %d", arr_a[bus_id] + 1, arr_b[bus_id] + 1));
        }
      } else {
        //次のバスがないか、zが次のバスが出る時間より前なのでのでxに居続ける
        pw.println(y + 1);
      }
    }
    pw.close();
    sc.close();
  }

  static class IntPair implements Comparable<IntPair> {

    int start, id;

    public IntPair(int start, int id) {
      this.start = start;
      this.id = id;
    }

    @Override
    public int compareTo(IntPair o) {
      if (start != o.start) {
        return Integer.compare(start, o.start);
      } else {
        return Integer.compare(id, o.id);
      }
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
