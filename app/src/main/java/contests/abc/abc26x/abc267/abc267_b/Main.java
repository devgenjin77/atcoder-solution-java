/*
 * NECプログラミングコンテスト2022
 * （AtCoder Beginner Contest 267）
 * B - Split?
 * https://atcoder.jp/contests/abc267/tasks/abc267_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc267/submissions/34599812
 *
 */

package contests.abc.abc26x.abc267.abc267_b;

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
    //スプリット判定
    if (s.charAt(0) == '1') {
      return false;
    }
    final int[] pin_to_col = {3, 2, 4, 1, 3, 5, 0, 2, 4, 6};
    final boolean[] cols = new boolean[7];
    int l = 10, r = -1;
    int cnt = 0;
    for (int i = 0; i < 10; i++) {
      if (s.charAt(i) == '1' && !cols[pin_to_col[i]]) {
        cols[pin_to_col[i]] = true;
        l = Math.min(pin_to_col[i], l);
        r = Math.max(pin_to_col[i], r);
        cnt++;
      }
    }
    return cnt > 0 && (r - l + 1) != cnt;
  }
}
