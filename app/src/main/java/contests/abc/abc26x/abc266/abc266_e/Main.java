/*
 * AtCoder Beginner Contest 266
 * E - Throwing the Die
 * https://atcoder.jp/contests/abc266/tasks/abc266_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc266/submissions/35017160
 *
 * note:
 **
 */

package contests.abc.abc26x.abc266.abc266_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    final double[] dp = new double[n + 1];
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      double sum = 0.0;
      for (int j = 1; j <= 6; j++) {
        sum += Math.max(j * 1.0, dp[i - 1]);
      }
      dp[i] = sum / 6;
    }
    System.out.println(dp[n]);
  }
}
