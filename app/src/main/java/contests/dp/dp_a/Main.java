/*
 * Educational DP Contest / DP まとめコンテスト
 * A - Frog 1
 * https://atcoder.jp/contests/dp/tasks/dp_a
 *
 * verified:
 * - https://atcoder.jp/contests/dp/submissions/28496992
 *
 */
package contests.dp.dp_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    int[] array_h = new int[n];
    for (int i = 0; i < n; i++) {
      array_h[i] = Integer.parseInt(st.nextToken());
    }
    int[] dp = new int[n];
    dp[0] = 0;
    dp[1] = Math.abs(array_h[0] - array_h[1]);
    for (int i = 2; i < n; i++) {
      int mv1 = dp[i - 1] + Math.abs(array_h[i - 1] - array_h[i]);
      int mv2 = dp[i - 2] + Math.abs(array_h[i - 2] - array_h[i]);
      dp[i] = Math.min(mv1, mv2);
    }
    System.out.println(dp[n - 1]);
  }
}
