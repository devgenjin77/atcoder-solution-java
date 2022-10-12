/*
 * AtCoder Regular Contest 149
 * B - Two LIS Sum
 * https://atcoder.jp/contests/arc149/tasks/arc149_b
 *
 * verified:
 * - https://atcoder.jp/contests/arc149/submissions/35606012
 *
 * note:
 *
 */

package contests.arc.arc14x.arc149.arc149_b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int[] array_a = new int[n];
    final int[] array_b = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(sc.next());
    }
    for (int i = 0; i < n; i++) {
      array_b[i] = Integer.parseInt(sc.next());
    }
    sc.close();
    List<IntPair> list_pair = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list_pair.add(new IntPair(array_a[i], array_b[i]));
    }
    Collections.sort(list_pair);
    //A_iでソートした時の、B_iのLISを求める
    int[] dp_lis = new int[n];
    Arrays.fill(dp_lis, Integer.MAX_VALUE);
    for (int i = 0; i < n; i++) {
      int v = list_pair.get(i).second;
      int idx = Arrays.binarySearch(dp_lis, v);
      if (idx < 0) {
        idx = ~idx;
      }
      dp_lis[idx] = v;
    }
    int lis = ~Arrays.binarySearch(dp_lis, Integer.MAX_VALUE - 1);
    System.out.println(n + lis);
  }

  static final class IntPair implements Comparable<IntPair> {

    int first, second;

    public IntPair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public int compareTo(IntPair o) {
      int ret = Integer.compare(this.first, o.first);
      return ret == 0 ? Integer.compare(this.second, o.second) : ret;
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
