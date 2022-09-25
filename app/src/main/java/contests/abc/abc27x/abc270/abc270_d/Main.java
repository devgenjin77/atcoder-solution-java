/*
 * トヨタ自動車プログラミングコンテスト2022
 * （AtCoder Beginner Contest 270）
 * D - Stones
 * https://atcoder.jp/contests/abc270/tasks/abc270_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc270/submissions/35155229
 *
 */

package contests.abc.abc27x.abc270.abc270_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int k = Integer.parseInt(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[k];
    for (int i = 0; i < k; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    //dp[i]:=i個残った時に、先手が取れる最大の石の数
    final int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < k; j++) {
        int a = array_a[j];
        if (a > i) {
          break;
        }
        //dpの漸化式
        //i個の時点でj個取った場合、((i - j) - dp[i - j])個取れる
        //jを全探索してMAXを取る
        dp[i] = Math.max(a + ((i - a) - dp[i - a]), dp[i]);
      }
    }
    System.out.println(dp[n]);
  }
}
