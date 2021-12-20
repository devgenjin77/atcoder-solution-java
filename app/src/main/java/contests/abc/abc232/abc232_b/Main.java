/*
 * ABC232
 * B - Caesar Cipher
 * https://atcoder.jp/contests/abc232/tasks/abc232_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc232/submissions/28039630
 */
package contests.abc.abc232.abc232_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    String t = br.readLine();
    br.close();
    System.out.println(solve(s, t) ? "Yes" : "No");
  }

  static boolean solve(String s, String t) {
    int k = ((t.charAt(0) - 'a') + 26 - (s.charAt(0) - 'a')) % 26;
    for (int i = 1; i < s.length(); i++) {
      int k2 = ((t.charAt(i) - 'a') + 26 - (s.charAt(i) - 'a')) % 26;
      if (k != k2) {
        return false;
      }
    }
    return true;
  }
}
