/*
 * ABC243
 * E - Edge Deletion
 * https://atcoder.jp/contests/abc243/tasks/abc243_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc243/submissions/30111686
 *
 */
package contests.abc.abc243.abc243_e;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Main {

  static final long INF = 1L << 60;

  public static void main(String[] args) throws IOException {
    FastScanner sc = new FastScanner();
    int n = sc.nextInt();
    int m = sc.nextInt();
    long[][] dist = new long[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], INF);
    }
    for (int i = 0; i < n; i++) {
      dist[i][i] = 0;
    }
    Edge[] arr_edge = new Edge[m];
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      long c = sc.nextLong();
      arr_edge[i] = new Edge(a, b, c);
      dist[a][b] = c;
      dist[b][a] = c;
    }
    sc.close();

    //ワーシャルフロイド法
    for (int mid = 0; mid < n; mid++) {
      for (int frm = 0; frm < n; frm++) {
        for (int to = 0; to < n; to++) {
          dist[frm][to] = Math.min(dist[frm][mid] + dist[mid][to], dist[frm][to]);
        }
      }
    }
    int cnt = 0;
    for (int i = 0; i < m; i++) {
      Edge edge = arr_edge[i];
      for (int mid = 0; mid < n; mid++) {
        if (mid == edge.from || mid == edge.to) {
          continue;
        }
        if (dist[edge.from][mid] + dist[mid][edge.to] <= edge.cost) {
          cnt++;
          break;
        }
      }
    }
    System.out.println(cnt);
  }

  static class Edge {

    int from, to;
    long cost;

    Edge(int from, int to, long cost) {
      this.from = from;
      this.to = to;
      this.cost = cost;
    }
  }

  // ライブラリ
  static class FastScanner {

    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    private boolean hasNextByte() {
      if (ptr < buflen) {
        return true;
      } else {
        ptr = 0;
        try {
          buflen = in.read(buffer);
        } catch (IOException e) {
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
        throw new NoSuchElementException();
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
        throw new NoSuchElementException();
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

    public void close() throws IOException {
      in.close();
    }
  }
}
