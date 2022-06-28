/*
 * AtCoder Beginner Contest 220
 * D - FG operation
 * https://atcoder.jp/contests/abc220/tasks/abc220_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc220/submissions/32820881
 *
 */

package contests.abc.abc22x.abc220.abc220_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  final static long MOD = 998244353;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final int[] array_a = new int[n];
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();

    long[][] dp = new long[n][10];
    dp[0][array_a[0]] = 1;

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < 10; j++) {
        if (dp[i - 1][j] > 0) {
          int f = (j + array_a[i]) % 10;
          int g = (j * array_a[i]) % 10;
          dp[i][f] += dp[i - 1][j];
          dp[i][f] %= MOD;
          dp[i][g] += dp[i - 1][j];
          dp[i][g] %= MOD;
        }
      }
    }
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < 10; i++) {
      pw.println(dp[n - 1][i]);
    }
    pw.close();
  }
}
