/*
 * AtCoder Beginner Contest 243
 * C - Collision 2
 * https://atcoder.jp/contests/abc243/tasks/abc243_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc243/submissions/34897315
 *
 * note:
 *
 */

package contests.abc.abc24x.abc243.abc243_c;

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
    final int[] pos_x = new int[n];
    final int[] pos_y = new int[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st_xy = new StringTokenizer(br.readLine());
      pos_x[i] = Integer.parseInt(st_xy.nextToken());
      pos_y[i] = Integer.parseInt(st_xy.nextToken());
    }
    String s = br.readLine();
    br.close();
    final Map<Integer, Integer> min_x_to_right = new HashMap<>();
    final Map<Integer, Integer> max_x_to_left = new HashMap<>();
    boolean isCollision = false;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == 'L') {
        if (min_x_to_right.getOrDefault(pos_y[i], Integer.MAX_VALUE) < pos_x[i]) {
          isCollision = true;
          break;
        }
        max_x_to_left.put(pos_y[i], Math.max(pos_x[i], max_x_to_left.getOrDefault(pos_y[i], 0)));
      } else {
        if (max_x_to_left.getOrDefault(pos_y[i], 0) > pos_x[i]) {
          isCollision = true;
          break;
        }
        min_x_to_right.put(pos_y[i],
            Math.min(pos_x[i], min_x_to_right.getOrDefault(pos_y[i], Integer.MAX_VALUE)));
      }
    }
    System.out.println(isCollision ? "Yes" : "No");
  }
}
