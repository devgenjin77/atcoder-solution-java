/*
 * エイシングプログラミングコンテスト2021
 * （AtCoder Beginner Contest 202）
 * D - aab aba baa
 * https://atcoder.jp/contests/abc202/tasks/abc202_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc202/submissions/38030545
 *
 * note:
 *
 *
 */

package contests.abc.abc20x.abc202.abc202_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int a = Integer.parseInt(st.nextToken());
    final int b = Integer.parseInt(st.nextToken());
    final long k = Long.parseLong(st.nextToken());
    br.close();
    final long[][] dp = new long[a + 1][b + 1];
    //aをi個、bをj個からなる文字列の数
    dp[0][0] = 1;
    for (int i = 0; i <= a; i++) {
      for (int j = 0; j <= b; j++) {
        if (i > 0) {
          dp[i][j] += dp[i - 1][j];
        }
        if (j > 0) {
          dp[i][j] += dp[i][j - 1];
        }
      }
    }
    final StringBuilder sb = new StringBuilder();
    int rem_a = a, rem_b = b;
    long rem_k = k;
    for (int i = 0; i < a + b; i++) {
      if (rem_a == 0) {
        sb.append('b');
        rem_b--;
      } else if (rem_b == 0) {
        sb.append('a');
        rem_a--;
      } else {
        //現在位置をaで決めたときに、残りパターンがどの程度あるか
        long use_k = dp[rem_a - 1][rem_b];
        if (use_k >= rem_k) {
          sb.append('a');
          rem_a--;
        } else {
          rem_k -= use_k;
          sb.append('b');
          rem_b--;
        }
      }
    }
    System.out.println(sb);
  }
}
