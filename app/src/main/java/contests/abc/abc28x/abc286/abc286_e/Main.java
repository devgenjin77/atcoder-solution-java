/*
 * ウルシステムズプログラミングコンテスト2023
 * （AtCoder Beginner Contest 286）
 * E - Souvenir
 * https://atcoder.jp/contests/abc286/tasks/abc286_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc286/submissions/38239513
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc286.abc286_e;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final long[] array_a = new long[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = sc.nextLong();
    }
    final String[] mtx_yn = new String[n];
    for (int i = 0; i < n; i++) {
      mtx_yn[i] = sc.next();
    }
    final int[][] dist = new int[n][n];
    final long[][] cost = new long[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dist[i][j] = mtx_yn[i].charAt(j) == 'Y' ? 1 : n;
        cost[i][j] = dist[i][j] == 1 ? array_a[j] : 0;
      }
    }
    // ワーシャル–フロイド法
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          //ここを改造
          //dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
          if (dist[i][k] + dist[k][j] == dist[i][j]) {
            cost[i][j] = Math.max(cost[i][k] + cost[k][j], cost[i][j]);
          } else if (dist[i][k] + dist[k][j] < dist[i][j]) {
            dist[i][j] = dist[i][k] + dist[k][j];
            cost[i][j] = cost[i][k] + cost[k][j];
          }
        }
      }
    }
    final int q = sc.nextInt();
    final PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      int u = sc.nextInt() - 1;
      int v = sc.nextInt() - 1;
      if (dist[u][v] >= n) {
        pw.println("Impossible");
      } else {
        pw.println(dist[u][v] + " " + (array_a[u] + cost[u][v]));
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
