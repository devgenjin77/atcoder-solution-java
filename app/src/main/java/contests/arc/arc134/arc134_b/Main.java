/*
 * ARC134
 * B - Reserve or Reverse
 * https://atcoder.jp/contests/arc134/tasks/arc134_b
 *
 * verified:
 * - https://atcoder.jp/contests/arc134/submissions/29390649
 *
 */
package contests.arc.arc134.arc134_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();
    br.close();

    int[][] dp = new int[n][26];
    for (int i = 0; i < n; i++) {
      for (int a = 0; a < 26; a++) {
        dp[i][a] = i == 0 ? -1 : dp[i - 1][a];
      }
      dp[i][s.charAt(i) - 'a'] = i;
    }
    StringBuilder sb = new StringBuilder(s);
    int idx_left = 0, idx_right = n - 1;
    while (idx_left < idx_right) {
      int ch_left = s.charAt(idx_left) - 'a';
      for (int ch_right = 0; ch_right < ch_left; ch_right++) {
        int idx_ch_right = dp[idx_right][ch_right];
        if (idx_ch_right > idx_left) {
          // swap
          sb.setCharAt(idx_left, s.charAt(idx_ch_right));
          sb.setCharAt(idx_ch_right, s.charAt(idx_left));
          idx_right = idx_ch_right - 1;
          break;
        }
      }
      idx_left++;
    }
    System.out.println(sb.toString());
  }
}
