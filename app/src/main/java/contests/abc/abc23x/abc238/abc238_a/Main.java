/*
 * モノグサプログラミングコンテスト2022
 * （AtCoder Beginner Contest 238）
 * A - Rotate
 * https://atcoder.jp/contests/abc238/tasks/abc238_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc238/submissions/33936104
 *
 * note:
 * 筆算すると、N=2,3,4の場合のみNoとなる
 *
 */

package contests.abc.abc23x.abc238.abc238_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    System.out.println(n == 1 || n >= 5 ? "Yes" : "No");
  }
}
