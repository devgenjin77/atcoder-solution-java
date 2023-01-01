/*
 * AtCoder Beginner Contest 207
 * C - Many Segments
 * https://atcoder.jp/contests/abc207/tasks/abc207_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc207/submissions/37671879
 *
 * note:
 *
 *
 */

package contests.abc.abc20x.abc207.abc207_c;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int[] array_t = new int[n];
    final int[] array_l = new int[n];
    final int[] array_r = new int[n];
    for (int i = 0; i < n; i++) {
      array_t[i] = sc.nextInt();
      array_l[i] = sc.nextInt();
      array_r[i] = sc.nextInt();
    }
    sc.close();
    int ans = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if (array_r[i] == array_l[j]) {
          if ((array_t[i] == 1 || array_t[i] == 3) && (array_t[j] == 1 || array_t[j] == 2)) {
            ans++;
          }
        } else if (array_r[j] == array_l[i]) {
          if ((array_t[j] == 1 || array_t[j] == 3) && (array_t[i] == 1 || array_t[i] == 2)) {
            ans++;
          }
        } else {
          int max_l = Math.max(array_l[i], array_l[j]);
          int min_r = Math.min(array_r[i], array_r[j]);
          if (min_r > max_l) {
            ans++;
          }
        }
      }
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
