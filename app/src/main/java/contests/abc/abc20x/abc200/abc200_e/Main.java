/*
 * 京セラプログラミングコンテスト2021
 * （AtCoder Beginner Contest 200）
 * E - Patisserie ABC 2
 * https://atcoder.jp/contests/abc200/tasks/abc200_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc200/submissions/37783125
 *
 * note:
 * ほぼほぼ解説ACコードの写し
 *
 */

package contests.abc.abc20x.abc200.abc200_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final long k = Long.parseLong(st.nextToken());
    br.close();
    //dp[i][j]:=i個の整数を選んで、合計がjになる通り数
    final long[][] dp = new long[4][(3 * n) + 2];
    dp[0][0] = 1;
    for (int i = 1; i <= 3; i++) {
      for (int j = 0; j <= (i - 1) * n; j++) {
        dp[i][j + 1] += dp[i - 1][j];
        dp[i][j + n + 1] -= dp[i - 1][j];
      }
      for (int j = 1; j <= i * n; j++) {
        //いもす法
        dp[i][j] += dp[i][j - 1];
      }
    }
    long rem = k;
    //K番目の合計値を求める
    int sum = 0;
    for (int i = 3; i <= 3 * n; i++) {
      if (dp[3][i] < rem) {
        rem -= dp[3][i];
      } else {
        sum = i;
        break;
      }
    }
    for (int ans_i = 1; ans_i <= n; ans_i++) {
      int j_min = Math.max(1, sum - ans_i - n);
      int j_max = Math.min(n, sum - ans_i - 1);
      if (j_min > j_max) {
        continue;
      }
      if (j_max - j_min + 1 < rem) {
        rem -= j_max - j_min + 1;
        continue;
      } else {
        //Found
        int ans_j = j_min + (int) rem - 1;
        int ans_k = sum - ans_i - ans_j;
        System.out.println(ans_i + " " + ans_j + " " + ans_k);
        break;
      }
    }
  }
}
