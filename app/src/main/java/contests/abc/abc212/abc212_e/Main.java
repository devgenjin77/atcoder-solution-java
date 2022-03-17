/*
 * ABC212
 * E - Safety Journey
 * https://atcoder.jp/contests/abc212/tasks/abc212_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc212/submissions/30192599
 */
package contests.abc.abc212.abc212_e;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

  static final long MOD = 998244353L;

  static void solve(FastScanner sc, PrintWriter pw) throws Exception {
    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();
    List<List<Integer>> broken_edge_list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      broken_edge_list.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int u = sc.nextInt() - 1;
      int v = sc.nextInt() - 1;
      broken_edge_list.get(u).add(v);
      broken_edge_list.get(v).add(u);
    }

    // dp[i][j]:=i日目に都市jにいる通り数
    long[][] dp = new long[k + 1][n];
    dp[0][0] = 1;
    long sum = 1;
    for (int day = 1; day <= k; day++) {
      long sum_next = 0;
      for (int city = 0; city < n; city++) {
        //除外する通り数：初期値として、前日が同じ都市のケースの通り数
        long exclude_sum = dp[day - 1][city];
        for (int b : broken_edge_list.get(city)) {
          exclude_sum += dp[day - 1][b];
          exclude_sum %= MOD;
        }
        dp[day][city] = (sum + MOD - exclude_sum) % MOD;
        sum_next = (sum_next + MOD + dp[day][city]) % MOD;
      }
      sum = sum_next;
    }
    pw.println(dp[k][0]);
    pw.flush();
  }

  public static void main(String[] args) {
    try (
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out)) {
      solve(sc, pw);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //FastScanner ライブラリ
  static class FastScanner implements AutoCloseable {

    private final java.io.InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buf_len = 0;

    private boolean hasNextByte() {
      if (ptr < buf_len) {
        return true;
      } else {
        ptr = 0;
        try {
          buf_len = in.read(buffer);
        } catch (java.io.IOException e) {
          e.printStackTrace();
        }
        if (buf_len <= 0) {
          return false;
        }
      }
      return true;
    }

    private int readByte() {
      if (hasNextByte()) {
        return buffer[ptr++];
      } else {
        return -1;
      }
    }

    private static boolean isPrintableChar(int c) {
      return 33 <= c && c <= 126;
    }

    public boolean hasNext() {
      while (hasNextByte() && !isPrintableChar(buffer[ptr])) {
        ptr++;
      }
      return hasNextByte();
    }

    public String next() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      StringBuilder sb = new StringBuilder();
      int b = readByte();
      while (isPrintableChar(b)) {
        sb.appendCodePoint(b);
        b = readByte();
      }
      return sb.toString();
    }

    public long nextLong() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      long n = 0;
      boolean minus = false;
      int b = readByte();
      if (b == '-') {
        minus = true;
        b = readByte();
      }
      if (b < '0' || '9' < b) {
        throw new NumberFormatException();
      }
      while (true) {
        if ('0' <= b && b <= '9') {
          n *= 10;
          n += b - '0';
        } else if (b == -1 || !isPrintableChar(b)) {
          return minus ? -n : n;
        } else {
          throw new NumberFormatException();
        }
        b = readByte();
      }
    }

    public int nextInt() {
      long nl = nextLong();
      if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) {
        throw new NumberFormatException();
      }
      return (int) nl;
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    @Override
    public void close() throws Exception {
      in.close();
    }
  }
}