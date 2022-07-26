/*
 * AtCoder Beginner Contest 224
 * B - Mongeness
 * https://atcoder.jp/contests/abc224/tasks/abc224_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc224/submissions/33538166
 *
 * note:
 * Monge配列かどうかチェックする
 *
 */

package contests.abc.abc22x.abc224.abc224_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int h = Integer.parseInt(st.nextToken());
    final int w = Integer.parseInt(st.nextToken());
    final int[][] tbl_a = new int[h][w];
    for (int i = 0; i < h; i++) {
      StringTokenizer st_a = new StringTokenizer(br.readLine());
      for (int j = 0; j < w; j++) {
        tbl_a[i][j] = Integer.parseInt(st_a.nextToken());
      }
    }
    br.close();
    boolean isOk = true;
    main_loop:
    for (int i = 0; i < h - 1; i++) {
      for (int j = 0; j < w - 1; j++) {
        if (tbl_a[i][j] + tbl_a[i + 1][j + 1] > tbl_a[i + 1][j] + tbl_a[i][j + 1]) {
          isOk = false;
          break main_loop;
        }
      }
    }
    System.out.println(isOk ? "Yes" : "No");
  }
}
