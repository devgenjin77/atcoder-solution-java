/*
 * AtCoder Beginner Contest 259
 * D - Circumferences
 * https://atcoder.jp/contests/abc259/tasks/abc259_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc259/submissions/37621863
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc259.abc259_d;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int sx = sc.nextInt();
    final int sy = sc.nextInt();
    final int tx = sc.nextInt();
    final int ty = sc.nextInt();
    final int[] array_x = new int[n + 2];
    final int[] array_y = new int[n + 2];
    final long[] array_r = new long[n + 2];
    for (int i = 0; i < n; i++) {
      array_x[i] = sc.nextInt();
      array_y[i] = sc.nextInt();
      array_r[i] = sc.nextLong();
    }
    sc.close();
    array_x[n] = sx;
    array_y[n] = sy;
    array_x[n + 1] = tx;
    array_y[n + 1] = ty;
    DisjointSetUnion dsu = new DisjointSetUnion(n + 2);
    for (int i = 0; i < n + 1; i++) {
      for (int j = i + 1; j < n + 2; j++) {
        long dist = dist2(array_x[i], array_y[i], array_x[j], array_y[j]);
        if (!(dist > (array_r[i] + array_r[j]) * (array_r[i] + array_r[j])
            || dist < (array_r[i] - array_r[j]) * (array_r[i] - array_r[j]))) {
          dsu.merge(i, j);
        }
      }
    }
    System.out.println(dsu.isSame(n, n + 1) ? "Yes" : "No");
  }

  static long dist2(int x1, int y1, int x2, int y2) {
    long dx = Math.abs(x1 - x2);
    long dy = Math.abs(y1 - y2);
    return (dx * dx) + (dy * dy);
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
