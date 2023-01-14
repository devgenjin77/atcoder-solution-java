/*
 * AtCoder Beginner Contest 206
 * （Sponsored by Panasonic）
 * B - Savings
 * https://atcoder.jp/contests/abc206/tasks/abc206_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc206/submissions/37993116
 *
 * note:
 *
 */

package contests.abc.abc20x.abc206.abc206_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final long n = Long.parseLong(br.readLine());
    br.close();
    long ok = n, ng = 0;
    while (ok - ng > 1) {
      long mid = (ok + ng) / 2;
      if (((mid + 1) * mid) / 2 >= n) {
        ok = mid;
      } else {
        ng = mid;
      }
    }
    System.out.println(ok);
  }
}
