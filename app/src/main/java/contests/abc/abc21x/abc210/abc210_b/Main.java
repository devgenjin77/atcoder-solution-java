/*
 * AtCoder Beginner Contest 210
 * B - Bouzu Mekuri
 * https://atcoder.jp/contests/abc210/tasks/abc210_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc210/submissions/37699037
 *
 * note:
 *
 *
 */

package contests.abc.abc21x.abc210.abc210_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String s = br.readLine();
    br.close();
    final int fitst1 = s.indexOf('1', 0);
    System.out.println(fitst1 % 2 == 0 ? "Takahashi" : "Aoki");
  }
}
