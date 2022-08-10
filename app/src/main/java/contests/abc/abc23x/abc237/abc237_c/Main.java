/*
 * AtCoder Beginner Contest 237
 * C - kasaka
 * https://atcoder.jp/contests/abc237/tasks/abc237_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc237/submissions/33927109
 *
 * note:
 *
 *
 */

package contests.abc.abc23x.abc237.abc237_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    br.close();
    System.out.println(solve(s) ? "Yes" : "No");
  }

  static boolean solve(String s) {
    int cnt_l = 0, cnt_r = 0;
    while (cnt_l < s.length()) {
      if (s.charAt(cnt_l) == 'a') {
        cnt_l++;
      } else {
        break;
      }
    }
    if (cnt_l == s.length()) {
      //全部aの場合
      return true;
    }
    while (cnt_r < s.length()) {
      if (s.charAt(s.length() - 1 - cnt_r) == 'a') {
        cnt_r++;
      } else {
        break;
      }
    }
    if (cnt_l > cnt_r) {
      //左のa連続が多いので、左にaを足しても無駄
      return false;
    }
    int len = s.length() - cnt_l - cnt_r;
    for(int i = 0; i < len; i++) {
      if(s.charAt(cnt_l + i) != s.charAt(len + cnt_l - 1 - i)) {
        return false;
      }
    }
    return true;
  }
}
