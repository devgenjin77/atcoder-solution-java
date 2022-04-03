/*
 * ABC246
 * A - Four Points
 * https://atcoder.jp/contests/abc246/tasks/abc246_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc246/submissions/30697331
 *
 */

package contests.abc.abc246.abc246_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int ans_x = 0;
    int ans_y = 0;
    for (int i = 0; i < 3; i++) {
      String[] input = br.readLine().split(" ");
      int x = Integer.parseInt(input[0]);
      int y = Integer.parseInt(input[1]);
      ans_x ^= x;
      ans_y ^= y;
    }
    br.close();
    System.out.println(String.format("%d %d", ans_x, ans_y));
  }
}
