/*
 * 第三回日本最強プログラマー学生選手権-予選-
 * （AtCoder Beginner Contest 262）
 * D - I Hate Non-integer Number
 * https://atcoder.jp/contests/abc262/tasks/abc262_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc262/submissions/35966297
 *
 */

package contests.abc.abc26x.abc262.abc262_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static final long MOD = 998244353;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final int[] array_a = new int[n];
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    long ans = 0;
    for (int x = 1; x <= n; x++) {
      //dp[i][j]:=i個使って、合計値のmod_xがjになる通り数
      long[][] dp = new long[x + 1][x];
      dp[0][0] = 1;
      for (int i = 0; i < n; i++) {
        int a_modx = array_a[i] % x;
        for (int j = Math.min(x, i + 1); j >= 1; j--) {
          for (int mod_x = 0; mod_x < x; mod_x++) {
            dp[j][mod_x] += dp[j - 1][(x + mod_x - a_modx) % x];
            dp[j][mod_x] %= MOD;
          }
        }
      }
      ans += dp[x][0];
      ans %= MOD;
    }
    System.out.println(ans);
  }
}
