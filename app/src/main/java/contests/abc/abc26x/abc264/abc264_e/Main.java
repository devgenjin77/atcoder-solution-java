/*
 * freee プログラミングコンテスト2022
 * （AtCoder Beginner Contest 264）
 * E - Blackout 2
 * https://atcoder.jp/contests/abc264/tasks/abc264_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc264/submissions/35926198
 *
 * note:
 *
 *
 */

package contests.abc.abc26x.abc264.abc264_e;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int m = sc.nextInt();
    final int e = sc.nextInt();
    final int[] array_u = new int[e];
    final int[] array_v = new int[e];
    for (int i = 0; i < e; i++) {
      //n以上となる発電所を同一視する
      array_u[i] = Math.min(sc.nextInt() - 1, n);
      array_v[i] = Math.min(sc.nextInt() - 1, n);
    }
    final int q = sc.nextInt();
    final int[] array_x = new int[q];
    final boolean[] in_query = new boolean[e];
    for (int i = 0; i < q; i++) {
      array_x[i] = sc.nextInt() - 1;
      in_query[array_x[i]] = true;
    }
    sc.close();
    final DisjointSetUnion dsu = new DisjointSetUnion(n + 1);
    for (int i = 0; i < e; i++) {
      if (!in_query[i]) {
        dsu.merge(array_u[i], array_v[i]);
      }
    }
    int[] ans_query = new int[q];
    for (int i = q - 1; i >= 0; i--) {
      ans_query[i] = dsu.size(n) - 1;
      int x = array_x[i];
      dsu.merge(array_u[x], array_v[x]);
    }
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      pw.println(ans_query[i]);
    }
    pw.close();
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
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    public FastScanner(java.io.InputStream input) {
      this.in = input;
    }

    private boolean hasNextByte() {
      if (ptr < buflen) {
        return true;
      } else {
        ptr = 0;
        try {
          buflen = in.read(buffer);
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
        throw new java.util.NoSuchElementException();
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
        throw new java.util.NoSuchElementException();
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

    @Override
    public void close() throws Exception {
      in.close();
    }
  }
}
