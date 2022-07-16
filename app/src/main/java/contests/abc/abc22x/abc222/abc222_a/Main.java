/*
 * エクサウィザーズプログラミングコンテスト2021
 * （AtCoder Beginner Contest 222）
 * A - Find Multiple
 * https://atcoder.jp/contests/abc222/tasks/abc222_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc222/submissions/33249269
 *
 * note:
 * %04dとフォーマット出力することで、ゼロパディングを行う
 */

package contests.abc.abc22x.abc222.abc222_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    System.out.println(String.format("%04d", n));
  }
}
