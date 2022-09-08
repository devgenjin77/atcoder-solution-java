/*
 * NECプログラミングコンテスト2022
 * （AtCoder Beginner Contest 267）
 * C - Index × A(Continuous ver.)
 * https://atcoder.jp/contests/abc267/tasks/abc267_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc267/submissions/34691766
 *
 */

package contests.abc.abc26x.abc267.abc267_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final long[] array_a = new long[n];
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
    }
    br.close();

    long ans = 0, cur_ans = 0, cur_sum = 0;
    for (int i = 0; i < m; i++) {
      cur_ans += (i + 1) * array_a[i];
      cur_sum += array_a[i];
    }
    ans = cur_ans;
    for (int i = m; i < n; i++) {
      cur_ans += (m * array_a[i]) - cur_sum;
      ans = Math.max(cur_ans, ans);
      cur_sum += (array_a[i] - array_a[i - m]);
    }
    System.out.println(ans);
  }
}
