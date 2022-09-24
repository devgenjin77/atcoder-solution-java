/*
 * AtCoder Beginner Contest 244
 * A - Last Letter
 * https://atcoder.jp/contests/abc244/tasks/abc244_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc244/submissions/35081918
 *
 * note:
 *
 */

package contests.abc.abc24x.abc244.abc244_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String s = br.readLine();
    br.close();
    System.out.println(s.charAt(n - 1));
  }
}
