/*
 * AtCoder Beginner Contest 276
 * F - Double Chance
 * https://atcoder.jp/contests/abc276/tasks/abc276_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc276/submissions/36292974
 *
 * note:
 *
 *
 */

package contests.abc.abc27x.abc276.abc276_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  private static final long MOD = 998244353L;

  private static final int MAX_A = 200_000;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    FenwickTree bit_cnt = new FenwickTree(MAX_A + 1);
    FenwickTree bit_sum = new FenwickTree(MAX_A + 1);
    final long[] ans = new long[n];
    long top = 0;
    for (int i = 0; i < n; i++) {
      int a = array_a[i];
      long add = (bit_cnt.sum(0, a + 1) * a) + bit_sum.sum(a + 1, MAX_A + 1);
      top = (top + add + add + a) % MOD;
      long bottom2 = modinv(i + 1, MOD);
      ans[i] = (((top * bottom2) % MOD) * bottom2) % MOD;
      bit_cnt.add(a, 1);
      bit_sum.add(a, a);
    }
    PrintWriter pw = new PrintWriter(System.out);
    for (long a : ans) {
      pw.println(a);
    }
    pw.close();
  }

  static long modinv(long a, long m) {
    long b = m;
    long u = 1;
    long v = 0;
    long tmp = 0;

    while (b > 0) {
      long t = a / b;
      a -= t * b;
      tmp = a;
      a = b;
      b = tmp;

      u -= t * v;
      tmp = u;
      u = v;
      v = tmp;
    }

    u %= m;
    if (u < 0) {
      u += m;
    }
    return u;
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
}
