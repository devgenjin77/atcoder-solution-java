/*
 * NECプログラミングコンテスト2021
 * （AtCoder Beginner Contest 229）
 * D - Longest X
 * https://atcoder.jp/contests/abc229/tasks/abc229_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc229/submissions/33884158
 *
 * note:
 * 尺取り法をつかう
 *
 */

package contests.abc.abc22x.abc229.abc229_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    final int k = Integer.parseInt(br.readLine());
    final int n = s.length();
    br.close();
    int ans = 0, cnt = 0, r = 0;
    //尺取法
    for (int l = 0; l < s.length(); l++) {
      while (r < s.length() && cnt <= k) {
        if (s.charAt(r) == '.') {
          cnt++;
        }
        if (cnt <= k) {
          ans = Math.max(r - l + 1, ans);
        }
        r++;
      }
      if (s.charAt(l) == '.') {
        cnt--;
      }
    }
    System.out.println(ans);
  }
}
