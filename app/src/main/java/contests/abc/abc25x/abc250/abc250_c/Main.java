/*
 * AtCoder Beginner Contest 250
 * C - Adjacent Swaps
 * https://atcoder.jp/contests/abc250/tasks/abc250_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc250/submissions/35255510
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc250.abc250_c;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int q = sc.nextInt();
    final int[] num_to_idx = new int[n];
    final int[] idx_to_num = new int[n];
    for (int i = 0; i < n; i++) {
      num_to_idx[i] = i;
      idx_to_num[i] = i;
    }
    for (int i = 0; i < q; i++) {
      int x = sc.nextInt() - 1;
      int idx1 = num_to_idx[x];
      int idx2 = idx1 == n - 1 ? idx1 - 1 : idx1 + 1;
      int y = idx_to_num[idx2];
      //num->idxの更新
      num_to_idx[x] = idx2;
      num_to_idx[y] = idx1;
      //idx->numの更新
      idx_to_num[idx1] = y;
      idx_to_num[idx2] = x;
    }
    sc.close();

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      sb.append(idx_to_num[i] + 1).append(' ');
    }
    System.out.println(sb.deleteCharAt(sb.length() - 1));
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
