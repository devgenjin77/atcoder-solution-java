/*
 * パナソニックプログラミングコンテスト2021
 * （AtCoder Beginner Contest 231）
 * A - Water Pressure
 * https://atcoder.jp/contests/abc231/tasks/abc231_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc231/submissions/33897460
 *
 * note:
 *
 *
 */

package contests.abc.abc23x.abc231.abc231_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int d = Integer.parseInt(br.readLine());
    br.close();
    System.out.println(d / 100.0);
  }
}
