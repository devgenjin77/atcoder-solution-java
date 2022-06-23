/*
 * AtCoder Beginner Contest 218
 * A - Weather Forecast
 * https://atcoder.jp/contests/abc218/tasks/abc218_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc218/submissions/32678035
 *
 */

package contests.abc.abc21x.abc218.abc218_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String s = br.readLine();
    br.close();
    System.out.println(s.charAt(n - 1) == 'o' ? "Yes" : "No");
  }
}
