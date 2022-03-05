/*
 * ABC239
 * A - Horizon
 * https://atcoder.jp/contests/abc239/tasks/abc239_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc239/submissions/29851582
 *
 */
package contests.abc.abc239.abc239_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long h = Long.parseLong(br.readLine());
    br.close();
    System.out.println(solve(h));
  }

  static double solve(long h) {
    return Math.sqrt(h * (12_800_000L + h));
  }
}
