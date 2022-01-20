/*
 * ABC154
 * E - Almost Everywhere Zero
 * https://atcoder.jp/contests/abc154/tasks/abc154_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc154/submissions/28651833
 *
 */
package contests.abc.abc154.abc154_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String n = br.readLine();
    int k = Integer.parseInt(br.readLine());
    br.close();
    //dp[i][smaller][j]
    //i桁目まで確定させて、
    //smaller=0の場合、Nと同じ、
    //j個0以外の数字を使っている
    int[][][] dp = new int[n.length() + 1][2][k + 1];
    dp[0][0][0] = 1;
    for (int i = 0; i < n.length(); i++) {
      int next_i = i + 1;
      int now_d = n.charAt(i) - '0';
      for (int smaller = 0; smaller <= 1; smaller++) {
        for (int j = 0; j <= k; j++) {
          for (int tmp_d = 0; tmp_d < 10; tmp_d++) {
            int next_s = smaller;
            int next_j = tmp_d == 0 ? j : j + 1;
            if (next_j > k) {
              continue;
            }
            if (smaller == 0) {
              if (tmp_d > now_d) {
                continue;
              } else if (tmp_d < now_d) {
                next_s = 1;
              }
            }
            dp[next_i][next_s][next_j] += dp[i][smaller][j];
          }
        }
      }
    }
    System.out.println(dp[n.length()][0][k] + dp[n.length()][1][k]);
    return;
  }
}
