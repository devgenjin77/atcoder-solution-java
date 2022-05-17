/*
 * ABC212
 * E - Safety Journey
 * https://atcoder.jp/contests/abc212/tasks/abc212_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc212/submissions/31755883
 */

package contests.abc.abc21x.abc212.abc212_e;

import java.util.ArrayList;
import java.util.List;

public class Main {

  static final long MOD = 998244353L;

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner(System.in);
    int n = Integer.parseInt(sc.next());
    int m = Integer.parseInt(sc.next());
    int k = Integer.parseInt(sc.next());
    List<List<Integer>> list_edge = new ArrayList<>(m);
    for (int i = 0; i < n; i++) {
      list_edge.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int u = Integer.parseInt(sc.next()) - 1;
      int v = Integer.parseInt(sc.next()) - 1;
      list_edge.get(u).add(v);
      list_edge.get(v).add(u);
    }
    sc.close();
    //dp[i][j]:=i日目の現在都市がjである通り数
    long[][] dp = new long[k + 1][n];
    dp[0][0] = 1;
    long sum = 1;
    for (int day = 1; day <= k; day++) {
      long sum_next = 0;
      for (int city = 0; city < n; city++) {
        //前日の合計から、自分自身と道がつながらない都市の通り数を引く
        dp[day][city] = (sum + MOD - dp[day - 1][city]) % MOD;
        for (int prev : list_edge.get(city)) {
          dp[day][city] = (dp[day][city] + MOD - dp[day - 1][prev]) % MOD;
        }
        sum_next = (sum_next + dp[day][city]) % MOD;
      }
      sum = sum_next;
    }
    System.out.println(dp[k][0]);
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