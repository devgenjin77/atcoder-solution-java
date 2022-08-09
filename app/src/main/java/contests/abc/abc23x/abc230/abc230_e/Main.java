/*
 * AtCoder Beginner Contest 230
 * E - Fraction Floor Sum
 * https://atcoder.jp/contests/abc230/tasks/abc230_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc230/submissions/33897114
 *
 * note:
 *
 *
 */

package contests.abc.abc23x.abc230.abc230_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final long n = Long.parseLong(br.readLine());
    br.close();
    final long k = (long)Math.sqrt(n);
    long ans = 0;
    // n / i > sqrt(n)の合算
    for(long div = 1; div <= n / (k + 1); div++) {
      ans += n / div;
    }
    // n / i <= sqrt(n)の合算
    for(long q = 1; q <= k; q++) {
      ans += q * ((n / q) - (n / (q + 1)));
    }
    System.out.println(ans);
  }
}
