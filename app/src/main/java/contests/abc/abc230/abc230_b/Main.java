/*
 * ABC230
 * B - Triple Metre
 * https://atcoder.jp/contests/abc230/tasks/abc230_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc230/submissions/27709622
 */
package contests.abc.abc230.abc230_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    br.close();

    System.out.println(solve(s) ? "Yes" : "No");
  }

  static boolean solve(String s) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'o') {
        set.add(i % 3);
      }
    }
    return set.size() == 1 || (set.size() == 0 && s.length() <= 2);
  }
}
