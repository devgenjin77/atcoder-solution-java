/*
 * AtCoder Beginner Contest 237
 * A - Not Overflow
 * https://atcoder.jp/contests/abc237/tasks/abc237_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc237/submissions/33926096
 *
 * note:
 *
 *
 */

package contests.abc.abc23x.abc237.abc237_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  final static long MAX = 1l << 31;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final long n = Long.parseLong(br.readLine());
    br.close();
    System.out.println(-MAX <= n && n < MAX ? "Yes" : "No");
  }
}
