/*
 * AtCoder Beginner Contest 242
 * E - (∀x∀)
 * https://atcoder.jp/contests/abc242/tasks/abc242_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc242/submissions/33978069
 *
 * note:
 *
 */


package contests.abc.abc24x.abc242.abc242_e;

import java.io.PrintWriter;

public class Main {

  static final long MOD = 998244353L;

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int t = sc.nextInt();
    final PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < t; i++) {
      int n = sc.nextInt();
      String s = sc.next();
      pw.println(solve(n, s));
    }
    pw.close();
    sc.close();
  }

  static long solve(int n, String s) {
    long ans = 0;
    int half_n = (n + 1) / 2;
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0; i < half_n; i++) {
      char c = s.charAt(i);
      sb.setCharAt(n - 1 - i, c);
      long sub = pow(26, half_n - 1 - i, MOD) * (c - 'A');
      ans += sub;
      ans %= MOD;
    }
    if (s.compareTo(sb.toString()) >= 0) {
      ans++;
      ans = (ans + MOD) % MOD;
    }
    return ans;
  }

  static long pow(long x, long n, long mod) {
    long answer = 1l;
    while (n > 0) {
      if ((n & 1) == 1) {
        answer = answer * x % mod;
      }
      x = x * x % mod;
      n >>= 1;
    }
    return answer;
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
