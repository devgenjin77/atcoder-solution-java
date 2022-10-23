/*
 * freee プログラミングコンテスト2022
 * （AtCoder Beginner Contest 264）
 * C - Matrix Reducing
 * https://atcoder.jp/contests/abc264/tasks/abc264_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc264/submissions/35926067
 *
 */

package contests.abc.abc26x.abc264.abc264_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st1 = new StringTokenizer(br.readLine());
    final int h1 = Integer.parseInt(st1.nextToken());
    final int w1 = Integer.parseInt(st1.nextToken());
    final int[][] array_a = new int[h1][w1];
    for (int i = 0; i < h1; i++) {
      final StringTokenizer st_a = new StringTokenizer(br.readLine());
      for (int j = 0; j < w1; j++) {
        array_a[i][j] = Integer.parseInt(st_a.nextToken());
      }
    }
    final StringTokenizer st2 = new StringTokenizer(br.readLine());
    final int h2 = Integer.parseInt(st2.nextToken());
    final int w2 = Integer.parseInt(st2.nextToken());
    final int[][] array_b = new int[h2][w2];
    for (int i = 0; i < h2; i++) {
      StringTokenizer st_b = new StringTokenizer(br.readLine());
      for (int j = 0; j < w2; j++) {
        array_b[i][j] = Integer.parseInt(st_b.nextToken());
      }
    }
    br.close();
    boolean isOk = true;
    main_loop:
    for (int bit_h = 1; bit_h < 1 << h1; bit_h++) {
      if (Integer.bitCount(bit_h) != h2) {
        continue;
      }
      for (int bit_w = 1; bit_w < 1 << w1; bit_w++) {
        if (Integer.bitCount(bit_w) != w2) {
          continue;
        }
        int wk_h = 0;
        isOk = true;
        check_loop:
        for (int i = 0; i < h1; i++) {
          if ((bit_h >> i & 1) == 0) {
            continue;
          }
          int wk_w = 0;
          for (int j = 0; j < w1; j++) {
            if ((bit_w >> j & 1) == 0) {
              continue;
            }
            if (array_a[i][j] != array_b[wk_h][wk_w++]) {
              isOk = false;
              break check_loop;
            }
          }
          wk_h++;
        }
        if (isOk) {
          break main_loop;
        }
      }
    }
    System.out.println(isOk ? "Yes" : "No");
  }
}
