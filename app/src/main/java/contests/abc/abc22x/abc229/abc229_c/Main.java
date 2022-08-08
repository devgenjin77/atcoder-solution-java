/*
 * NECプログラミングコンテスト2021
 * （AtCoder Beginner Contest 229）
 * C - Cheese
 * https://atcoder.jp/contests/abc229/tasks/abc229_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc229/submissions/33881114
 *
 * note:
 * 美味しさが高い順番に貪欲法を使っていく
 *
 */

package contests.abc.abc22x.abc229.abc229_c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final long w = Long.parseLong(sc.next());
    final List<LongPair> list_pair = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      long a = Long.parseLong(sc.next());
      long b = Long.parseLong(sc.next());
      list_pair.add(new LongPair(a, b));
    }
    sc.close();

    Collections.sort(list_pair, Collections.reverseOrder());
    long remain = w;
    long ans = 0;
    for (int i = 0; i < n; i++) {
      LongPair obj = list_pair.get(i);
      long use = Math.min(obj.second, remain);
      ans += obj.first * use;
      remain -= use;
      if (remain <= 0) {
        break;
      }
    }
    System.out.println(ans);
  }

  static class LongPair implements Comparable<LongPair> {

    long first, second;

    public LongPair(long first, long second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public int compareTo(LongPair o) {
      if (first != o.first) {
        return Long.compare(first, o.first);
      } else {
        return Long.compare(second, o.second);
      }
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      LongPair pair = (LongPair) o;
      return first == pair.first && second == pair.second;
    }

    @Override
    public int hashCode() {
      return java.util.Objects.hash(first, second);
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
