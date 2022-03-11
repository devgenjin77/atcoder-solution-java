/*
 * Educational DP Contest / DP まとめコンテスト
 * B - Frog 2
 * https://atcoder.jp/contests/dp/tasks/dp_b
 *
 * verified:
 * - https://atcoder.jp/contests/dp/submissions/30008732
 *
 */
package contests.dp.dp_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] head = br.readLine().split(" ");
    int n = Integer.parseInt(head[0]);
    int k = Integer.parseInt(head[1]);
    String[] input_h = br.readLine().split(" ");
    br.close();
    int[] array_h = new int[n];
    for (int i = 0; i < n; i++) {
      array_h[i] = Integer.parseInt(input_h[i]);
    }
    int[] dp = new int[n];
    Arrays.fill(dp, Integer.MAX_VALUE);
    dp[0] = 0;
    for (int from = 0; from < n - 1; from++) {
      for (int dist = 1; dist <= k; dist++) {
        int to = from + dist;
        if (to < n) {
          dp[to] = Math.min(dp[from] + Math.abs(array_h[from] - array_h[to]), dp[to]);
        }
      }
    }
    System.out.println(dp[n - 1]);
  }
}
