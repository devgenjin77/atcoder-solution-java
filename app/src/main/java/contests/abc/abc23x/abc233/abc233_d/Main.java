/*
 * AtCoder Beginner Contest 233
 * D - Count Interval
 * https://atcoder.jp/contests/abc233/tasks/abc233_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc233/submissions/33906994
 *
 * note:
 * 累積和を使う。
 *
 */

package contests.abc.abc23x.abc233.abc233_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final long k = Long.parseLong(st.nextToken());
    final long[] array_a = new long[n];
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
    }
    br.close();
    //累積和
    final long[] cum_a = new long[n];
    for (int i = 0; i < n; i++) {
      cum_a[i] = array_a[i];
      if (i > 0) {
        cum_a[i] += cum_a[i - 1];
      }
    }
    //今まで出た累積和の種類とその出現数
    Map<Long, Integer> cum_map = new HashMap<>();
    cum_map.put(0l, 1);
    long ans = 0;
    for (int i = 0; i < n; i++) {
      if (i > 0) {
        cum_map.put(cum_a[i - 1], cum_map.getOrDefault(cum_a[i - 1], 0) + 1);
      }
      ans += cum_map.getOrDefault(cum_a[i] - k, 0);
    }
    System.out.println(ans);
  }
}
