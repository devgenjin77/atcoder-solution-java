/*
 * ユニークビジョンプログラミングコンテスト2022
 * （AtCoder Beginner Contest 248）
 * F - Keep Connect
 * https://atcoder.jp/contests/abc248/tasks/abc248_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc248/submissions/31137901
 *
 */

package contests.abc.abc248.abc248_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] np = br.readLine().split(" ");
    br.close();
    int n = Integer.parseInt(np[0]);
    long p = Long.parseLong(np[1]);
    //dp0[i][j]:=頂点i+1までみて、j辺取り除いた状態で連結
    //dp0[i][j]:=頂点i+1までみて、j辺取り除いた状態で右端2点のみ連結でない
    long[][] dp0 = new long[n][n + 2];
    long[][] dp1 = new long[n][n + 2];
    dp0[0][0] = 1;
    dp1[0][1] = 1;
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < n; j++) {
        dp0[i][j] += dp0[i - 1][j];
        dp0[i][j] += dp1[i - 1][j];
        dp0[i][j] %= p;
        dp0[i][j + 1] += dp0[i - 1][j] * 3;
        dp0[i][j + 1] %= p;
        dp1[i][j + 1] += dp1[i - 1][j];
        dp1[i][j + 1] %= p;
        dp1[i][j + 2] += dp0[i - 1][j] * 2;
        dp1[i][j + 2] %= p;
      }
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < n; i++) {
      if (sb.length() > 0) {
        sb.append(' ');
      }
      sb.append(dp0[n - 1][i]);
    }
    System.out.println(sb.toString());
  }
}
