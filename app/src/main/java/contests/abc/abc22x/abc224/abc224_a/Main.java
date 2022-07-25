/*
 * AtCoder Beginner Contest 224
 * A - Tires
 * https://atcoder.jp/contests/abc224/tasks/abc224_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc224/submissions/33521525
 *
 * note:
 * endsWithメソッドで末尾を判定する
 *
 */

package contests.abc.abc22x.abc224.abc224_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    br.close();
    if (s.endsWith("er")) {
      System.out.println("er");
    } else if (s.endsWith("ist")) {
      System.out.println("ist");
    }
  }
}
