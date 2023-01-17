/*
 * AtCoder Beginner Contest 252
 * C - Slot Strategy
 * https://atcoder.jp/contests/abc252/tasks/abc252_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc252/submissions/38123580
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc252.abc252_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String[] slot = new String[n];
    for (int i = 0; i < n; i++) {
      slot[i] = br.readLine();
    }
    br.close();
    int ans = Integer.MAX_VALUE;
    int[] stop_mod = new int[10];
    for (int num = 0; num < 10; num++) {
      Arrays.fill(stop_mod, 0);
      int wk_ans = 0;
      for (int i = 0; i < n; i++) {
        //numを止めるための秒数
        int stop = slot[i].indexOf((char) ('0' + num));
        wk_ans = Math.max(stop + (stop_mod[stop] * 10), wk_ans);
        stop_mod[stop]++;
      }
      ans = Math.min(wk_ans, ans);
    }
    System.out.println(ans);
  }
}
