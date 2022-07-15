/*
 * AtCoder Beginner Contest 221
 * D - Online games
 * https://atcoder.jp/contests/abc221/tasks/abc221_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc221/submissions/33245067
 *
 * note:
 *
 */

package contests.abc.abc22x.abc221.abc221_d;

import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws Exception {
    final NextScanner sc = new NextScanner(System.in);
    final int n = Integer.parseInt(sc.next());
    final TreeMap<Integer, Integer> t_map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      int a = Integer.parseInt(sc.next());
      int b = Integer.parseInt(sc.next());
      //何日目にどれだけログインユーザーの増減があったかをMapで管理する。
      t_map.put(a, t_map.getOrDefault(a, 0) + 1);
      t_map.put(a + b, t_map.getOrDefault(a + b, 0) - 1);
    }
    sc.close();
    int[] mem_cnt = new int[n + 1];
    int now_cnt = 0, now_day = 0;
    for (int day : t_map.keySet()) {
      mem_cnt[now_cnt] += day - now_day;
      now_cnt += t_map.get(day);
      now_day = day;
    }
    StringBuilder ans_buf = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      ans_buf.append(mem_cnt[i]).append(' ');
    }
    System.out.println(ans_buf.deleteCharAt(ans_buf.length() - 1));
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
