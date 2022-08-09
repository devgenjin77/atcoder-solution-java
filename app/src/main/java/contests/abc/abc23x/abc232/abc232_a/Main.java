/*
 * M-SOLUTIONS プロコンオープン2021
 * （AtCoder Beginner Contest 232）
 * A - QQ solver
 * https://atcoder.jp/contests/abc232/tasks/abc232_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc232/submissions/33899546
 *
 * note:
 *
 *
 */

package contests.abc.abc23x.abc232.abc232_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    br.close();

    int a = s.charAt(0) - '0';
    int b = s.charAt(2) - '0';
    System.out.println(a * b);
  }
}
