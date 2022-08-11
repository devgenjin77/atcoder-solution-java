/*
 * モノグサプログラミングコンテスト2022
 * （AtCoder Beginner Contest 238）
 * B - Pizza
 * https://atcoder.jp/contests/abc238/tasks/abc238_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc238/submissions/33936898
 *
 * note:
 * 累積和をとり、切れ込みが現在どの角度にあるかを管理する
 *
 */

package contests.abc.abc23x.abc238.abc238_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final int[] array_a = new int[n];
    final StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
    //累積和を取って、MOD360を取る
    final int[] cum_a = new int[n];
    for (int i = 0; i < n; i++) {
      cum_a[i] = array_a[i];
      if (i > 0) {
        cum_a[i] += cum_a[i - 1];
      }
      cum_a[i] %= 360;
    }
    Arrays.sort(cum_a);
    int ans = Math.max(cum_a[0], 360 - cum_a[n - 1]);
    for (int i = 1; i < n; i++) {
      ans = Math.max(cum_a[i] - cum_a[i - 1], ans);
    }
    System.out.println(ans);
  }
}
