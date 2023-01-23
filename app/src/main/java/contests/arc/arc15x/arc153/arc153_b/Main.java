/*
 * AtCoder Regular Contest 153
 * B - Grid Rotations
 * https://atcoder.jp/contests/arc153/tasks/arc153_b
 *
 * verified:
 * - https://atcoder.jp/contests/arc153/submissions/38288706
 *
 * note:
 * ・縦軸と横軸の移動は独立で考えることができる。
 * ・操作後の並びは、以下のようにリバース後区切り位置まで右シフトした形となる。
 * 　0123|45678 -> 3210|87654
 * ・各クエリでは文字列の先頭が操作後どこにいくかを追いかける。
 * ・リバースしてるかどうかはクエリ回数で判別可能。
 *
 */

package contests.arc.arc15x.arc153.arc153_b;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int h = sc.nextInt();
    final int w = sc.nextInt();
    final String[] grid = new String[h];
    for (int i = 0; i < h; i++) {
      grid[i] = sc.next();
    }

    int pos0_h = 0, pos0_w = 0;
    final int q = sc.nextInt();
    for (int i = 0; i < q; i++) {
      int a = sc.nextInt();
      int b = sc.nextInt();
      pos0_h = (h - 1 - pos0_h + a) % h;
      pos0_w = (w - 1 - pos0_w + b) % w;
    }
    sc.close();
    final StringBuilder[] sb_grid = new StringBuilder[h];
    for (int i = 0; i < h; i++) {
      sb_grid[i] = new StringBuilder(grid[i]);
    }
    final int sgn = q % 2 == 0 ? 1 : -1;
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        int pos_h = (pos0_h + (i * sgn) + h) % h;
        int pos_w = (pos0_w + (j * sgn) + w) % w;
        sb_grid[pos_h].setCharAt(pos_w, grid[i].charAt(j));
      }
    }

    final PrintWriter pw = new PrintWriter(System.out);
    for (StringBuilder line : sb_grid) {
      pw.println(line);
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
