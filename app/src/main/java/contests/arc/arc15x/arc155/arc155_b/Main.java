/*
 * AtCoder Regular Contest 155
 * B - Abs Abs Function
 * https://atcoder.jp/contests/arc155/tasks/arc155_b
 *
 * verified:
 * - https://atcoder.jp/contests/arc155/submissions/38530613
 *
 * note:
 * |x - a| - b = 0 -> x = a + b or a - b
 * クエリ２では、上記xの値を取りうるのであれば０。
 * 取れない場合、上記の値にもっとも近い値との差分が答えとなる。
 *
 */

package contests.arc.arc15x.arc155.arc155_b;

import java.io.PrintWriter;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int q = sc.nextInt();
    final int a = sc.nextInt();
    final int b = sc.nextInt();
    final TreeSet<Integer> tset_i = new TreeSet<>();
    tset_i.add(a + b);
    tset_i.add(a - b);
    final PrintWriter pw = new PrintWriter(System.out);
    for (int cnt = 0; cnt < q; cnt++) {
      int t = sc.nextInt();
      int _a = sc.nextInt();
      int _b = sc.nextInt();
      if (t == 1) {
        tset_i.add(_a + _b);
        tset_i.add(_a - _b);
      } else if (t == 2) {
        int ans = Integer.MAX_VALUE;
        if (tset_i.contains(_a) || tset_i.contains(_b)) {
          ans = 0;
        } else {
          Integer high_a = tset_i.higher(_a);
          if (high_a != null && high_a < _b) {
            ans = 0;
          } else {
            Integer l_a = tset_i.lower(_a);
            if (l_a != null) {
              ans = Math.min(Math.abs(l_a - _a), ans);
            }
            Integer h_b = tset_i.higher(_b);
            if (h_b != null) {
              ans = Math.min(Math.abs(h_b - _b), ans);
            }
          }
        }
        pw.println(ans);
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
