/*
 * M-SOLUTIONS プロコンオープン2021
 * （AtCoder Beginner Contest 232）
 * B - Caesar Cipher
 * https://atcoder.jp/contests/abc232/tasks/abc232_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc232/submissions/33900441
 *
 * note:
 *
 *
 */

package contests.abc.abc23x.abc232.abc232_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    final String t = br.readLine();
    br.close();
    int diff_0 = (t.charAt(0) - s.charAt(0) + 26) % 26;
    boolean isOk = true;
    for (int i = 1; i < s.length(); i++) {
      if ((t.charAt(i) - s.charAt(i) + 26) % 26 != diff_0) {
        isOk = false;
        break;
      }
    }
    System.out.println(isOk ? "Yes" : "No");
  }
}
