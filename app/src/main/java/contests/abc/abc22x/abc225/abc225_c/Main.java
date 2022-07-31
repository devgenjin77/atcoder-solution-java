/*
 * UNICORNプログラミングコンテスト2021
 * （AtCoder Beginner Contest 225）
 * C - Calendar Validator
 * https://atcoder.jp/contests/abc225/tasks/abc225_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc225/submissions/33649717
 *
 * note:
 *
 *
 */

package contests.abc.abc22x.abc225.abc225_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final int[][] array_b = new int[n][m];
    for (int i = 0; i < n; i++) {
      StringTokenizer st_b = new StringTokenizer(br.readLine());
      for (int j = 0; j < m; j++) {
        array_b[i][j] = Integer.parseInt(st_b.nextToken()) - 1;
      }
    }
    br.close();
    boolean isOk = true;
    main_loop:
    for (int i = 0; i < n; i++) {
      if (i > 0 && array_b[i][0] - array_b[i - 1][0] != 7) {
        isOk = false;
      }
      for (int j = 0; j < m; j++) {
        if (j > 0 && (array_b[i][j] - array_b[i][j - 1] != 1
            || array_b[i][j] % 7 <= array_b[i][j - 1] % 7)) {
          isOk = false;
          break main_loop;
        }
      }
    }
    System.out.println(isOk ? "Yes" : "No");
  }
}
