/*
 * モノグサプログラミングコンテスト2022
 * （AtCoder Beginner Contest 238）
 * C - digitnum
 * https://atcoder.jp/contests/abc238/tasks/abc238_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc238/submissions/33942425
 *
 * note:
 * 逆元２に注意する
 *
 */

package contests.abc.abc23x.abc238.abc238_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static final long MOD = 998244353L;

  static final long INV2 = (MOD + 1) / 2;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final long n = Long.parseLong(br.readLine());
    br.close();
    long ans = 0;
    long d = 1;
    while (n >= d) {
      long right = Math.min(n, (d * 10) - 1);
      //項数
      long num = (right - d + 1) % MOD;
      long add = (((1 + num + MOD) % MOD) * num) % MOD;
      add = (add * INV2) % MOD;
      ans += (MOD + add);
      ans %= MOD;
      d *= 10;
    }
    System.out.println(ans);
  }
}
