/*
 * AtCoder Regular Contest 154
 * A - Swap Digit
 * https://atcoder.jp/contests/arc154/tasks/arc154_a
 *
 * verified:
 * - https://atcoder.jp/contests/arc154/submissions/38285593
 *
 * note:
 * ・AxBの値を最小化するには、どちらかをできるだけ小さな値にするとよい
 *
 */

package contests.arc.arc15x.arc154.arc154_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static final long MOD = 998244353L;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String a = br.readLine();
    final String b = br.readLine();
    br.close();
    final StringBuilder sb_a = new StringBuilder(a);
    final StringBuilder sb_b = new StringBuilder(b);
    for (int i = 0; i < n; i++) {
      if (sb_a.charAt(i) > sb_b.charAt(i)) {
        sb_a.setCharAt(i, b.charAt(i));
        sb_b.setCharAt(i, a.charAt(i));
      }
    }
    long val_a = 0, val_b = 0;
    long pow = 1;
    for (int i = n - 1; i >= 0; i--) {
      val_a += (long) (sb_a.charAt(i) - '0') * pow;
      val_a %= MOD;
      val_b += (long) (sb_b.charAt(i) - '0') * pow;
      val_b %= MOD;
      pow *= 10;
      pow %= MOD;
    }
    System.out.println((val_a * val_b) % MOD);
  }
}
