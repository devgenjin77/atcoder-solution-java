/*
 * AtCoder Beginner Contest 206
 * （Sponsored by Panasonic）
 * C - Swappable
 * https://atcoder.jp/contests/abc206/tasks/abc206_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc206/submissions/37994536
 *
 * note:
 *
 */

package contests.abc.abc20x.abc206.abc206_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    br.close();
    final Map<String, Integer> cnt_map = new HashMap<>();
    while (st_a.hasMoreTokens()) {
      String a = st_a.nextToken();
      cnt_map.put(a, cnt_map.getOrDefault(a, 0) + 1);
    }
    long ans = calc(n - 1);
    for (String key : cnt_map.keySet()) {
      ans -= calc(cnt_map.get(key) - 1);
    }
    System.out.println(ans);
  }

  private static long calc(long n) {
    //初項1且つ項数nの等差数列の和
    return n * (n + 1) / 2;
  }
}
