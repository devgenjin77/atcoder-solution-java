/*
 * トヨタシステムズプログラミングコンテスト2022
 * （AtCoder Beginner Contest 279）
 * B - LOOKUP
 * https://atcoder.jp/contests/abc279/tasks/abc279_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc279/submissions/36844243
 *
 * note:
 *
 */

package contests.abc.abc27x.abc279.abc279_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    final String t = br.readLine();
    br.close();
    System.out.println(s.contains(t) ? "Yes" : "No");
  }
}
