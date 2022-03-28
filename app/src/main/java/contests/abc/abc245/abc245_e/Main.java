/*
 * ABC245
 * E - Wrapping Chocolate
 * https://atcoder.jp/contests/abc245/tasks/abc245_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc245/submissions/30535223
 *
 */

package contests.abc.abc245.abc245_e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class Main {

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    int n = fs.nextInt();
    int m = fs.nextInt();
    int[] array_a = new int[n];
    int[] array_b = new int[n];
    int[] array_c = new int[m];
    int[] array_d = new int[m];
    for (int i = 0; i < n; i++) {
      array_a[i] = fs.nextInt();
    }
    for (int i = 0; i < n; i++) {
      array_b[i] = fs.nextInt();
    }
    for (int i = 0; i < m; i++) {
      array_c[i] = fs.nextInt();
    }
    for (int i = 0; i < m; i++) {
      array_d[i] = fs.nextInt();
    }
    fs.close();

    List<IntPair> list_choco = new ArrayList<>();
    List<IntPair> list_box = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list_choco.add(new IntPair(array_a[i], array_b[i]));
    }
    for (int i = 0; i < m; i++) {
      list_box.add(new IntPair(array_c[i], array_d[i]));
    }
    Collections.sort(list_choco);
    Collections.sort(list_box);
    boolean isOk = true;
    TreeMap<Integer, Integer> stock_box_len = new TreeMap<>();
    int idx_choco = n - 1;
    int idx_box = m - 1;
    while (idx_choco >= 0) {
      int width_choco = list_choco.get(idx_choco).first;
      while (idx_box >= 0 && list_box.get(idx_box).first >= width_choco) {
        int len_box = list_box.get(idx_box).second;
        stock_box_len.put(len_box, stock_box_len.getOrDefault(len_box, 0) + 1);
        idx_box--;
      }
      Integer k = stock_box_len.ceilingKey(list_choco.get(idx_choco).second);
      if (k == null) {
        isOk = false;
        break;
      } else {
        int stock = stock_box_len.get(k);
        if (stock > 1) {
          stock_box_len.put(k, stock - 1);
        } else {
          stock_box_len.remove(k);
        }
      }
      idx_choco--;
    }
    System.out.println(isOk ? "Yes" : "No");
  }

  static class IntPair implements Comparable<IntPair> {

    int first, second;

    IntPair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public int compareTo(IntPair o) {
      if (first != o.first) {
        return Integer.compare(first, o.first);
      }
      return Integer.compare(second, o.second);
    }
  }

  //FastScanner ライブラリ
  static class FastScanner implements AutoCloseable {

    private final java.io.InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buf_len = 0;

    private boolean hasNextByte() {
      if (ptr < buf_len) {
        return true;
      } else {
        ptr = 0;
        try {
          buf_len = in.read(buffer);
        } catch (java.io.IOException e) {
          e.printStackTrace();
        }
        if (buf_len <= 0) {
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
