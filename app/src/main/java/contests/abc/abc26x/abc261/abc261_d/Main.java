/*
 * AtCoder Beginner Contest 261
 * D - Flipping and Bonus
 * https://atcoder.jp/contests/abc261/tasks/abc261_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc261/submissions/37641201
 *
 * note:
 *
 *
 */

package contests.abc.abc26x.abc261.abc261_d;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int m = sc.nextInt();
    final long[] array_x = new long[n];
    for (int i = 0; i < n; i++) {
      array_x[i] = sc.nextLong();
    }
    final long[] array_cy = new long[n + 1];
    for (int i = 0; i < m; i++) {
      int c = sc.nextInt();
      array_cy[c] = sc.nextLong();
    }
    sc.close();
    final long[] dp_now = new long[n + 1];
    final long[] dp_old = new long[n + 1];
    long max = 0;
    for (int cnt = 1; cnt <= n; cnt++) {
      dp_now[0] = max;
      for (int j = 1; j <= cnt; j++) {
        dp_now[j] = dp_old[j - 1] + array_x[cnt - 1] + array_cy[j];
        max = Math.max(dp_now[j], max);
      }
      System.arraycopy(dp_now, 0, dp_old, 0, n + 1);
    }
    System.out.println(max);
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
