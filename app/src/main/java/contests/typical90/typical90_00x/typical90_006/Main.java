/*
 * 競プロ典型90問
 * 006 - Smallest Subsequence（★5）
 * https://atcoder.jp/contests/typical90/tasks/typical90_f
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31828704
 *
 * note:
 * 辞書順最小を貪欲法で求める
 */

package contests.typical90.typical90_00x.typical90_006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    String s = br.readLine();
    br.close();

    //dp[i][j]:=i文字目以降に文字jが初めて現れる位置
    int[][] dp = new int[n + 1][26];
    for (int j = 0; j < 26; j++) {
      dp[n][j] = n;
    }
    for (int i = n - 1; i >= 0; i--) {
      for (int j = 0; j < 26; j++) {
        dp[i][j] = dp[i + 1][j];
      }
      int ch = s.charAt(i) - 'a';
      dp[i][ch] = i;
    }
    StringBuilder sb = new StringBuilder();
    int idx = 0;
    for (int i = 0; i < k; i++) {
      for (int j = 0; j < 26; j++) {
        if (dp[idx][j] <= n - k + i) {
          sb.append((char) ('a' + j));
          idx = dp[idx][j] + 1;
          break;
        }
      }
    }
    System.out.println(sb.toString());
  }
}
