/*
 * AtCoder Beginner Contest 214
 * A - New Generation ABC
 * https://atcoder.jp/contests/abc214/tasks/abc214_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc214/submissions/37718452
 *
 * note:
 *
 *
 */

package contests.abc.abc21x.abc214.abc214_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    int ans = 4;
    if (n >= 126 && n <= 211) {
      ans = 6;
    }
    if (n >= 212) {
      ans = 8;
    }
    System.out.println(ans);
  }
}
