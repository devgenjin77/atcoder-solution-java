/*
 * ユニークビジョンプログラミングコンテスト2022
 * （AtCoder Beginner Contest 248）
 * A - Lacked Number
 * https://atcoder.jp/contests/abc248/tasks/abc248_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc248/submissions/31067238
 *
 */

package contests.abc.abc248.abc248_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    br.close();
    int ans = 45;
    for (int i = 0; i < s.length(); i++) {
      ans -= s.charAt(i) - '0';
    }
    System.out.println(ans);
  }
}
