/*
 * デンソークリエイトプログラミングコンテスト2022
 * （AtCoder Beginner Contest 239）
 * C - Knight Fork
 * https://atcoder.jp/contests/abc239/tasks/abc239_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc239/submissions/33946577
 *
 * note:
 * ありうるパターンを全探索
 *
 */

package contests.abc.abc23x.abc239.abc239_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int x1 = Integer.parseInt(st.nextToken());
    final int y1 = Integer.parseInt(st.nextToken());
    final int x2 = Integer.parseInt(st.nextToken());
    final int y2 = Integer.parseInt(st.nextToken());
    br.close();
    boolean isOk = false;
    main_loop:
    for (int dx = -2; dx <= 2; dx++) {
      for (int dy = -2; dy <= 2; dy++) {
        if ((dx * dx) + (dy * dy) != 5) {
          continue;
        }
        int diff_x = x2 - (x1 + dx);
        int diff_y = y2 - (y1 + dy);
        if ((diff_x * diff_x) + (diff_y * diff_y) == 5) {
          isOk = true;
          break main_loop;
        }
      }
    }
    System.out.println(isOk ? "Yes" : "No");
  }
}
