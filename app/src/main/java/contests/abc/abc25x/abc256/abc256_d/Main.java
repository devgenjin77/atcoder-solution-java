/*
 * 東京海上日動プログラミングコンテスト2022
 * （AtCoder Beginner Contest 256）
 * D - Union of Interval
 * https://atcoder.jp/contests/abc256/tasks/abc256_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc256/submissions/38173253
 *
 */

package contests.abc.abc25x.abc256.abc256_d;

import java.io.PrintWriter;

public class Main {

  private static final int MAX = 200_000;

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int[] array_c = new int[MAX + 1];
    for (int i = 0; i < n; i++) {
      int l = sc.nextInt();
      int r = sc.nextInt();
      array_c[l] += 1;
      array_c[r] -= 1;
    }
    sc.close();
    final PrintWriter pw = new PrintWriter(System.out);
    int st = -1;
    for (int i = 1; i <= MAX; i++) {
      //いもす法
      array_c[i] = array_c[i - 1] + array_c[i];
      if (array_c[i] == 0 && array_c[i - 1] > 0) {
        pw.println(st + " " + i);
      } else if (array_c[i] > 0 && array_c[i - 1] == 0) {
        st = i;
      }
    }
    pw.close();
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
