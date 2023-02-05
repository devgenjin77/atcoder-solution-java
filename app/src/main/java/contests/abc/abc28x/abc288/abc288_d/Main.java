/*
 * Toyota Programming Contest 2023 Spring Qual A
 * （AtCoder Beginner Contest 288）
 * D - Range Add Query
 * https://atcoder.jp/contests/abc288/tasks/abc288_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc288/submissions/38650486
 *
 * note:
 * 配列をModKごとにグループ分け。指定範囲のModKごとの合計が全て同じならOK
 *
 */

package contests.abc.abc28x.abc288.abc288_d;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final int k = sc.nextInt();
    final long[] array_a = new long[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = sc.nextLong();
    }
    final long[][] cum_grp_mod = new long[k][(n + k - 1) / k];
    //modKごとにグループ分け
    for (int i = 0; i < n; i++) {
      cum_grp_mod[i % k][i / k] = array_a[i];
    }
    //累積和計算
    for (int i = 0; i < k; i++) {
      for (int j = 1; j < cum_grp_mod[i].length; j++) {
        cum_grp_mod[i][j] += cum_grp_mod[i][j - 1];
      }
    }
    final int q = sc.nextInt();
    final PrintWriter pw = new PrintWriter(System.out);
    for (int cnt = 0; cnt < q; cnt++) {
      int l = sc.nextInt() - 1;
      int r = sc.nextInt() - 1;
      long sum = -1;
      boolean isOK = true;
      //modkでグループ分した時の其々の要素和が同じかどうかをチェック
      for (int i = 0; i < k; i++) {
        int left = i >= (l % k) ? (l / k) : (l / k) + 1;
        int right = i <= (r % k) ? (r / k) : (r / k) - 1;
        long wk = cum_grp_mod[i][right];
        if (left != 0) {
          wk -= cum_grp_mod[i][left - 1];
        }
        if (sum == -1) {
          sum = wk;
        } else {
          if (sum != wk) {
            isOK = false;
            break;
          }
        }
      }
      pw.println(isOK ? "Yes" : "No");
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
