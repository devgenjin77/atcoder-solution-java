/*
 * AtCoder Beginner Contest 281
 * B - Sandwich Number
 * https://atcoder.jp/contests/abc281/tasks/abc281_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc281/submissions/37216339
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc281.abc281_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    br.close();
    System.out.println(solve(s) ? "Yes" : "No");
  }

  static boolean solve(String s) {
    if (s.length() != 8) {
      return false;
    }
    if (!(s.charAt(0) >= 'A' && s.charAt(0) <= 'Z' && s.charAt(7) >= 'A' && s.charAt(7) <= 'Z')) {
      return false;
    }
    try {
      int n = Integer.parseInt(s.substring(1, 7));
      if (n < 100000) {
        return false;
      }
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }
}
