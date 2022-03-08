/*
 * ABC242
 * D - ABC Transform
 * https://atcoder.jp/contests/abc242/tasks/abc242_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc242/submissions/29960654
 *
 */
package contests.abc.abc242.abc242_d;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {

  public static void main(String[] args) throws IOException {
    FastScanner sc = new FastScanner();
    String s = sc.next();
    int q = sc.nextInt();
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      long t = sc.nextLong();
      long k = sc.nextLong();
      pw.println(solve(s, t, k - 1));
    }
    pw.close();
    sc.close();
  }

  static char solve(String s, long t, long k) {
    long tmp_k = k;
    long tmp_t = t;
    long offset = 0;
    while (tmp_t > 0 && tmp_k > 0) {
      if ((tmp_k & 1l) == 1) {
        offset += 2;
      } else {
        offset += 1;
      }
      tmp_k >>= 1;
      tmp_t--;
    }
    int d = (int) (offset) % 3;
    if (tmp_t > 0) {
      d += (tmp_t % 3) + (s.charAt(0) - 'A');
    } else {
      d += s.charAt((int) tmp_k) - 'A';
    }
    return "ABC".charAt(d % 3);
  }

  // ライブラリ
  static class FastScanner {

    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    private boolean hasNextByte() {
      if (ptr < buflen) {
        return true;
      } else {
        ptr = 0;
        try {
          buflen = in.read(buffer);
        } catch (IOException e) {
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
        throw new NoSuchElementException();
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
        throw new NoSuchElementException();
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

    public void close() throws IOException {
      in.close();
    }
  }
}
