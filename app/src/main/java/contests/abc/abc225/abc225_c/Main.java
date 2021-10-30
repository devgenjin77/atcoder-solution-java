/*
 * ABC225
 * C - Calendar Validator
 * https://atcoder.jp/contests/abc225/tasks/abc225_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc225/submissions/26939510
 */
package contests.abc.abc225.abc225_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);
    int[][] chk_array = new int[2][m];
    boolean isOk = true;

    chk_loop:
    for (int row_idx = 0; row_idx < n; row_idx++) {
      String[] data = br.readLine().split(" ");
      for (int col_idx = 0; col_idx < m; col_idx++) {
        int cur_row_idx = row_idx % 2;
        int pre_row_idx = (cur_row_idx + 1) % 2;
        chk_array[cur_row_idx][col_idx] = Integer.parseInt(data[col_idx]) - 1;
        if (row_idx == 0) {
          //初回チェック：行の要素および7の剰余が1づつ増えていること
          if (col_idx > 0 && (
              chk_array[cur_row_idx][col_idx - 1] + 1 != chk_array[cur_row_idx][col_idx]
                  || (chk_array[cur_row_idx][col_idx - 1] % 7) + 1
                  != chk_array[cur_row_idx][col_idx] % 7)) {
            isOk = false;
            break chk_loop;
          }
        } else {
          //初回以外チェック：前回読み込んだ行の同一列の要素から7増えていること
          if (chk_array[pre_row_idx][col_idx] + 7 != chk_array[cur_row_idx][col_idx]) {
            isOk = false;
            break chk_loop;
          }
        }
      }
    }
    br.close();
    System.out.println(isOk ? "Yes" : "No");
  }
}
