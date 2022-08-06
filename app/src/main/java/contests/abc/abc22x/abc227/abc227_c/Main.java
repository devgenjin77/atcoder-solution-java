/*
 * キーエンスプログラミングコンテスト2021-Nov.
 * （AtCoder Beginner Contest 227）
 * C - ABC conjecture
 * https://atcoder.jp/contests/abc227/tasks/abc227_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc227/submissions/33793705
 *
 * note:
 * Nの立方根を上限として探索する
 *
 */

package contests.abc.abc22x.abc227.abc227_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final long n = Long.parseLong(br.readLine());
    br.close();
    final long cb_n = (long) Math.cbrt(n);
    long ans = 0;
    for (long a = 1; a <= cb_n; a++) {
      for (long b = a; b * b <= n / a; b++) {
        long max_c = n / (a * b);
        ans += max_c - b + 1;
      }
    }
    System.out.println(ans);
  }
}
