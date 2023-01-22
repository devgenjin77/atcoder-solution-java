/*
 * ウルシステムズプログラミングコンテスト2023
 * （AtCoder Beginner Contest 286）
 * D - Money in Hand
 * https://atcoder.jp/contests/abc286/tasks/abc286_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc286/submissions/38240227
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc286.abc286_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int x = Integer.parseInt(st.nextToken());
    final int[] array_a = new int[n];
    final int[] array_b = new int[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st_ab = new StringTokenizer(br.readLine());
      array_a[i] = Integer.parseInt(st_ab.nextToken());
      array_b[i] = Integer.parseInt(st_ab.nextToken());
    }
    br.close();
    //dp[i][j]:=i種類目までの硬貨でj円払えるか
    final boolean[][] dp = new boolean[n + 1][x + 1];
    dp[0][0] = true;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= x; j++) {
        if (!dp[i][j]) {
          continue;
        }
        for (int k = 0; k <= array_b[i]; k++) {
          int sum = j + (array_a[i] * k);
          if (sum > x) {
            break;
          } else {
            dp[i + 1][sum] = true;
          }
        }
      }
    }
    System.out.println(dp[n][x] ? "Yes" : "No");
  }
}
