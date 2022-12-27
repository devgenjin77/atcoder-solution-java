/*
 * ユニークビジョンプログラミングコンテスト2022 冬
 * （AtCoder Beginner Contest 283）
 * E - Don't Isolate Elements
 * https://atcoder.jp/contests/abc283/tasks/abc283_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc283/submissions/37587584
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc283.abc283_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static final int INF = Integer.MAX_VALUE / 2;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int h = Integer.parseInt(st.nextToken());
    final int w = Integer.parseInt(st.nextToken());
    final int[][] matrix_a = new int[h][w];
    for (int i = 0; i < h; i++) {
      StringTokenizer st_a = new StringTokenizer(br.readLine());
      for (int j = 0; j < w; j++) {
        matrix_a[i][j] = Integer.parseInt(st_a.nextToken());
      }
    }
    br.close();
    //dp[i][j]:=i行目まで見て、反転するか決めた時の最小の操作回数
    //j=00->前2行反転しない。01->直前のみ反転、10->2行前のみ反転、11->2行とも反転
    final int[][] dp = new int[h + 1][4];
    for (int idx = 0; idx <= h; idx++) {
      Arrays.fill(dp[idx], INF);
    }
    dp[0][0] = 0;
    dp[0][1] = 1;
    final int[][] matrix_wk = new int[3][w];
    for (int i = 1; i <= h; i++) {
      for (int j = 0; j < 4; j++) {
        if (dp[i - 1][j] == INF) {
          continue;
        }
        int flip_2 = (j / 2); //2行前が反転していれば1
        int flip_1 = (j % 2); //1行前が反転していれば1
        //i-2行目
        if (i >= 2) {
          for (int idx = 0; idx < w; idx++) {
            matrix_wk[0][idx] = flip_2 == 1 ? 1 - matrix_a[i - 2][idx] : matrix_a[i - 2][idx];
          }
        } else {
          Arrays.fill(matrix_wk[0], -1);
        }
        //i-1行目
        for (int idx = 0; idx < w; idx++) {
          matrix_wk[1][idx] = flip_1 == 1 ? 1 - matrix_a[i - 1][idx] : matrix_a[i - 1][idx];
        }
        for (int flip_0 = 0; flip_0 < 2; flip_0++) {
          if (i == h && flip_0 == 1) {
            continue;
          }
          //i行目
          if (i < h) {
            for (int idx = 0; idx < w; idx++) {
              matrix_wk[2][idx] = flip_0 == 1 ? 1 - matrix_a[i][idx] : matrix_a[i][idx];
            }
          } else {
            Arrays.fill(matrix_wk[2], -1);
          }
          boolean isIsolate = false;
          //孤立点チェック
          for (int idx = 0; idx < w; idx++) {
            if (matrix_wk[1][idx] == matrix_wk[0][idx] ||
                matrix_wk[1][idx] == matrix_wk[2][idx] ||
                (idx > 0 && matrix_wk[1][idx] == matrix_wk[1][idx - 1]) ||
                (idx < w - 1 && matrix_wk[1][idx] == matrix_wk[1][idx + 1])) {
              // do nothing
            } else {
              isIsolate = true;
              break;
            }
          }
          int next_j = (flip_1 * 2) + flip_0;
          if (!isIsolate) {
            dp[i][next_j] = Math.min(dp[i - 1][j] + flip_0, dp[i][next_j]);
          }
        }
      }
    }
    int ans = Math.min(dp[h][0], dp[h][2]);
    System.out.println(ans == INF ? -1 : ans);
  }
}
