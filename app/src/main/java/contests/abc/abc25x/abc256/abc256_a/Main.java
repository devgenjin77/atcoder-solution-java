/*
 * 東京海上日動プログラミングコンテスト2022
 * （AtCoder Beginner Contest 256）
 * A - 2^N
 * https://atcoder.jp/contests/abc256/tasks/abc256_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc256/submissions/38157948
 *
 */

package contests.abc.abc25x.abc256.abc256_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    System.out.println(1 << n);
  }
}
