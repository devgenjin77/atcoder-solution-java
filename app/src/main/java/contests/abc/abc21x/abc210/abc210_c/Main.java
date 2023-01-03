/*
 * AtCoder Beginner Contest 210
 * C - Colorful Candies
 * https://atcoder.jp/contests/abc210/tasks/abc210_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc210/submissions/37718533
 *
 * note:
 *
 *
 */

package contests.abc.abc21x.abc210.abc210_c;

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
    final int k = Integer.parseInt(st.nextToken());
    final StringTokenizer st_c = new StringTokenizer(br.readLine());
    final int[] array_c = new int[n];
    for (int i = 0; i < n; i++) {
      array_c[i] = Integer.parseInt(st_c.nextToken());
    }
    br.close();
    final Map<Integer, Integer> map_cnt = new HashMap<>();
    for (int i = 0; i < k; i++) {
      map_cnt.put(array_c[i], map_cnt.getOrDefault(array_c[i], 0) + 1);
    }
    int ans = map_cnt.size();
    for (int i = k; i < n; i++) {
      int prev_cnt = map_cnt.get(array_c[i - k]) - 1;
      if (prev_cnt > 0) {
        map_cnt.put(array_c[i - k], prev_cnt);
      } else {
        map_cnt.remove(array_c[i - k]);
      }
      map_cnt.put(array_c[i], map_cnt.getOrDefault(array_c[i], 0) + 1);
      ans = Math.max(map_cnt.size(), ans);
    }
    System.out.println(ans);
  }
}
