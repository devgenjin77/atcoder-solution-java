/*
 * トヨタ自動車プログラミングコンテスト2022
 * （AtCoder Beginner Contest 270）
 * C - Simple path
 * https://atcoder.jp/contests/abc270/tasks/abc270_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc270/submissions/36200760
 *
 */

package contests.abc.abc27x.abc270.abc270_c;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int x = sc.nextInt() - 1;
    final int y = sc.nextInt() - 1;
    final TreeGraph g = new TreeGraph(n);
    for (int i = 0; i < n - 1; i++) {
      int u = sc.nextInt() - 1;
      int v = sc.nextInt() - 1;
      g.addEdge(u, v);
    }
    sc.close();
    List<Integer> path = g.solve(x, y);
    final StringBuilder sb = new StringBuilder();
    for (int v : path) {
      sb.append(v + 1).append(' ');
    }
    System.out.println(sb.deleteCharAt(sb.length() - 1));
  }

  static class TreeGraph {

    private final int n;
    private final List<List<Integer>> list_adj;

    public TreeGraph(int n) {
      this.n = n;
      this.list_adj = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        this.list_adj.add(new ArrayList<>());
      }
    }

    public void addEdge(int u, int v) {
      this.list_adj.get(u).add(v);
      this.list_adj.get(v).add(u);
    }

    public List<Integer> solve(int x, int y) {
      LinkedList<Integer> ret = new LinkedList<>();
      dfs(x, -1, y, ret);
      return ret;
    }

    private boolean dfs(int v, int p, int t, LinkedList<Integer> path) {
      path.addLast(v);
      if (v == t) {
        return true;
      }
      for (int to : list_adj.get(v)) {
        if (to == p) {
          continue;
        }
        if (dfs(to, v, t, path)) {
          return true;
        } else {
          path.removeLast();
        }
      }
      return false;
    }
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
