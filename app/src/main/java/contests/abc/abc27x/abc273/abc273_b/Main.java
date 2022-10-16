/*
 * パナソニックグループプログラミングコンテスト2022
 * （AtCoder Beginner Contest 273）
 * B - Broken Rounding
 * https://atcoder.jp/contests/abc273/tasks/abc273_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc273/submissions/35707126
 *
 */

package contests.abc.abc27x.abc273.abc273_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final long x = Long.parseLong(st.nextToken());
    final int k = Integer.parseInt(st.nextToken());
    br.close();
    long ans = x;
    long p = 10;
    for (int i = 0; i < k; i++) {
      long mod = ans % p;
      if (mod * 2 < p) {
        ans -= mod;
      } else {
        ans += (p - mod);
      }
      p *= 10;
    }
    System.out.println(ans);
  }
}
