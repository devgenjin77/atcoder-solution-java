/*
 * 競プロ典型90問
 * 009 - Three Point Angle（★6）
 * https://atcoder.jp/contests/typical90/tasks/typical90_i
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/37754731
 *
 * note:
 * 偏角ソート
 */

package contests.typical90.typical90_01.typical90_009;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int[] array_x = new int[n];
    final int[] array_y = new int[n];
    for (int i = 0; i < n; i++) {
      array_x[i] = sc.nextInt();
      array_y[i] = sc.nextInt();
    }
    sc.close();
    double ans = 0.0;
    for (int i = 0; i < n; i++) {
      double[] arr_d = new double[n - 1];
      int idx_d = 0;
      for (int k = 0; k < n; k++) {
        if (i != k) {
          //y_i, x_iから見た偏角
          arr_d[idx_d++] = Math.toDegrees(
              Math.atan2(array_y[k] - array_y[i], array_x[k] - array_x[i]));
        }
      }
      Arrays.sort(arr_d);
      for (int j = 0; j < n - 1; j++) {
        int idx = Arrays.binarySearch(arr_d, (arr_d[j] + 180.0) % 360.0);
        if (idx < 0) {
          idx = ~idx;
        }
        double tmp1 = Math.abs(arr_d[idx % (n - 1)] - arr_d[j]);
        tmp1 = Math.min(360.0 - tmp1, tmp1);
        double tmp2 = Math.abs(arr_d[(idx + 1) % (n - 1)] - arr_d[j]);
        tmp2 = Math.min(360.0 - tmp2, tmp2);
        ans = Math.max(Math.max(tmp1, tmp2), ans);
      }
    }
    System.out.println(ans);
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
