/*
 * ABC241
 * C - Connect 6
 * https://atcoder.jp/contests/abc241/tasks/abc241_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc241/submissions/32309491
 *
 */

package contests.abc.abc24x.abc241.abc241_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  //方向は右上、右、右下、下の順番で定義
  static final int[] dh = {-1, 0, 1, 1};
  static final int[] dw = {1, 1, 1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] grid = new String[n];
    for (int i = 0; i < n; i++) {
      grid[i] = br.readLine();
    }
    br.close();

    boolean found = false;
    main_loop:
    for (int pos_h = 0; pos_h < n; pos_h++) {
      for (int pos_w = 0; pos_w < n; pos_w++) {
        for (int d = 0; d < 4; d++) {
          int next_h = pos_h + (dh[d] * 5);
          int next_w = pos_w + (dw[d] * 5);
          if (!(next_h >= 0 && next_h < n && next_w >= 0 && next_w < n)) {
            continue;
          }
          int counter = 0;
          for (int cnt = 0; cnt < 6; cnt++) {
            if (grid[pos_h + (dh[d] * cnt)].charAt(pos_w + (dw[d] * cnt)) == '#') {
              counter++;
            }
          }
          if (counter >= 4) {
            found = true;
            break;
          }
        }
      }
    }
    System.out.println(found ? "Yes" : "No");
  }
}
