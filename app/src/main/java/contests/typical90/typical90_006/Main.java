/*
 * 競プロ典型90問
 * 006 - Smallest Subsequence（★5）
 * https://atcoder.jp/contests/typical90/tasks/typical90_f
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/29127935
 *
 */
package contests.typical90.typical90_006;

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
    if (n == k) {
      System.out.println(s);
      return;
    }
    //tbl_char[i][j]:=i文字目より右で、文字jが存在する最近の位置
    int[][] tbl_char = new int[n][26];
    for (int a = 0; a < 26; a++) {
      tbl_char[n - 1][a] = Integer.MAX_VALUE;
    }
    tbl_char[n - 1][s.charAt(n - 1) - 'a'] = n - 1;
    for (int idx = n - 2; idx >= 0; idx--) {
      for (int a = 0; a < 26; a++) {
        tbl_char[idx][a] = tbl_char[idx + 1][a];
      }
      tbl_char[idx][s.charAt(idx) - 'a'] = idx;
    }
    StringBuilder sb = new StringBuilder();
    int cur_idx = 0;
    while (sb.length() < k) {
      int r = n - (k - sb.length());
      for (int a = 0; a < 26; a++) {
        if (tbl_char[cur_idx][a] <= r) {
          sb.append((char) ('a' + a));
          cur_idx = tbl_char[cur_idx][a] + 1;
          break;
        }
      }
    }
    System.out.println(sb.toString());
  }
}
