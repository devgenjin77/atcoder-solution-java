/*
 * AtCoder Beginner Contest 250
 * E - Prefix Equality
 * https://atcoder.jp/contests/abc250/tasks/abc250_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc250/submissions/35267102
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc250.abc250_e;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int[] array_a = new int[n];
    final int[] array_b = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = sc.nextInt();
    }
    for (int i = 0; i < n; i++) {
      array_b[i] = sc.nextInt();
    }
    final Set<Integer> set_a = new HashSet<>();
    final Set<Integer> set_b = new HashSet<>();
    //i時点で集合S_a,S_bが何個の要素を持つのか
    final int[] cnt_set_a = new int[n];
    final int[] cnt_set_b = new int[n];
    //集合S_a,S_bにはいる新たな要素
    final List<Integer> list_a = new ArrayList<>();
    final List<Integer> list_b = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (!set_a.contains(array_a[i])) {
        set_a.add(array_a[i]);
        list_a.add(array_a[i]);
      }
      if (!set_b.contains(array_b[i])) {
        set_b.add(array_b[i]);
        list_b.add(array_b[i]);
      }
      cnt_set_a[i] = set_a.size();
      cnt_set_b[i] = set_b.size();
    }
    final Set<Integer> set_ab = new HashSet<>();
    //集合S_a,S_bがiこの要素のとき、集合として同一か見る
    final boolean[] is_same_at_len = new boolean[Math.max(set_a.size(), set_b.size())];
    for (int i = 0; i < Math.min(list_a.size(), list_b.size()); i++) {
      Integer add_a = list_a.get(i);
      Integer add_b = list_b.get(i);
      if (set_ab.contains(add_a)) {
        set_ab.remove(add_a);
      } else {
        set_ab.add(add_a);
      }

      if (set_ab.contains(add_b)) {
        set_ab.remove(add_b);
      } else {
        set_ab.add(add_b);
      }
      if (set_ab.size() == 0) {
        is_same_at_len[i] = true;
      }
    }
    int q = sc.nextInt();
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      int x = sc.nextInt() - 1;
      int y = sc.nextInt() - 1;
      if (cnt_set_a[x] == cnt_set_b[y] && is_same_at_len[cnt_set_a[x] - 1]) {
        pw.println("Yes");
      } else {
        pw.println("No");
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
