/*
 * ABC224
 * A - Tires
 * https://atcoder.jp/contests/abc224/tasks/abc224_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc224/submissions/26879642
 */
package contests.abc.abc224.abc224_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    br.close();
    System.out.println(
        s.endsWith("ist") ? s.substring(s.length() - 3) : s.substring(s.length() - 2));
  }
}
