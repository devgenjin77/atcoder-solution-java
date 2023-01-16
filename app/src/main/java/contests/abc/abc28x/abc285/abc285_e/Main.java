/*
 * AtCoder Beginner Contest 285
 * E - Work or Rest
 * https://atcoder.jp/contests/abc285/tasks/abc285_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc285/submissions/38098326
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc285.abc285_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final long[] array_a = new long[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
    }
    br.close();
    //前の休日がi日の時の生産量の合計
    final long[] array_b = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      array_b[i] = array_b[i - 1] + array_a[(i - 1) / 2];
    }
    //dp[i]:=i日目を休日にしたときの最大生産量
    final long[] dp = new long[n + 1];
    for (int now = 1; now <= n; now++) {
      for (int prev = 0; prev < now; prev++) {
        dp[now] = Math.max(dp[prev] + array_b[now - prev - 1], dp[now]);
      }
    }
    System.out.println(dp[n]);
  }
}
