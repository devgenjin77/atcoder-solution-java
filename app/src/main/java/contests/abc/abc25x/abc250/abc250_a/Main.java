/*
 * AtCoder Beginner Contest 250
 * A - Adjacent Squares
 * https://atcoder.jp/contests/abc250/tasks/abc250_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc250/submissions/35238382
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc250.abc250_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st_hw = new StringTokenizer(br.readLine());
    final StringTokenizer st_rc = new StringTokenizer(br.readLine());
    final int h = Integer.parseInt(st_hw.nextToken());
    final int w = Integer.parseInt(st_hw.nextToken());
    final int r = Integer.parseInt(st_rc.nextToken());
    final int c = Integer.parseInt(st_rc.nextToken());
    br.close();
    int ans = 0;
    if (r > 1) {
      ans++;
    }
    if (r < h) {
      ans++;
    }
    if (c > 1) {
      ans++;
    }
    if (c < w) {
      ans++;
    }
    System.out.println(ans);
  }
}
