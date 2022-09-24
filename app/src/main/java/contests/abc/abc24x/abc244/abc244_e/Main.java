/*
 * AtCoder Beginner Contest 244
 * E - King Bombee
 * https://atcoder.jp/contests/abc244/tasks/abc244_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc244/submissions/35084122
 *
 * note:
 *
 */

package contests.abc.abc24x.abc244.abc244_e;

public class Main {

  private static final long MOD = 998244353L;

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int m = sc.nextInt();
    final int k = sc.nextInt();
    final int s = sc.nextInt() - 1;
    final int t = sc.nextInt() - 1;
    final int x = sc.nextInt() - 1;
    final int[] array_u = new int[m];
    final int[] array_v = new int[m];
    for (int i = 0; i < m; i++) {
      array_u[i] = sc.nextInt() - 1;
      array_v[i] = sc.nextInt() - 1;
    }
    sc.close();
    //dp[k][n][2]:=k回目の移動で、頂点nに到達し、且つxにmod2回到達した
    long[][] dp_prev = new long[n][2];
    dp_prev[s][0] = 1;
    for (int i = 1; i <= k; i++) {
      long[][] dp_next = new long[n][2];
      for (int j = 0; j < m; j++) {
        //u -> v
        if (array_v[j] == x) {
          dp_next[array_v[j]][1] += dp_prev[array_u[j]][0];
          dp_next[array_v[j]][0] += dp_prev[array_u[j]][1];
        } else {
          dp_next[array_v[j]][0] += dp_prev[array_u[j]][0];
          dp_next[array_v[j]][1] += dp_prev[array_u[j]][1];
        }
        //v -> u
        if (array_u[j] == x) {
          dp_next[array_u[j]][1] += dp_prev[array_v[j]][0];
          dp_next[array_u[j]][0] += dp_prev[array_v[j]][1];
        } else {
          dp_next[array_u[j]][0] += dp_prev[array_v[j]][0];
          dp_next[array_u[j]][1] += dp_prev[array_v[j]][1];
        }
        dp_next[array_u[j]][0] %= MOD;
        dp_next[array_u[j]][1] %= MOD;
        dp_next[array_v[j]][0] %= MOD;
        dp_next[array_v[j]][1] %= MOD;
      }
      dp_prev = dp_next;
    }
    System.out.println(dp_prev[t][0]);
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
