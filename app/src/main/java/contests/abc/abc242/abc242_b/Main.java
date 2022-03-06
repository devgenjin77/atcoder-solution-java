/*
 * ABC242
 * B - Minimize Ordering
 * https://atcoder.jp/contests/abc242/tasks/abc242_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc242/submissions/29924530
 *
 */
package contests.abc.abc242.abc242_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    br.close();
    char[] c_s = s.toCharArray();
    Arrays.sort(c_s);
    System.out.println(c_s);
  }
}
