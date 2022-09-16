/*
 * AtCoder Beginner Contest 243
 * B - Hit and Blow
 * https://atcoder.jp/contests/abc243/tasks/abc243_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc243/submissions/34896677
 *
 * note:
 *
 */

package contests.abc.abc24x.abc243.abc243_b;

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
    final Map<Integer, Integer> val_to_idx = new HashMap<>();
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int val_a = Integer.parseInt(st_a.nextToken());
      val_to_idx.put(val_a, i);
    }
    final StringTokenizer st_b = new StringTokenizer(br.readLine());
    int hit = 0, blow = 0;
    for (int i = 0; i < n; i++) {
      int val_b = Integer.parseInt(st_b.nextToken());
      if (val_to_idx.containsKey(val_b)) {
        if (val_to_idx.get(val_b) == i) {
          hit++;
        } else {
          blow++;
        }
      }
    }
    br.close();
    System.out.println(hit);
    System.out.println(blow);
  }
}
