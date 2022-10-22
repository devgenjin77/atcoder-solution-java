/*
 * 京セラプログラミングコンテスト2022
 * （AtCoder Beginner Contest 271）
 * A - 484558
 * https://atcoder.jp/contests/abc271/tasks/abc271_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc271/submissions/35853233
 *
 */

package contests.abc.abc27x.abc271.abc271_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    System.out.println(String.format("%02X", n));
  }
}
