/*
 * 競プロ典型90問
 * 002 - Encyclopedia of Parentheses（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_b
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/27003277
 *
 */
package contests.typical90.typical90_002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  static PrintWriter pw;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.close();

    if (n % 2 == 0) {
      pw = new PrintWriter(System.out);
      char[] buff = new char[n];
      solve(0, 0, buff);
      pw.flush();
    }
  }

  static void solve(int l_cnt, int r_cnt, char[] buff) {
    int cur_pos = l_cnt + r_cnt;
    int max = buff.length;
    if (cur_pos == max) {
      pw.println(buff);
      return;
    }
    if (l_cnt < max / 2) {
      buff[cur_pos] = '(';
      solve(l_cnt + 1, r_cnt, buff);
    }
    if (l_cnt > r_cnt) {
      buff[cur_pos] = ')';
      solve(l_cnt, r_cnt + 1, buff);
    }
  }
}
