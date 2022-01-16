/*
 * ABC153
 * E - Crested Ibis vs Monster
 * https://atcoder.jp/contests/abc153/tasks/abc153_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc153/submissions/28582263
 *
 */
package contests.abc.abc153.abc153_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static final int INF = Integer.MAX_VALUE / 2;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    StringTokenizer head = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(head.nextToken());
    int n = Integer.parseInt(head.nextToken());
    int[][] spell_info = new int[n][2];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      spell_info[i][0] = Integer.parseInt(st.nextToken());
      spell_info[i][1] = Integer.parseInt(st.nextToken());
    }
    br.close();

    int[] dp = new int[h + 1];
    Arrays.fill(dp, INF);
    dp[0] = 0;
    for (int hp = 0; hp < h; hp++) {
      if (dp[hp] == INF) {
        continue;
      }
      for (int m = 0; m < n; m++) {
        int next_hp = Math.min(hp + spell_info[m][0], h);
        dp[next_hp] = Math.min(dp[hp] + spell_info[m][1], dp[next_hp]);
        if (hp - spell_info[m][0] >= 0) {

        }
      }
    }
    System.out.println(dp[h]);
    return;
  }
}
