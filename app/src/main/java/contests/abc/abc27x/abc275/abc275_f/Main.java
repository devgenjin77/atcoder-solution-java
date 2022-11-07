/*
 * AtCoder Beginner Contest 275
 * F - Erase Subarrays
 * https://atcoder.jp/contests/abc275/tasks/abc275_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc275/submissions/36311771
 *
 * note:
 * 3次元配列でやると遅かった。。
 *
 */

package contests.abc.abc27x.abc275.abc275_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static final int INF = Integer.MAX_VALUE / 2;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    //dp0[i][j]:=i個まで見て合計jを作る。最後のi番目を使わない時の最小の操作回数
    //dp1[i][j]:=i個まで見て合計jを作る。最後のi番目を使う時の最小の操作回数
    final int[][] dp0 = new int[n + 1][m + 1];
    final int[][] dp1 = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      Arrays.fill(dp0[i], INF);
      Arrays.fill(dp1[i], INF);
    }
    dp0[0][0] = 1;
    dp1[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      int a = array_a[i - 1];
      for (int j = 0; j <= m; j++) {
        dp0[i][j] = Math.min(dp0[i - 1][j], dp1[i - 1][j] + 1);
        if (j - a < 0) {
          dp1[i][j] = INF;
        } else {
          dp1[i][j] = Math.min(dp0[i - 1][j - a], dp1[i - 1][j - a]);
        }
      }
    }
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 1; i <= m; i++) {
      int ans = Math.min(dp0[n][i], dp1[n][i]);
      pw.println(ans == INF ? -1 : ans);
    }
    pw.close();
  }
}
