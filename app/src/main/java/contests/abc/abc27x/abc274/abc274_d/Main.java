/*
 * キーエンスプログラミングコンテスト2022
 * （AtCoder Beginner Contest 274）
 * D - Robot Arms 2
 * https://atcoder.jp/contests/abc274/tasks/abc274_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc274/submissions/35915666
 *
 */

package contests.abc.abc27x.abc274.abc274_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int x = Integer.parseInt(st.nextToken());
    final int y = Integer.parseInt(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    int sum_x = 0, sum_y = 0;
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
      if (i % 2 == 0) {
        sum_x += array_a[i];
      } else {
        sum_y += array_a[i];
      }
    }
    br.close();

    if (Math.abs(x) > sum_x || Math.abs(y) > sum_y) {
      System.out.println("No");
      return;
    }
    final boolean[] dp_x = new boolean[(sum_x * 2) + 1];
    final boolean[] dp_x_next = new boolean[(sum_x * 2) + 1];
    final boolean[] dp_y = new boolean[(sum_y * 2) + 1];
    final boolean[] dp_y_next = new boolean[(sum_y * 2) + 1];
    dp_x[sum_x + array_a[0]] = true;
    dp_y[sum_y] = true;
    for (int i = 1; i < n; i++) {
      int a = array_a[i];
      boolean[] dp = (i % 2 == 0) ? dp_x : dp_y;
      boolean[] dp_next = (i % 2 == 0) ? dp_x_next : dp_y_next;
      Arrays.fill(dp_next, false);
      for (int j = dp.length - 1; j >= 0; j--) {
        if (j + a < dp.length) {
          dp_next[j + a] |= dp[j];
        }
        if (j - a >= 0) {
          dp_next[j - a] |= dp[j];
        }
      }
      System.arraycopy(dp_next, 0, dp, 0, dp.length);
    }
    System.out.println((dp_x[sum_x + x] && dp_y[sum_y + y]) ? "Yes" : "No");
  }
}
