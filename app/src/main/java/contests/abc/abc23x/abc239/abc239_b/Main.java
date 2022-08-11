/*
 * デンソークリエイトプログラミングコンテスト2022
 * （AtCoder Beginner Contest 239）
 * B - Integer Division
 * https://atcoder.jp/contests/abc239/tasks/abc239_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc239/submissions/33945970
 *
 * note:
 *
 *
 */

package contests.abc.abc23x.abc239.abc239_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final long x = Long.parseLong(br.readLine());
    br.close();
    if (x > 0) {
      System.out.println(x / 10);
    } else {
      System.out.println((x - 9) / 10);
    }
  }
}
