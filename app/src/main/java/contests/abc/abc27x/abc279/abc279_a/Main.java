/*
 * トヨタシステムズプログラミングコンテスト2022
 * （AtCoder Beginner Contest 279）
 * A - wwwvvvvvv
 * https://atcoder.jp/contests/abc279/tasks/abc279_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc279/submissions/36844338
 *
 * note:
 *
 */

package contests.abc.abc27x.abc279.abc279_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    br.close();
    int ans = 0;
    for (int i = 0; i < s.length(); i++) {
      if(s.charAt(i) == 'w') {
        ans += 2;
      } else {
        ans += 1;
      }
    }
    System.out.println(ans);
  }
}
