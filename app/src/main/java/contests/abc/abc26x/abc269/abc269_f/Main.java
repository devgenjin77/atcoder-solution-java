/*
 * UNICORNプログラミングコンテスト2022
 * （AtCoder Beginner Contest 269）
 * F - Numbered Checker
 * https://atcoder.jp/contests/abc269/tasks/abc269_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc269/submissions/36002829
 *
 */

package contests.abc.abc26x.abc269.abc269_f;

import java.io.PrintWriter;

public class Main {

  private static final long MOD = 998244353L;

  private static final long INV2 = (MOD + 1) / 2;

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final long n = sc.nextLong();
    final long m = sc.nextLong();
    final int q = sc.nextInt();
    final PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      long a = sc.nextLong();
      long b = sc.nextLong();
      long c = sc.nextLong();
      long d = sc.nextLong();
      long tmp_h = b - a + 1;
      long tmp_w = d - c + 1;
      long a1 = ((a - 1) * m) + c;
      long n1 = (tmp_w + 1) / 2;
      if ((a + c) % 2 == 1) {
        if (tmp_w == 1) {
          a1 = 0;
          n1 = 0;
        } else {
          a1++;
          n1 = tmp_w / 2;
        }
      }
      long sum1 = a1 != 0 ? sumOfAP(sumOfAP(a1, 2, n1), m * n1 * 2, (tmp_h + 1) / 2) : 0;
      if (tmp_h > 1) {
        long a2 = (a * m) + c;
        long n2 = (tmp_w + 1) / 2;
        if ((a + 1 + c) % 2 == 1) {
          if (tmp_w == 1) {
            a2 = 0;
            n2 = 0;
          } else {
            a2++;
            n2 = tmp_w / 2;
          }
        }
        long sum2 = a2 != 0 ? sumOfAP(sumOfAP(a2, 2, n2), m * n2 * 2, tmp_h / 2) : 0;
        sum1 += sum2;
      }
      pw.println(sum1 % MOD);
    }
    pw.close();
    sc.close();
  }

  static long sumOfAP(long a, long d, long n) {
    a %= MOD;
    d %= MOD;
    n %= MOD;
    long x1 = (a * n) % MOD;
    long x2 = (((n - 1) * n % MOD) * d) % MOD;
    x2 *= INV2;
    x2 %= MOD;
    return (x1 + x2) % MOD;
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
