/*
 * LINE Verda プログラミングコンテスト
 * （AtCoder Beginner Contest 263）
 * D - Left Right Operation
 * https://atcoder.jp/contests/abc263/tasks/abc263_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc263/submissions/35946368
 *
 */

package contests.abc.abc26x.abc263.abc263_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final long l = Long.parseLong(st.nextToken());
    final long r = Long.parseLong(st.nextToken());
    final long[] array_a = new long[n];
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
    }
    br.close();
    //Aの累積和
    final long[] cum_a = new long[n + 1];
    for (int i = 0; i < n; i++) {
      cum_a[i + 1] = cum_a[i] + array_a[i];
    }
    //min_sum_r[y]:=0-yの範囲で試したときの配列全体の合計の最小値
    final long[] min_sum_r = new long[n + 1];
    min_sum_r[0] = cum_a[n];
    for (int y = 1; y <= n; y++) {
      min_sum_r[y] = Math.min(cum_a[n - y] + (r * y), min_sum_r[y - 1]);
    }
    long ans = Long.MAX_VALUE;
    for (int x = 0; x <= n; x++) {
      ans = Math.min((l * x) + min_sum_r[n - x] - cum_a[x], ans);
    }
    System.out.println(ans);
  }
}
