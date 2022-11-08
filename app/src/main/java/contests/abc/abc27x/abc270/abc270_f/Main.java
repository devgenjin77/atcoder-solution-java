/*
 * トヨタ自動車プログラミングコンテスト2022
 * （AtCoder Beginner Contest 270）
 * F - Transportation
 * https://atcoder.jp/contests/abc270/tasks/abc270_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc270/submissions/36329708
 *
 */

package contests.abc.abc27x.abc270.abc270_f;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int m = sc.nextInt();
    final ArrayList<CostedEdge> edge_list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      long x = sc.nextLong();
      edge_list.add(new CostedEdge(i, n, x));
    }
    for (int i = 0; i < n; i++) {
      long y = sc.nextLong();
      edge_list.add(new CostedEdge(i, n + 1, y));
    }
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      long z = sc.nextLong();
      edge_list.add(new CostedEdge(a, b, z));
    }
    sc.close();
    Collections.sort(edge_list);

    final boolean[] cond_airport = {false, true, false, true};
    final boolean[] cond_harbor = {false, false, true, true};
    long ans = Long.MAX_VALUE;
    for (int i = 0; i < 4; i++) {
      boolean use_airport = cond_airport[i];
      boolean use_harbor = cond_harbor[i];
      if (!use_airport && !use_harbor && n > m + 1) {
        //道路だけでは全部の街が連結にならない簡易版チェック
        continue;
      }
      int cnt_node = n;
      if (use_airport) {
        cnt_node++;
      }
      if (use_harbor) {
        cnt_node++;
      }
      DisjointSetUnion dsu = new DisjointSetUnion(cnt_node);
      long cost = 0;
      for (CostedEdge edge : edge_list) {
        int u = edge.u;
        int v = edge.v;
        if (!use_airport && v == n) {
          continue;
        }
        if (!use_harbor && v == n + 1) {
          continue;
        }
        if (!use_airport && use_harbor && v == n + 1) {
          v = n;
        }
        if (!dsu.isSame(u, v)) {
          dsu.merge(u, v);
          cost += edge.cost;
        }
      }
      if (use_airport || use_harbor || dsu.size(0) == cnt_node) {
        ans = Math.min(cost, ans);
      }
    }
    System.out.println(ans);
  }

  static class CostedEdge implements Comparable<CostedEdge> {

    int u, v;
    long cost;

    public CostedEdge(int u, int v, long cost) {
      this.u = u;
      this.v = v;
      this.cost = cost;
    }

    @Override
    public int compareTo(CostedEdge o) {
      if (this.cost != o.cost) {
        return Long.compare(this.cost, o.cost);
      } else if (this.u != o.u) {
        return Integer.compare(this.u, o.u);
      } else {
        return Integer.compare(this.v, o.v);
      }
    }
  }

  //DisjointSetUnionライブラリ
  static class DisjointSetUnion {

    private final int n;
    private final int[] parent_or_size;

    public DisjointSetUnion(int n) {
      this.n = n;
      parent_or_size = new int[n];
      java.util.Arrays.fill(parent_or_size, -1);
    }

    public int merge(int a, int b) {
      if (!(0 <= a && a < n) || !(0 <= b && b < n)) {
        return -1;
      }
      int x = leader(a);
      int y = leader(b);
      if (x == y) {
        return x;
      }
      if (-parent_or_size[x] < -parent_or_size[y]) {
        int temp = x;
        x = y;
        y = temp;
      }
      parent_or_size[x] += parent_or_size[y];
      parent_or_size[y] = x;
      return x;
    }

    public boolean isSame(int a, int b) {
      if (!(0 <= a && a < n) || !(0 <= b && b < n)) {
        return false;
      }
      return leader(a) == leader(b);
    }

    public int leader(int a) {
      if (parent_or_size[a] < 0) {
        return a;
      } else {
        parent_or_size[a] = leader(parent_or_size[a]);
        return parent_or_size[a];
      }
    }

    public int size(int a) {
      if (!(0 <= a && a < n)) {
        return -1;
      }
      return -parent_or_size[leader(a)];
    }

    public java.util.List<java.util.List<Integer>> groups() {
      int m = 0;
      java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
      java.util.Map<Integer, Integer> map_leader = new java.util.HashMap<>();
      for (int i = 0; i < n; i++) {
        int lead = leader(i);
        if (!map_leader.containsKey(lead)) {
          map_leader.put(lead, m++);
          result.add(new java.util.ArrayList<>());
        }
        result.get(map_leader.get(lead)).add(i);
      }
      return result;
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
