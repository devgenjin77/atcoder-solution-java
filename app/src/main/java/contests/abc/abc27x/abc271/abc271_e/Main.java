/*
 * 京セラプログラミングコンテスト2022
 * （AtCoder Beginner Contest 271）
 * E - Subsequence Path
 * https://atcoder.jp/contests/abc271/tasks/abc271_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc271/submissions/35856195
 *
 */

package contests.abc.abc27x.abc271.abc271_e;

import java.util.Arrays;

public class Main {

  private static final long INF = Long.MAX_VALUE / 2;

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int m = sc.nextInt();
    final int k = sc.nextInt();
    final int[] array_a = new int[m];
    final int[] array_b = new int[m];
    final long[] array_c = new long[m];
    for (int i = 0; i < m; i++) {
      array_a[i] = sc.nextInt() - 1;
      array_b[i] = sc.nextInt() - 1;
      array_c[i] = sc.nextLong();
    }
    final int[] array_e = new int[k];
    for (int i = 0; i < k; i++) {
      array_e[i] = sc.nextInt() - 1;
    }
    sc.close();
    final long[] costs = new long[n];
    Arrays.fill(costs, INF);
    costs[0] = 0;
    for (int i = 0; i < k; i++) {
      int a = array_a[array_e[i]];
      int b = array_b[array_e[i]];
      long c = array_c[array_e[i]];
      if (costs[a] == INF) {
        continue;
      }
      if (costs[b] > costs[a] + c) {
        costs[b] = costs[a] + c;
      }
    }
    System.out.println(costs[n - 1] == INF ? -1 : costs[n - 1]);
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
