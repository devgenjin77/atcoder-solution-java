/*
 * ABC241
 * C - Connect 6
 * https://atcoder.jp/contests/abc241/tasks/abc241_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc241/submissions/29732230
 *
 */
package contests.abc.abc241.abc241_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String[] grid_map = new String[n];
    for (int i = 0; i < n; i++) {
      grid_map[i] = br.readLine();
    }
    boolean bOk = false;
    main_loop:
    for (int pos_h = 0; pos_h < n; pos_h++) {
      for (int pos_w = 0; pos_w < n; pos_w++) {
        if (checkHigher4(grid_map, pos_h, pos_w, 0, 1)      //右方向
            || checkHigher4(grid_map, pos_h, pos_w, 1, 0)   //下方向
            || checkHigher4(grid_map, pos_h, pos_w, -1, 1)  //右上方向
            || checkHigher4(grid_map, pos_h, pos_w, 1, 1)   //右下方向
        ) {
          bOk = true;
          break main_loop;
        }
      }
    }
    System.out.println(bOk ? "Yes" : "No");
  }

  static boolean checkHigher4(String[] grid_map, int pos_h, int pos_w, int dh, int dw) {
    int tmp_h = pos_h + (dh * 5);
    if (tmp_h < 0 || tmp_h >= grid_map.length) {
      return false;
    }
    int tmp_w = pos_w + (dw * 5);
    if (tmp_w < 0 || tmp_w >= grid_map[tmp_h].length()) {
      return false;
    }
    int bCnt = 0;
    for (int cnt = 0; cnt < 6; cnt++) {
      if (grid_map[pos_h + (dh * cnt)].charAt(pos_w + (dw * cnt)) == '#') {
        bCnt++;
      }
    }
    return bCnt >= 4;
  }
}
