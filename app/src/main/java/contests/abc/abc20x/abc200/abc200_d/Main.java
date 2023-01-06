/*
 * 京セラプログラミングコンテスト2021
 * （AtCoder Beginner Contest 200）
 * D - Happy Birthday! 2
 * https://atcoder.jp/contests/abc200/tasks/abc200_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc200/submissions/37768367
 *
 * note:
 *
 *
 */

package contests.abc.abc20x.abc200.abc200_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    boolean isOK = false;
    final String[][] dp = new String[n][200];
    dp[0][array_a[0] % 200] = "1";
    String all_not_sel = "0";
    String ans1 = null, ans2 = null;
    main_loop:
    for (int i = 1; i < n; i++) {
      dp[i][array_a[i] % 200] = all_not_sel + "1";
      all_not_sel += "0";
      for (int j = 0; j < 200; j++) {
        if (dp[i - 1][j] != null) {
          //選ぶ
          String sel = dp[i - 1][j] + "1";
          int next = (j + array_a[i]) % 200;
          if (dp[i][next] != null) {
            ans1 = dp[i][next];
            ans2 = sel;
            isOK = true;
            break main_loop;
          } else {
            dp[i][next] = sel;
          }
          //選ばない
          String not_sel = dp[i - 1][j] + "0";
          if (dp[i][j] != null) {
            ans1 = dp[i][j];
            ans2 = not_sel;
            isOK = true;
            break main_loop;
          } else {
            dp[i][j] = not_sel;
          }
        }
      }
    }
    final PrintWriter pw = new PrintWriter(System.out);
    if (isOK) {
      pw.println("Yes");
      List<Integer> list_b = toIndexList(ans1);
      List<Integer> list_c = toIndexList(ans2);
      StringBuilder sb_b = new StringBuilder();
      sb_b.append(list_b.size()).append(' ');
      for (Integer i_b : list_b) {
        sb_b.append(i_b + 1).append(' ');
      }
      pw.println(sb_b.deleteCharAt(sb_b.length() - 1));
      StringBuilder sb_c = new StringBuilder();
      sb_c.append(list_c.size()).append(' ');
      for (Integer i_c : list_c) {
        sb_c.append(i_c + 1).append(' ');
      }
      pw.println(sb_c.deleteCharAt(sb_c.length() - 1));
    } else {
      pw.println("No");
    }
    pw.close();
  }

  static List<Integer> toIndexList(String str) {
    List<Integer> ret = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '1') {
        ret.add(i);
      }
    }
    return ret;
  }
}
