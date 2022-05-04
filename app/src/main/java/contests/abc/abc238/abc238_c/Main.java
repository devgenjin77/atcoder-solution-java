/*
 * モノグサプログラミングコンテスト2022
 * （AtCoder Beginner Contest 238）
 * C - digitnum
 * https://atcoder.jp/contests/abc238/tasks/abc238_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc238/submissions/31433079
 *
 */

package contests.abc.abc238.abc238_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static final long MOD = 998244353l;

  static final long INV2 = (MOD + 1) / 2;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    br.close();
    long ans = 0;
    long num99 = 9;
    while (true) {
      if (num99 < n) {
        ans += func(num99 - (num99 / 10));
        ans %= MOD;
      } else {
        ans += func(n - (num99 / 10));
        ans %= MOD;
        break;
      }
      num99 = (num99 * 10) + 9;
    }
    System.out.println(ans);
  }

  static long func(long x) {
    //1-xまでの等差数列の和をmod998244353で返す
    long x2 = x % MOD;
    long ret = ((x2 + 1) % MOD) * x2 % MOD * INV2 % MOD;
    return ret;
  }
}
