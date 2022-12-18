/*
 * HHKBプログラミングコンテスト2022 Winter
 * （AtCoder Beginner Contest 282）
 * A - Generalized ABC
 * https://atcoder.jp/contests/abc282/tasks/abc282_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc282/submissions/37372770
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc282.abc282_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int k = Integer.parseInt(br.readLine());
    br.close();
    System.out.println(ALPHABET.substring(0, k));
  }
}
