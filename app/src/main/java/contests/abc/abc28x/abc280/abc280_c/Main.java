/*
 * デンソークリエイトプログラミングコンテスト2022
 * （AtCoder Beginner Contest 280）
 * C - Extra Character
 * https://atcoder.jp/contests/abc280/tasks/abc280_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc280/submissions/37062736
 *
 * note:
 * - S_i != T_i となるiを探す
 * - 計算量はO(N)
 *
 */

package contests.abc.abc28x.abc280.abc280_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    final String t = br.readLine();
    br.close();
    int ans = t.length();
    for(int i = 0; i < s.length(); i++) {
      if(s.charAt(i) != t.charAt(i)) {
        ans = i + 1;
        break;
      }
    }
    System.out.println(ans);
  }
}
