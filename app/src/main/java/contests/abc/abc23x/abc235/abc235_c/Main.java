/*
 * HHKB プログラミングコンテスト 2022
 * （AtCoder Beginner Contest 235）
 * C - The Kth Time Query
 * https://atcoder.jp/contests/abc235/tasks/abc235_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc235/submissions/33917880
 *
 * note:
 *
 *
 */

package contests.abc.abc23x.abc235.abc235_c;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final int q = Integer.parseInt(sc.next());
    final Map<Integer, List<Integer>> map_appear = new HashMap<>();
    for (int cnt = 1; cnt <= n; cnt++) {
      Integer a = Integer.valueOf(sc.next());
      if (map_appear.containsKey(a)) {
        map_appear.get(a).add(cnt);
      } else {
        List<Integer> list = new ArrayList<>();
        list.add(cnt);
        map_appear.put(a, list);
      }
    }
    final PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      Integer x = Integer.valueOf(sc.next());
      int k = Integer.parseInt(sc.next());
      if (map_appear.containsKey(x) && map_appear.get(x).size() >= k) {
        pw.println(map_appear.get(x).get(k - 1));
      } else {
        pw.println(-1);
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
