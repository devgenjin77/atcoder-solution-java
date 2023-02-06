/*
 * Toyota Programming Contest 2023 Spring Qual A
 * （AtCoder Beginner Contest 288）
 * E - Wish List
 * https://atcoder.jp/contests/abc288/tasks/abc288_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc288/submissions/38676652
 *
 * note:
 * 左の商品から順に買うかどうかをまず決める。
 * 追加費用C_iについては、以下の考え方をする。
 * 左から100番目の商品について、これまで30個買うことを決めていれば
 * 追加費用はC_71からC_100までの範囲でとることが可能。この区間MINを追加費用にする。
 *
 */

package contests.abc.abc28x.abc288.abc288_e;

import java.util.Arrays;

public class Main {

  private static final long INF = Long.MAX_VALUE / 2;

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int m = sc.nextInt();
    final long[] array_a = new long[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = sc.nextLong();
    }
    final Long[] array_c = new Long[n];
    for (int i = 0; i < n; i++) {
      array_c[i] = Long.valueOf(sc.next());
    }
    final int[] array_x = new int[m];
    for (int i = 0; i < m; i++) {
      array_x[i] = sc.nextInt();
    }
    sc.close();
    final boolean[] is_must = new boolean[n];
    for (int i = 0; i < m; i++) {
      is_must[array_x[i] - 1] = true;
    }
    final long[][] min_cost = new long[n][n];
    for (int i = 0; i < n; i++) {
      min_cost[i][i] = array_c[i];
      for (int j = i + 1; j < n; j++) {
        min_cost[i][j] = Math.min(array_c[j], min_cost[i][j - 1]);
      }
    }
    //dp[i][j]:=i番目の商品について買うかどうか決め、j個買う場合の最小費用
    final long[][] dp = new long[n + 1][n + 1];
    for (int i = 0; i <= n; i++) {
      Arrays.fill(dp[i], INF);
    }
    dp[0][0] = 0L;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        if (dp[i - 1][j] == INF) {
          continue;
        }
        //買う場合
        dp[i][j + 1] = Math.min(dp[i - 1][j] + array_a[i - 1] + min_cost[i - j - 1][i - 1],
            dp[i][j + 1]);
        if (!is_must[i - 1]) {
          //買わない場合（欲しい商品でないときに選択可能）
          dp[i][j] = Math.min(dp[i - 1][j], dp[i][j]);
        }
      }
    }
    long ans = INF;
    for (int i = m; i <= n; i++) {
      ans = Math.min(dp[n][i], ans);
    }
    System.out.println(ans);
  }

  // FastScannerライブラリ
  static class FastScanner implements AutoCloseable {

    private final java.io.InputStream in;
    private final byte[] buf = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    FastScanner(java.io.InputStream source) {
      this.in = source;
    }

    private boolean hasNextByte() {
      if (ptr < buflen) {
        return true;
      } else {
        ptr = 0;
        try {
          buflen = in.read(buf);
        } catch (java.io.IOException e) {
          e.printStackTrace();
        }
        if (buflen <= 0) {
          return false;
        }
      }
      return true;
    }

    private int readByte() {
      if (hasNextByte()) {
        return buf[ptr++];
      } else {
        return -1;
      }
    }

    private boolean isPrintableChar(int c) {
      return 33 <= c && c <= 126;
    }

    private boolean isNumeric(int c) {
      return '0' <= c && c <= '9';
    }

    private void skipToNextPrintableChar() {
      while (hasNextByte() && !isPrintableChar(buf[ptr])) {
        ptr++;
      }
    }

    public boolean hasNext() {
      skipToNextPrintableChar();
      return hasNextByte();
    }

    public String next() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      StringBuilder ret = new StringBuilder();
      int b = readByte();
      while (isPrintableChar(b)) {
        ret.appendCodePoint(b);
        b = readByte();
      }
      return ret.toString();
    }

    public long nextLong() {
      if (!hasNext()) {
        throw new java.util.NoSuchElementException();
      }
      long ret = 0;
      int b = readByte();
      boolean negative = false;
      if (b == '-') {
        negative = true;
        if (hasNextByte()) {
          b = readByte();
        }
      }
      if (!isNumeric(b)) {
        throw new NumberFormatException();
      }
      while (true) {
        if (isNumeric(b)) {
          ret = ret * 10 + b - '0';
        } else if (b == -1 || !isPrintableChar(b)) {
          return negative ? -ret : ret;
        } else {
          throw new NumberFormatException();
        }
        b = readByte();
      }
    }

    public int nextInt() {
      return (int) nextLong();
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
