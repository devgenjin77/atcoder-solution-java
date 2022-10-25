/*
 * 第三回日本最強プログラマー学生選手権-予選-
 * （AtCoder Beginner Contest 262）
 * B - Triangle (Easier)
 * https://atcoder.jp/contests/abc262/tasks/abc262_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc262/submissions/35963205
 *
 */

package contests.abc.abc26x.abc262.abc262_b;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int m = sc.nextInt();
    boolean[][] matrix_adj = new boolean[n][n];
    for (int i = 0; i < m; i++) {
      int u = sc.nextInt() - 1;
      int v = sc.nextInt() - 1;
      matrix_adj[u][v] = true;
      matrix_adj[v][u] = true;
    }
    sc.close();
    int ans = 0;
    for (int a = 0; a < n - 2; a++) {
      for (int b = a + 1; b < n - 1; b++) {
        for (int c = b + 1; c < n; c++) {
          if (matrix_adj[a][b] && matrix_adj[b][c] && matrix_adj[c][a]) {
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
