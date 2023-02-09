/*
 * AtCoder Beginner Contest 285
 * F - Substring of Sorted String
 * https://atcoder.jp/contests/abc285/tasks/abc285_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc285/submissions/38739210
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc285.abc285_f;

import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws Exception {
    final FastScanner sc = new FastScanner(System.in);
    final int n = sc.nextInt();
    final String s = sc.next();
    final int[] arr_s = new int[n];
    final int[] cnt_s = new int[26];
    for (int i = 0; i < n; i++) {
      arr_s[i] = s.charAt(i) - 'a';
      cnt_s[arr_s[i]]++;
    }
    final FenwickTree[] arr_ft = new FenwickTree[26];
    for (int i = 0; i < 26; i++) {
      arr_ft[i] = new FenwickTree(n);
      for (int j = 0; j < n; j++) {
        if (arr_s[j] == i) {
          arr_ft[i].add(j, 1);
        }
      }
    }
    final int q = sc.nextInt();
    final PrintWriter pw = new PrintWriter(System.out);
    for (int cnt = 0; cnt < q; cnt++) {
      int t = sc.nextInt();
      if (t == 1) {
        int x = sc.nextInt() - 1;
        int c_x = sc.next().charAt(0) - 'a';
        arr_ft[arr_s[x]].add(x, -1);
        cnt_s[arr_s[x]]--;
        arr_s[x] = c_x;
        arr_ft[arr_s[x]].add(x, 1);
        cnt_s[arr_s[x]]++;
      } else if (t == 2) {
        int l = sc.nextInt() - 1;
        int r = sc.nextInt();
        int len = r - l;
        int off = 0;
        boolean isOK = true;
        //'a'-'z'まで
        for (int i = 0; i < 26; i++) {
          //全範囲でいま対象の文字の個数をみる。
          int cnt_all = Math.min(cnt_s[i], len - off);
          if (cnt_all > 0) {
            int con_range = (int) arr_ft[i].sum(l + off, l + off + cnt_all);
            if (off > 0 && cnt_all != con_range) {
              isOK = false;
              break;
            } else {
              off += con_range;
            }
          }
        }
        if (len > off) {
          isOK = false;
        }
        pw.println(isOK ? "Yes" : "No");
      }
    }
    pw.close();
    sc.close();
  }

  //FenwickTreeライブラリ
  static class FenwickTree {

    final int N;
    long[] data;

    public FenwickTree(int n) {
      N = n;
      this.data = new long[n];
    }

    public FenwickTree(long[] data) {
      N = data.length;
      this.data = new long[this.N];
      System.arraycopy(data, 0, this.data, 0, N);
      for (int i = 1; i <= N; i++) {
        int p = i + (-i & i);
        if (p <= N) {
          this.data[p - 1] += this.data[i - 1];
        }
      }
    }

    public void add(int p, long x) {
      if (!(p >= 0 && p < N)) {
        String errMsg = String.format("Index %d out of bounds for length %d.", p, N);
        throw new ArrayIndexOutOfBoundsException(errMsg);
      }
      p++;
      while (p <= N) {
        data[p - 1] += x;
        p += -p & p;
      }
    }

    public long sum(int l, int r) {
      if (l > r) {
        String errMsg = String.format("Invalid range: [%d, %d).", l, r);
        throw new IllegalArgumentException(errMsg);
      }
      if (!(l >= 0 && l <= N)) {
        String errMsg = String.format("Index %d out of bounds for length %d.", l, N);
        throw new ArrayIndexOutOfBoundsException(errMsg);
      }
      if (!(r >= 0 && r <= N)) {
        String errMsg = String.format("Index %d out of bounds for length %d.", r, N);
        throw new ArrayIndexOutOfBoundsException(errMsg);
      }
      return sum(r) - sum(l);
    }

    private long sum(int r) {
      long s = 0;
      while (r > 0) {
        s += data[r - 1];
        r -= -r & r;
      }
      return s;
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
