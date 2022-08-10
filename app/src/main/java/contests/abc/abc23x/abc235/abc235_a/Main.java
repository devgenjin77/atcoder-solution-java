/*
 * HHKB プログラミングコンテスト 2022
 * （AtCoder Beginner Contest 235）
 * A - Rotate
 * https://atcoder.jp/contests/abc235/tasks/abc235_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc235/submissions/33917091
 *
 * note:
 * やるだけ
 *
 */

package contests.abc.abc23x.abc235.abc235_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String abc = br.readLine();
    br.close();
    int d = 0;
    for (int i = 0; i < 3; i++) {
      d += abc.charAt(i) - '0';
    }
    System.out.println((d * 100) + (d * 10) + d);
  }
}
