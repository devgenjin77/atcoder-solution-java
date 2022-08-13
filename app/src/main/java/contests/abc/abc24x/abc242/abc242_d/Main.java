/*
 * AtCoder Beginner Contest 242
 * D - ABC Transform
 * https://atcoder.jp/contests/abc242/tasks/abc242_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc242/submissions/33976454
 *
 * note:
 *
 */

package contests.abc.abc24x.abc242.abc242_d;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final String s = sc.next();
    final int q = sc.nextInt();
    final PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      long t = sc.nextLong();
      long k = sc.nextLong() - 1;
      pw.println("ABC".charAt(solve(s, t, k)));
    }
    pw.close();
    sc.close();
  }

  static int solve(String s, long t, long k) {
    if (t == 0) {
      return "ABC".indexOf(s.charAt((int) k));
    } else if (k == 0) {
      long ret = t + "ABC".indexOf(s.charAt(0));
      return (int) (ret % 3L);
    }
    int offset = k % 2 == 0 ? 1 : 2;
    int ret = solve(s, t - 1, k >> 1L) + offset;
    return ret % 3;
  }

  // FastScannerライブラリ
  static class FastScanner implements AutoCloseable {

    private final java.io.InputStream in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    public FastScanner(java.io.InputStream input) {
      this.in = input;
    }

    private boolean hasNextByte() {
      if (ptr < buflen) {
        return true;
      } else {
        ptr = 0;
        try {
          buflen = in.read(buffer);
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
