/*
 * AtCoder Beginner Contest 244
 * D - Swap Hats
 * https://atcoder.jp/contests/abc244/tasks/abc244_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc244/submissions/35082903
 *
 * note:
 *
 */

package contests.abc.abc24x.abc244.abc244_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    final String t = br.readLine();
    br.close();
    int diff = 0;
    for (int i = 0; i < 6; i += 2) {
      if (s.charAt(i) != t.charAt(i)) {
        diff++;
      }
    }
    System.out.println(diff != 2 ? "Yes" : "No");
  }
}
