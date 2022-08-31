/*
 * AtCoder Beginner Contest 266
 * A - Middle Letter
 * https://atcoder.jp/contests/abc266/tasks/abc266_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc266/submissions/34479088
 *
 * note:
 *
 *
 */

package contests.abc.abc26x.abc266.abc266_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    System.out.println(s.charAt(s.length() / 2));
  }
}
