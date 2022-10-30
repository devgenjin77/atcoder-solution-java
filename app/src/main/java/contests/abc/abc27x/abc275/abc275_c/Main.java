/*
 * AtCoder Beginner Contest 275
 * C - Counting Squares
 * https://atcoder.jp/contests/abc275/tasks/abc275_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc275/submissions/36104429
 *
 * note:
 *
 *
 */

package contests.abc.abc27x.abc275.abc275_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String[] board = new String[9];
    for (int i = 0; i < 9; i++) {
      board[i] = br.readLine();
    }
    br.close();
    int ans = 0;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i].charAt(j) == '.') {
          continue;
        }
        for (int tmp_h = 0; tmp_h < 9 - i; tmp_h++) {
          for (int tmp_w = 1; tmp_w < 9 - j; tmp_w++) {
            int[] arr_h = new int[3];
            int[] arr_w = new int[3];
            arr_h[0] = i + tmp_h;
            arr_w[0] = j + tmp_w;
            arr_h[1] = arr_h[0] + tmp_w;
            arr_w[1] = arr_w[0] - tmp_h;
            arr_h[2] = arr_h[1] - tmp_h;
            arr_w[2] = arr_w[1] - tmp_w;
            boolean isOk = true;
            for (int k = 0; k < 3; k++) {
              if (arr_h[k] >= 0 && arr_h[k] < 9 && arr_w[k] >= 0 && arr_w[k] < 9) {
                if (board[arr_h[k]].charAt(arr_w[k]) == '.') {
                  isOk = false;
                  break;
                }
              } else {
                isOk = false;
                break;
              }
            }
            if (isOk) {
              ans++;
            }
          }
        }
      }
    }
    System.out.println(ans);
  }
}
