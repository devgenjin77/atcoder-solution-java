/*
 * 競プロ典型90問
 * 063 - Monochromatic Subgrid（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bk
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28374895
 *
 */
package contests.typical90.typical90_063;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    StringTokenizer head = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(head.nextToken());
    int w = Integer.parseInt(head.nextToken());
    int[][] tbl_num = new int[h][w];
    for (int i = 0; i < h; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < w; j++) {
        tbl_num[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    br.close();
    int ans = 1;
    for (int bit = 1; bit < 1 << h; bit++) {
      int max_col = 0;
      HashMap<Integer, Integer> num_cnt_map = new HashMap<>();
      for (int col = 0; col < w; col++) {
        int num = -1;
        boolean isAllSame = true;
        for (int row = 0; row < h; row++) {
          if ((bit >> row & 1) == 0) {
            continue;
          }
          if (num == -1) {
            num = tbl_num[row][col];
          } else {
            if (tbl_num[row][col] != num) {
              isAllSame = false;
              break;
            }
          }
        }
        if (isAllSame) {
          int cnt = num_cnt_map.getOrDefault(num, 0) + 1;
          num_cnt_map.put(num, cnt);
          max_col = Math.max(cnt, max_col);
        }
      }
      ans = Math.max(max_col * Integer.bitCount(bit), ans);
    }
    System.out.println(ans);
    return;
  }
}
