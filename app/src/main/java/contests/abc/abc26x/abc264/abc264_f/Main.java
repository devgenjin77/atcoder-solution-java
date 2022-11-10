/*
 * freee プログラミングコンテスト2022
 * （AtCoder Beginner Contest 264）
 * F - Monochromatic Path
 * https://atcoder.jp/contests/abc264/tasks/abc264_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc264/submissions/36370369
 *
 * note:
 *
 *
 */

package contests.abc.abc26x.abc264.abc264_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static final long INF = Long.MAX_VALUE / 2;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int h = Integer.parseInt(st.nextToken());
    final int w = Integer.parseInt(st.nextToken());
    final StringTokenizer st_r = new StringTokenizer(br.readLine());
    final StringTokenizer st_c = new StringTokenizer(br.readLine());
    final long[] array_r = new long[h];
    final long[] array_c = new long[w];
    for (int i = 0; i < h; i++) {
      array_r[i] = Long.parseLong(st_r.nextToken());
    }
    for (int i = 0; i < w; i++) {
      array_c[i] = Long.parseLong(st_c.nextToken());
    }
    final char[][] grid = new char[h][w];
    for (int i = 0; i < h; i++) {
      System.arraycopy(br.readLine().toCharArray(), 0, grid[i], 0, w);
    }
    br.close();
    long ans = Long.MAX_VALUE;
    //dp_x1x2[h][w]:=h行w列に居る時に、行hをx1回、列x2回反転させた
    long[][] dp_00 = new long[h][w];
    long[][] dp_01 = new long[h][w];
    long[][] dp_10 = new long[h][w];
    long[][] dp_11 = new long[h][w];
    for (int i = 0; i < h; i++) {
      Arrays.fill(dp_00[i], INF);
      Arrays.fill(dp_01[i], INF);
      Arrays.fill(dp_10[i], INF);
      Arrays.fill(dp_11[i], INF);
    }
    dp_00[0][0] = 0;
    dp_01[0][0] = array_c[0];
    dp_10[0][0] = array_r[0];
    dp_11[0][0] = array_r[0] + array_c[0];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        //下への遷移
        if (i + 1 < h) {
          if (grid[i][j] == grid[i + 1][j]) {
            dp_00[i + 1][j] = Math.min(dp_00[i][j], dp_00[i + 1][j]);
            dp_01[i + 1][j] = Math.min(dp_01[i][j], dp_01[i + 1][j]);
            dp_10[i + 1][j] = Math.min(dp_10[i][j] + array_r[i + 1], dp_10[i + 1][j]);
            dp_11[i + 1][j] = Math.min(dp_11[i][j] + array_r[i + 1], dp_11[i + 1][j]);
          } else {
            dp_00[i + 1][j] = Math.min(dp_10[i][j], dp_00[i + 1][j]);
            dp_01[i + 1][j] = Math.min(dp_11[i][j], dp_01[i + 1][j]);
            dp_10[i + 1][j] = Math.min(dp_00[i][j] + array_r[i + 1], dp_10[i + 1][j]);
            dp_11[i + 1][j] = Math.min(dp_01[i][j] + array_r[i + 1], dp_11[i + 1][j]);
          }
        }
        //右への遷移
        if (j + 1 < w) {
          if (grid[i][j] == grid[i][j + 1]) {
            dp_00[i][j + 1] = Math.min(dp_00[i][j], dp_00[i][j + 1]);
            dp_01[i][j + 1] = Math.min(dp_01[i][j] + array_c[j + 1], dp_01[i][j + 1]);
            dp_10[i][j + 1] = Math.min(dp_10[i][j], dp_10[i][j + 1]);
            dp_11[i][j + 1] = Math.min(dp_11[i][j] + array_c[j + 1], dp_11[i][j + 1]);
          } else {
            dp_00[i][j + 1] = Math.min(dp_01[i][j], dp_00[i][j + 1]);
            dp_01[i][j + 1] = Math.min(dp_00[i][j] + array_c[j + 1], dp_01[i][j + 1]);
            dp_10[i][j + 1] = Math.min(dp_11[i][j], dp_10[i][j + 1]);
            dp_11[i][j + 1] = Math.min(dp_10[i][j] + array_c[j + 1], dp_11[i][j + 1]);
          }
        }
      }
    }
    long ans0 = Math.min(dp_00[h - 1][w - 1], dp_01[h - 1][w - 1]);
    long ans1 = Math.min(dp_10[h - 1][w - 1], dp_11[h - 1][w - 1]);
    System.out.println(Math.min(ans0, ans1));
  }
}
