/*
 * 京セラプログラミングコンテスト2021
 * （AtCoder Beginner Contest 200）
 * C - Ringo's Favorite Numbers 2
 * https://atcoder.jp/contests/abc200/tasks/abc200_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc200/submissions/37774045
 *
 * note:
 *
 *
 */

package contests.abc.abc20x.abc200.abc200_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final long[] a_mod200 = new long[200];
    for (int i = 0; i < n; i++) {
      a_mod200[Integer.parseInt(st_a.nextToken()) % 200]++;
    }
    br.close();
    long ans = 0;
    for (int i = 0; i < 200; i++) {
      ans += a_mod200[i] * (a_mod200[i] - 1) / 2;
    }
    System.out.println(ans);
  }
}
