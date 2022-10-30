/*
 * AtCoder Beginner Contest 275
 * B - ABC-DEF
 * https://atcoder.jp/contests/abc275/tasks/abc275_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc275/submissions/36101269
 *
 * note:
 *
 *
 */

package contests.abc.abc27x.abc275.abc275_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static final long MOD = 998244353L;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final long a = Long.parseLong(st.nextToken());
    final long b = Long.parseLong(st.nextToken());
    final long c = Long.parseLong(st.nextToken());
    final long d = Long.parseLong(st.nextToken());
    final long e = Long.parseLong(st.nextToken());
    final long f = Long.parseLong(st.nextToken());
    br.close();
    System.out.println((func(a, b, c) - func(d, e, f) + MOD) % MOD);
  }

  static final long func(long a, long b, long c) {
    return (((a % MOD) * (b % MOD) % MOD) * (c % MOD)) % MOD;
  }
}
