/*
 * モノグサプログラミングコンテスト2022
 * （AtCoder Beginner Contest 238）
 * A - Exponential or Quadratic
 * https://atcoder.jp/contests/abc238/tasks/abc238_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc238/submissions/31430256
 *
 */

package contests.abc.abc238.abc238_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.close();
    System.out.println(!(n >= 2 && n <= 4) ? "Yes" : "No");
  }
}
