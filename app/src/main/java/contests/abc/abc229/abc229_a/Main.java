/*
 * ABC229
 * A - First Grid
 * https://atcoder.jp/contests/abc229/tasks/abc229_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc229/submissions/27559296
 */
package contests.abc.abc229.abc229_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s1 = br.readLine();
    String s2 = br.readLine();
    br.close();
    String s = new StringBuilder().append(s1).append(s2).toString();
    if ("#..#".equals(s) || ".##.".equals(s)) {
      System.out.println("No");
    } else {
      System.out.println("Yes");
    }
  }
}
