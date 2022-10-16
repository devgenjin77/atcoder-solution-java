/*
 * パナソニックグループプログラミングコンテスト2022
 * （AtCoder Beginner Contest 273）
 * D - LRUD Instructions
 * https://atcoder.jp/contests/abc273/tasks/abc273_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc273/submissions/35713646
 *
 */

package contests.abc.abc27x.abc273.abc273_d;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int h = sc.nextInt();
    final int w = sc.nextInt();
    final int rs = sc.nextInt();
    final int cs = sc.nextInt();
    final Map<Integer, TreeSet<Integer>> h_map = new HashMap<>();
    final Map<Integer, TreeSet<Integer>> w_map = new HashMap<>();
    final int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      int r = sc.nextInt();
      int c = sc.nextInt();
      TreeSet<Integer> w_set = h_map.get(r);
      if (w_set == null) {
        w_set = new TreeSet<>();
        h_map.put(r, w_set);
      }
      w_set.add(c);

      TreeSet<Integer> h_set = w_map.get(c);
      if (h_set == null) {
        h_set = new TreeSet<>();
        w_map.put(c, h_set);
      }
      h_set.add(r);
    }
    final PrintWriter pw = new PrintWriter(System.out);
    final int q = sc.nextInt();
    int pos_r = rs, pos_c = cs;
    for (int i = 0; i < q; i++) {
      char c = sc.next().charAt(0);
      int l = sc.nextInt();
      TreeSet<Integer> set = null;
      if (c == 'L') {
        int min_l = 1;
        set = h_map.get(pos_r);
        if (set != null) {
          Integer w_l = set.lower(pos_c);
          min_l = w_l == null ? 1 : w_l.intValue() + 1;
        }
        pos_c = Math.max(pos_c - l, min_l);
      } else if (c == 'R') {
        int max_r = w;
        set = h_map.get(pos_r);
        if (set != null) {
          Integer w_r = set.higher(pos_c);
          max_r = w_r == null ? w : w_r.intValue() - 1;
        }
        pos_c = Math.min(pos_c + l, max_r);
      } else if (c == 'U') {
        int min_u = 1;
        set = w_map.get(pos_c);
        if (set != null) {
          Integer w_u = set.lower(pos_r);
          min_u = w_u == null ? 1 : w_u.intValue() + 1;
        }
        pos_r = Math.max(pos_r - l, min_u);
      } else if (c == 'D') {
        int max_d = h;
        set = w_map.get(pos_c);
        if (set != null) {
          Integer w_d = set.higher(pos_r);
          max_d = w_d == null ? h : w_d.intValue() - 1;
        }
        pos_r = Math.min(pos_r + l, max_d);
      }
      pw.println(pos_r + " " + pos_c);
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
