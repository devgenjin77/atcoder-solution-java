/*
 * ABC237
 * C - kasaka
 * https://atcoder.jp/contests/abc237/tasks/abc237_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc237/submissions/28977336
 *
 */
package contests.abc.abc237.abc237_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    br.close();
    System.out.println(solve(s) ? "Yes" : "No");
  }

  static boolean solve(String s) {
    int idx_left = 0;
    int idx_right = s.length();
    while (idx_left < s.length()) {
      if (s.charAt(idx_left) == 'a') {
        idx_left++;
      } else {
        break;
      }
    }
    if (idx_left == s.length()) {
      return true;
    }
    while (idx_right > 0) {
      if (s.charAt(idx_right - 1) == 'a') {
        idx_right--;
      } else {
        break;
      }
    }
    if (idx_left > s.length() - idx_right) {
      return false;
    }
    String s2 = s.substring(idx_left, idx_right);
    return s2.equals(new StringBuilder(s2).reverse().toString());
  }
}
