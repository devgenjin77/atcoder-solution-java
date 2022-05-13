/*
 * ABC212
 * B - Weak Password
 * https://atcoder.jp/contests/abc212/tasks/abc212_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc212/submissions/31640389
 */

package contests.abc.abc21x.abc212.abc212_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String x = br.readLine();
    br.close();
    System.out.println(isWeakPassword(x) ? "Weak" : "Strong");
  }

  static boolean isWeakPassword(String pwd) {
    int diff_0 = 0, diff_1 = 0;
    for (int i = 1; i < pwd.length(); i++) {
      int diff = (pwd.charAt(i) + 10 - pwd.charAt(i - 1)) % 10;
      if (diff == 0) {
        diff_0++;
      } else if (diff == 1) {
        diff_1++;
      } else {
        return false;
      }
    }
    if (diff_0 == 3 || diff_1 == 3) {
      return true;
    } else {
      return false;
    }
  }
}
