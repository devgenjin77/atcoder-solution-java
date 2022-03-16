/*
 * ABC212
 * D - Querying Multiset
 * https://atcoder.jp/contests/abc212/tasks/abc212_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc212/submissions/30172824
 */
package contests.abc.abc212.abc212_d;

import java.io.PrintWriter;
import java.util.PriorityQueue;

public class Main {

  static void solve(FastScanner sc, PrintWriter pw) throws Exception {
    int q = sc.nextInt();
    PriorityQueue<Long> queue = new PriorityQueue<>();
    long sum = 0;
    for (int i = 0; i < q; i++) {
      int type = sc.nextInt();
      switch (type) {
        case 1:
          queue.add(sc.nextLong() - sum);
          break;
        case 2:
          sum += sc.nextLong();
          break;
        case 3:
          pw.println(queue.poll() + sum);
          break;
        default:
          break;
      }
    }
    pw.flush();
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