/*
 * モノグサプログラミングコンテスト2022
 * （AtCoder Beginner Contest 249）
 * B - Perfect String
 * https://atcoder.jp/contests/abc249/tasks/abc249_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc249/submissions/34093653
 *
 * note:
 *
 *
 */

package contests.abc.abc24x.abc249.abc249_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    br.close();
    boolean isWonderful = true;
    final int[][] ch_cnt = new int[2][26];
    int cnt_upper = 0, cnt_lower = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if ('A' <= ch && ch <= 'Z') {
        cnt_upper++;
        if (ch_cnt[0][ch - 'A']++ > 0) {
          isWonderful = false;
          break;
        }
      } else {
        cnt_lower++;
        if (ch_cnt[1][ch - 'a']++ > 0) {
          isWonderful = false;
          break;
        }
      }
    }
    isWonderful = isWonderful && cnt_upper > 0 && cnt_lower > 0;
    System.out.println(isWonderful ? "Yes" : "No");
  }
}
