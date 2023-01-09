/*
 * AtCoder Beginner Contest 211
 * D - Number of Shortest paths
 * https://atcoder.jp/contests/abc211/tasks/abc211_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc211/submissions/37909477
 *
 * note:
 *
 *
 */

package contests.abc.abc21x.abc211.abc211_d;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {

  private static final long MOD = 1_000_000_007;

  private static final int INF = Integer.MAX_VALUE / 2;

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int m = sc.nextInt();
    final List<List<Integer>> list_adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list_adj.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      list_adj.get(a).add(b);
      list_adj.get(b).add(a);
    }
    sc.close();
    final int[] dist = new int[n];
    final long[] patterns = new long[n];
    Arrays.fill(dist, INF);
    dist[0] = 0;
    patterns[0] = 1;
    //辺の重みが一定なので、ダイクストラでなく、普通のBFSで解くしなくてよい
    final Queue<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    while (!queue.isEmpty()) {
      int cur = queue.poll();
      for (int next : list_adj.get(cur)) {
        if (dist[next] > dist[cur] + 1) {
          dist[next] = dist[cur] + 1;
          patterns[next] = patterns[cur];
          queue.add(next);
        } else if (dist[next] == dist[cur] + 1) {
          patterns[next] += patterns[cur];
          patterns[next] %= MOD;
        }
      }
    }
    System.out.println(patterns[n - 1]);
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
