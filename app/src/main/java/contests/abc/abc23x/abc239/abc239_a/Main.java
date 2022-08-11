/*
 * デンソークリエイトプログラミングコンテスト2022
 * （AtCoder Beginner Contest 239）
 * A - Horizon
 * https://atcoder.jp/contests/abc239/tasks/abc239_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc239/submissions/33945654
 *
 * note:
 *
 *
 */

package contests.abc.abc23x.abc239.abc239_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final long h = Long.parseLong(br.readLine());
    br.close();
    System.out.println(Math.sqrt(h * (12800000l + h)));
  }
}
