/*
 * AtCoder Beginner Contest 215
 * A - Your First Judge
 * https://atcoder.jp/contests/abc215/tasks/abc215_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc215/submissions/32429395
 *
 */

package contests.abc.abc21x.abc215.abc215_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    br.close();
    System.out.println("Hello,World!".equals(s) ? "AC" : "WA");
  }
}
