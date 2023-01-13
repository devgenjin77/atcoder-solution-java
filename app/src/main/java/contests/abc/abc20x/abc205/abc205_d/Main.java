/*
 * AtCoder Beginner Contest 205
 * D - Kth Excluded
 * https://atcoder.jp/contests/abc205/tasks/abc205_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc205/submissions/37983660
 *
 * note:
 *　二分探索
 *
 */

package contests.abc.abc20x.abc205.abc205_d;

import java.io.PrintWriter;

public class Main {

  private static final long MAX = Long.MAX_VALUE / 2;

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int q = sc.nextInt();
    final long[] array_a = new long[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = sc.nextLong();
    }
    final long[] array_c = new long[n];
    array_c[0] = array_a[0] - 1;
    for (int i = 1; i < n; i++) {
      array_c[i] = array_c[i - 1] + array_a[i] - array_a[i - 1] - 1;
    }
    final PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      long k = sc.nextLong();
      int ok = n, ng = -1;
      while (ok - ng > 1) {
        int mid = (ok + ng) / 2;
        if (array_c[mid] < k) {
          ng = mid;
        } else {
          ok = mid;
        }
      }
      if (ok == n) {
        pw.println(array_a[n - 1] + (k - array_c[n - 1]));
      } else {
        pw.println(array_a[ok] - (array_c[ok] - k + 1));
      }
    }
    pw.close();
    sc.close();
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
