/*
 * UNICORNプログラミングコンテスト2021
 * （AtCoder Beginner Contest 225）
 * E - フ
 * https://atcoder.jp/contests/abc225/tasks/abc225_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc225/submissions/33652979
 *
 * note:
 * 区間スケジューリング問題の応用
 *
 */

package contests.abc.abc22x.abc225.abc225_e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    List<Data> list_data = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      long x = Long.parseLong(sc.next());
      long y = Long.parseLong(sc.next());
      list_data.add(new Data(new Fraction(x, y - 1), new Fraction(x - 1, y)));
    }
    sc.close();
    Collections.sort(list_data);
    Fraction now_second = list_data.get(0).second;
    int ans = 1;
    for (int i = 1; i < n; i++) {
      Data data = list_data.get(i);
      if (now_second.compareTo(data.first) <= 0) {
        ans++;
        now_second = data.second;
      }
    }
    System.out.println(ans);
  }

  static class Data implements Comparable<Data> {

    private final Fraction first, second;

    public Data(Fraction first, Fraction second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public int compareTo(Data o) {
      int cmp = second.compareTo(o.second);
      if (cmp == 0) {
        return first.compareTo(o.first);
      } else {
        return cmp;
      }
    }
  }

  static class Fraction implements Comparable<Fraction> {

    private final long x, y;

    public Fraction(long x, long y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int compareTo(Fraction o) {
      // y/x と o.y/o.xの比較
      return Long.compare(y * o.x, o.y * x);
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
