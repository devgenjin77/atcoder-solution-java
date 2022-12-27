/*
 * ユニークビジョンプログラミングコンテスト2022 冬
 * （AtCoder Beginner Contest 283）
 * D - Scope
 * https://atcoder.jp/contests/abc283/tasks/abc283_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc283/submissions/37583837
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc283.abc283_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    br.close();
    final boolean[] tbl_all = new boolean[26];
    final boolean[][] tbl_wk = new boolean[26][(s.length() / 2) + 1];
    int level = 0;
    boolean isOk = true;
    main_loop:
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '(') {
        level++;
      } else if (c == ')') {
        for (int k = 0; k < 26; k++) {
          if (tbl_wk[k][level]) {
            tbl_all[k] = false;
            tbl_wk[k][level] = false;
          }
        }
        level--;
      } else {
        int idx = c - 'a';
        if (tbl_all[idx]) {
          isOk = false;
          break main_loop;
        } else {
          tbl_all[idx] = true;
          tbl_wk[idx][level] = true;
        }
      }
    }
    System.out.println(isOk ? "Yes" : "No");
  }
}
