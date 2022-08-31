/*
 * AtCoder Beginner Contest 266
 * B - Modulo Number
 * https://atcoder.jp/contests/abc266/tasks/abc266_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc266/submissions/34479483
 *
 * note:
 *
 *
 */

package contests.abc.abc26x.abc266.abc266_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static final long MOD = 998244353L;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final long n = Long.parseLong(br.readLine());
    br.close();
    System.out.println(((n % MOD) + MOD) % MOD);
  }
}
