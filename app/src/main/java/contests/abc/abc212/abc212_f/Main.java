/*
 * ABC212
 * F - Greedy Takahashi
 * https://atcoder.jp/contests/abc212/tasks/abc212_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc212/submissions/30219114
 */

package contests.abc.abc212.abc212_f;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  static void solve(FastScanner sc, PrintWriter pw) throws Exception {
    int n = sc.nextInt();
    int m = sc.nextInt();
    int q = sc.nextInt();
    Bus[] arr_bus = new Bus[m];
    for (int i = 0; i < m; i++) {
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      int s = sc.nextInt();
      int t = sc.nextInt();
      arr_bus[i] = new Bus(i, a, b, s, t);
    }
    List<List<Bus>> lists_bus = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      lists_bus.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      lists_bus.get(arr_bus[i].a).add(arr_bus[i]);
    }
    for (int i = 0; i < n; i++) {
      Collections.sort(lists_bus.get(i));
    }
    //ダブリング
    int logM = Math.max(ceilPow2(m), 1);
    int[][] doubling = new int[logM][m];
    //前計算で、各バスについて、次に乗ることになるバスを計算する。
    for (int i = 0; i < m; i++) {
      List<Bus> list_b = lists_bus.get(arr_bus[i].b);
      int idx_next_bus = Collections.binarySearch(list_b, new Bus(-1, -1, -1, arr_bus[i].t, -1));
      idx_next_bus = idx_next_bus >= 0 ? idx_next_bus : ~idx_next_bus;
      if (idx_next_bus < list_b.size()) {
        doubling[0][i] = list_b.get(idx_next_bus).idx;
      } else {
        doubling[0][i] = arr_bus[i].idx;
      }
    }
    for (int k = 1; k < logM; k++) {
      for (int i = 0; i < m; i++) {
        doubling[k][i] = doubling[k - 1][doubling[k - 1][i]];
      }
    }
    for (int cnt = 1; cnt <= q; cnt++) {
      int x = sc.nextInt();
      int y = sc.nextInt() - 1;
      int z = sc.nextInt();
      int idx_first_bus = Collections.binarySearch(lists_bus.get(y), new Bus(-1, -1, -1, x, -1));
      idx_first_bus = idx_first_bus >= 0 ? idx_first_bus : ~idx_first_bus;
      if (idx_first_bus >= lists_bus.get(y).size() || lists_bus.get(y).get(idx_first_bus).s >= z) {
        //バスがないか、ちょうど発車する直前のため都市yのまま
        pw.println(y + 1);
      } else {
        int idx_bus = lists_bus.get(y).get(idx_first_bus).idx;
        for (int l = logM - 1; l >= 0; l--) {
          if (arr_bus[doubling[l][idx_bus]].s < z) {
            idx_bus = doubling[l][idx_bus];
          }
        }
        if (arr_bus[idx_bus].t < z) {
          pw.println(arr_bus[idx_bus].b + 1);
        } else {
          pw.println(String.format("%d %d", arr_bus[idx_bus].a + 1, arr_bus[idx_bus].b + 1));
        }
      }
    }
    pw.flush();
  }

  private static int ceilPow2(int n) {
    int x = 0;
    while ((1 << x) < n) {
      x++;
    }
    return x;
  }

  static class Bus implements Comparable<Bus> {

    int idx, a, b, s, t;

    Bus(int idx, int a, int b, int s, int t) {
      this.idx = idx;
      this.a = a;
      this.b = b;
      this.s = s;
      this.t = t;
    }

    @Override
    public int compareTo(Bus o) {
      return Integer.compare(s, o.s);
    }
  }

  public static void main(String[] args) {
    try (
        FastScanner sc = new FastScanner();
        PrintWriter pw = new PrintWriter(System.out)) {
      solve(sc, pw);
    } catch (Exception e) {
      e.printStackTrace();
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