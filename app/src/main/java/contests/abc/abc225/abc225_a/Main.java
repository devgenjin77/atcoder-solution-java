/*
 * ABC225
 * A - Distinct Strings
 * https://atcoder.jp/contests/abc225/tasks/abc225_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc225/submissions/26938927
 */
package contests.abc.abc225.abc225_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    br.close();

    HashSet<Character> set = new HashSet<>();
    for (int i = 0; i < 3; i++) {
      set.add(s.charAt(i));
    }
    int ans = 0;
    switch (set.size()) {
      case 1:
        ans = 1;
        break;
      case 2:
        ans = 3;
        break;
      case 3:
        ans = 6;
        break;
      default:
        break;
    }
    System.out.println(ans);
  }
}
