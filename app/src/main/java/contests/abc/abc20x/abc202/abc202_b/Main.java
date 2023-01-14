/*
 * エイシングプログラミングコンテスト2021
 * （AtCoder Beginner Contest 202）
 * B - 180°
 * https://atcoder.jp/contests/abc202/tasks/abc202_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc202/submissions/37997878
 *
 * note:
 *
 *
 */

package contests.abc.abc20x.abc202.abc202_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    br.close();
    final String conv1 = "01689";
    final String conv2 = "01986";
    final StringBuilder ans = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      ans.append(conv2.charAt(conv1.indexOf(c)));
    }
    System.out.println(ans.reverse());
  }
}
