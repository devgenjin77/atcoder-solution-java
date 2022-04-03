/*
 * ABC246
 * C - Coupon
 * https://atcoder.jp/contests/abc246/tasks/abc246_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc246/submissions/30697061
 *
 */

package contests.abc.abc246.abc246_c;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner();
    int n = fs.nextInt();
    long k = fs.nextLong();
    long x = fs.nextLong();

    long sum = 0, coupon_use = 0;
    long[] remain_x = new long[n];

    for (int i = 0; i < n; i++) {
      long a = fs.nextLong();
      sum += a;
      coupon_use += a / x;
      remain_x[i] = a % x;
    }
    fs.close();
    long discount = Math.min(coupon_use, k) * x;
    if (k > coupon_use) {
      int remain = (int) (k - coupon_use);
      Arrays.sort(remain_x);
      for (int i = Math.max(n - remain, 0); i < n; i++) {
        discount += remain_x[i];
      }
    }
    System.out.println(sum - discount);
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
