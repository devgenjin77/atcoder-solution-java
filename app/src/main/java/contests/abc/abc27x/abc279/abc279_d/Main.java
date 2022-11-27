/*
 * トヨタシステムズプログラミングコンテスト2022
 * （AtCoder Beginner Contest 279）
 * D - Freefall
 * https://atcoder.jp/contests/abc279/tasks/abc279_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc279/submissions/36843925
 *
 * note:
 * 三分探索の典型
 * 微分して計算することも一応可能
 *
 */

package contests.abc.abc27x.abc279.abc279_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final long a = Long.parseLong(st.nextToken());
    final long b = Long.parseLong(st.nextToken());
    br.close();
    long left = 1, right = Math.max(a / b, 1L);
    while (right - left > 2) {
      long mid_l = ((2 * left) + right) / 3;
      long mid_r = ((2 * right) + left) / 3;
      double l = func(a, b, mid_l);
      double r = func(a, b, mid_r);
      if (l > r) {
        left = mid_l;
      } else {
        right = mid_r;
      }
    }
    double ans = Double.MAX_VALUE;
    for (long x = left; x <= right; x++) {
      ans = Math.min(func(a, b, x), ans);
    }
    System.out.println(ans);
  }

  static double func(long a, long b, long g) {
    double t = (b * (g - 1));
    t += (double) a / Math.sqrt(g);
    return t;
  }
}
