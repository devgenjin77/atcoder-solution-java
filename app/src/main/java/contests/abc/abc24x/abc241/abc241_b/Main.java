/*
 * ABC241
 * B - Pasta
 * https://atcoder.jp/contests/abc241/tasks/abc241_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc241/submissions/32308654
 *
 */

package contests.abc.abc24x.abc241.abc241_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    StringTokenizer st_a = new StringTokenizer(br.readLine());
    StringTokenizer st_b = new StringTokenizer(br.readLine());
    br.close();
    Map<Integer, Integer> map_a = new HashMap<>();
    while (st_a.hasMoreTokens()) {
      int a = Integer.parseInt(st_a.nextToken());
      map_a.put(a, map_a.getOrDefault(a, 0) + 1);
    }
    boolean isOk = true;
    while (st_b.hasMoreTokens()) {
      int b = Integer.parseInt(st_b.nextToken());
      int cnt_b = map_a.getOrDefault(b, 0);
      if (cnt_b > 0) {
        map_a.put(b, cnt_b - 1);
      } else {
        isOk = false;
        break;
      }
    }
    System.out.println(isOk ? "Yes" : "No");
  }
}
