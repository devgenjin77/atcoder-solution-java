/*
 * AtCoder Library Practice Contest
 * B - Fenwick Tree
 * https://atcoder.jp/contests/practice2/tasks/practice2_b
 *
 * verified:
 * - https://atcoder.jp/contests/practice2/submissions/30932220
 *
 */

package contests.practice2.practice2_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner sc = new NextScanner();
    int n = Integer.parseInt(sc.next());
    int q = Integer.parseInt(sc.next());
    long[] array_a = new long[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(sc.next());
    }
    FenwickTree ft = new FenwickTree(array_a);
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      int type = Integer.parseInt(sc.next());
      if (type == 0) {
        int p = Integer.parseInt(sc.next());
        long x = Long.parseLong(sc.next());
        ft.add(p, x);
      } else if (type == 1) {
        int l = Integer.parseInt(sc.next());
        int r = Integer.parseInt(sc.next());
        pw.println(ft.sum(l, r));
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

  //NextScannerライブラリ
  static class NextScanner implements AutoCloseable {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;

    public String next() throws IOException {
      if (st == null || !st.hasMoreElements()) {
        st = new StringTokenizer(in.readLine());
      }
      return st.nextToken();
    }

    @Override
    public void close() throws Exception {
      in.close();
    }
  }
}
