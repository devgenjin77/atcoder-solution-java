/*
 * AtCoder Library Practice Contest
 * C - Floor Sum
 * https://atcoder.jp/contests/practice2/tasks/practice2_c
 *
 * verified:
 * - https://atcoder.jp/contests/practice2/submissions/38322835
 *
 */

package contests.practice2.practice2_c;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int t = sc.nextInt();
    final PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < t; i++) {
      long n = sc.nextLong();
      long m = sc.nextLong();
      long a = sc.nextLong();
      long b = sc.nextLong();
      pw.println(MathAlgorighm.floorSum(n, m, a, b));
    }
    pw.close();
    sc.close();
  }

  // MathAlgorighmライブラリ
  static class MathAlgorighm {

    static long powMod(long x, long n, long mod) {
      assert (0 <= n && 1 <= mod);
      if (mod == 1) {
        return 0L;
      }
      long ret = 1l;
      while (n > 0) {
        if ((n & 1) == 1) {
          ret = safeMod(ret * x, mod);
        }
        x = safeMod(x * x, mod);
        n >>= 1;
      }
      return ret;
    }

    public static long invMod(long x, long mod) {
      assert (1 <= mod);
      long[] ret = invGcd(x, mod);
      assert (ret[0] == 1);
      return ret[1];
    }

    public static long[] crt(long[] rem, long[] mod) {
      assert (rem.length == mod.length) : "length of rem and mod is different";
      int n = rem.length;
      // Contracts: 0 <= r0 < m0
      long rem0 = 0L, mod0 = 1L;
      for (int i = 0; i < n; i++) {
        assert (1 <= mod[i]);
        long rem1 = safeMod(rem[i], mod[i]), mod1 = mod[i];
        if (mod0 < mod1) {
          //swap(rem0, rem1), swap(mod0, mod1)
          long r_tmp = rem0, m_tmp = mod0;
          rem0 = rem1;
          rem1 = r_tmp;
          mod0 = mod1;
          mod1 = m_tmp;
        }
        if (mod0 % mod1 == 0) {
          if (rem0 % mod1 != rem1) {
            return new long[]{0L, 0L};
          } else {
            continue;
          }
        }
        // im = inv(u0) (mod u1) (0 <= im < u1)
        long g, im;
        //std::tie(g, im) = internal::inv_gcd(m0, m1);
        long[] ret = invGcd(mod0, mod1);
        g = ret[0];
        im = ret[1];
        long u1 = (mod1 / g);
        // |r1 - r0| < (m0 + m1) <= lcm(m0, m1)
        if ((rem1 - rem0) % g != 0) {
          return new long[]{0L, 0L};
        }
        // u1 * u1 <= m1 * m1 / g / g <= m0 * m1 / g = lcm(m0, m1)
        long x = (rem1 - rem0) / g % u1 * im % u1;
        rem0 += x * mod0;
        mod0 *= u1;  // -> lcm(m0, m1)
        if (rem0 < 0) {
          rem0 += mod0;
        }
      }
      return new long[]{rem0, mod0};
    }

    public static long floorSum(long n, long m, long a, long b) {
      long ans = 0;
      if (a >= m) {
        ans += (n - 1) * n * (a / m) / 2;
        a %= m;
      }
      if (b >= m) {
        ans += n * (b / m);
        b %= m;
      }

      long y_max = (a * n + b) / m, x_max = (y_max * m - b);
      if (y_max == 0) {
        return ans;
      }
      ans += (n - (x_max + a - 1) / a) * y_max;
      ans += floorSum(y_max, a, m, (a - x_max % a) % a);
      return ans;
    }

    //from internal_math.hpp
    static long safeMod(long x, long mod) {
      long ret = x % mod;
      if (ret < 0) {
        ret += mod;
      }
      return ret;
    }

    static long[] invGcd(long a, long b) {
      a = safeMod(a, b);
      if (a == 0) {
        return new long[]{b, 0L};
      }

      long s = b, t = a;
      long m0 = 0, m1 = 1;
      while (t != 0) {
        long u = s / t;
        s -= t * u;
        m0 -= m1 * u;
        long tmp = s;
        s = t;
        t = tmp;
        tmp = m0;
        m0 = m1;
        m1 = tmp;
      }
      if (m0 < 0) {
        m0 += b / s;
      }
      return new long[]{s, m0};
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
