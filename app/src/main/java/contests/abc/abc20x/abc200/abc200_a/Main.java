/*
 * 京セラプログラミングコンテスト2021
 * （AtCoder Beginner Contest 200）
 * A - Century
 * https://atcoder.jp/contests/abc200/tasks/abc200_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc200/submissions/37773806
 *
 * note:
 *
 *
 */

package contests.abc.abc20x.abc200.abc200_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    System.out.println((n + 99) / 100);
  }
}
