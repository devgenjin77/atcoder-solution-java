/*
 * サイシードプログラミングコンテスト2021
 * （AtCoder Beginner Contest 219）
 * B - Maritozzo
 * https://atcoder.jp/contests/abc219/tasks/abc219_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc219/submissions/33399192
 *
 * note:
 *
 */

package contests.abc.abc21x.abc219.abc219_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String[] arr_s = new String[3];
    for (int i = 0; i < 3; i++) {
      arr_s[i] = br.readLine();
    }
    final String t = br.readLine();
    br.close();
    StringBuilder sb_ans = new StringBuilder();
    for (int i = 0; i < t.length(); i++) {
      sb_ans.append(arr_s[t.charAt(i) - '1']);
    }
    System.out.println(sb_ans);
  }
}
