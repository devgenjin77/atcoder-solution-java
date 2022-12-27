/*
 * ユニークビジョンプログラミングコンテスト2022 冬
 * （AtCoder Beginner Contest 283）
 * C - Cash Register
 * https://atcoder.jp/contests/abc283/tasks/abc283_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc283/submissions/37582500
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc283.abc283_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    int cnt00 = 0;
    boolean prev0 = false;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '0') {
        if (prev0) {
          cnt00++;
        }
        prev0 = !prev0;
      } else {
        prev0 = false;
      }
    }
    br.close();
    System.out.println(s.length() - cnt00);
  }
}
