/*
 * AtCoder Beginner Contest 261
 * E - Many Operations
 * https://atcoder.jp/contests/abc261/tasks/abc261_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc261/submissions/37641666
 *
 * note:
 *
 *
 */

package contests.abc.abc26x.abc261.abc261_e;

import java.io.PrintWriter;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int c = sc.nextInt();
    final int[][] sum_op = new int[2][30];
    Arrays.fill(sum_op[1], 1);
    final PrintWriter pw = new PrintWriter(System.out);
    int prev = c;
    for (int i = 0; i < n; i++) {
      int t = sc.nextInt();
      int a = sc.nextInt();
      int ans = 0;
      for (int j = 0; j < 30; j++) {
        int bit_a = (a >> j) & 1;
        int bit_prev = (prev >> j) & 1;
        if (t == 1) {
          sum_op[0][j] &= bit_a;
          sum_op[1][j] &= bit_a;
        } else if (t == 2) {
          sum_op[0][j] |= bit_a;
          sum_op[1][j] |= bit_a;
        } else if (t == 3) {
          sum_op[0][j] ^= bit_a;
          sum_op[1][j] ^= bit_a;
        }
        ans += sum_op[bit_prev][j] << j;
      }
      pw.println(ans);
      prev = ans;
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
