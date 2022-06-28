/*
 * AtCoder Beginner Contest 220
 * C - Long Sequence
 * https://atcoder.jp/contests/abc220/tasks/abc220_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc220/submissions/32820425
 *
 */

package contests.abc.abc22x.abc220.abc220_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    // 累積和
    final long[] c_sum = new long[n];
    for (int i = 0; i < n; i++) {
      c_sum[i] = Long.parseLong(st_a.nextToken());
      if (i > 0) {
        c_sum[i] += c_sum[i - 1];
      }
    }
    final long x = Long.parseLong(br.readLine());
    br.close();
    long times = x / c_sum[n - 1];
    long ans_r = x % c_sum[n - 1];
    long ans = times * n;
    int idx = Arrays.binarySearch(c_sum, ans_r);
    if (idx >= 0) {
      ans += idx + 2;
    } else {
      idx = ~idx;
      ans += idx + 1;
    }
    System.out.println(ans);
  }
}
