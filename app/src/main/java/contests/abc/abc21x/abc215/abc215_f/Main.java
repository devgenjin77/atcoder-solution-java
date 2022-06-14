/*
 * AtCoder Beginner Contest 215
 * F - Dist Max 2
 * https://atcoder.jp/contests/abc215/tasks/abc215_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc215/submissions/32462857
 *
 * note:
 * 解を二分探索で求める
 */

package contests.abc.abc21x.abc215.abc215_f;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    List<IntPair> list_pt = new ArrayList<>();
    int x_max = 0, y_max = 0;
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(sc.next());
      int y = Integer.parseInt(sc.next());
      x_max = Math.max(x, x_max);
      y_max = Math.max(y, y_max);
      list_pt.add(new IntPair(x, y));
    }
    sc.close();
    Collections.sort(list_pt);
    int ng = Math.max(x_max, y_max) + 1, ok = -1;
    while (ng - ok > 1) {
      int mid = (ng + ok) / 2;
      int j = 0;
      //今まで見たYの最大最小
      int seen_y_max = 0, seen_y_min = 1_000_000_001;
      boolean isOk = false;
      for (int i = 1; i < n; i++) {
        IntPair p = list_pt.get(i);
        while (p.first - list_pt.get(j).first >= mid && i > j) {
          int next_y = list_pt.get(j++).second;
          seen_y_max = Math.max(next_y, seen_y_max);
          seen_y_min = Math.min(next_y, seen_y_min);
        }
        if (seen_y_max - p.second >= mid || p.second - seen_y_min >= mid) {
          isOk = true;
          break;
        }
      }
      if (isOk) {
        ok = mid;
      } else {
        ng = mid;
      }
    }
    System.out.println(ok);
  }

  //IntPairライブラリ
  static class IntPair implements Comparable<IntPair> {

    int first, second;

    public IntPair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public int compareTo(IntPair o) {
      if (first != o.first) {
        return Integer.compare(first, o.first);
      } else {
        return Integer.compare(second, o.second);
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
