/*
 * パナソニックグループプログラミングコンテスト2022
 * （AtCoder Beginner Contest 251）
 * A - Six Characters
 * https://atcoder.jp/contests/abc251/tasks/abc251_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc251/submissions/35162602
 *
 */

package contests.abc.abc25x.abc251.abc251_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    final StringBuilder sb = new StringBuilder(s);
    while (sb.length() < 6) {
      sb.append(s);
    }
    System.out.println(sb);
  }
}
