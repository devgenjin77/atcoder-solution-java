/*
 * UNICORNプログラミングコンテスト2022
 * （AtCoder Beginner Contest 269）
 * E - Last Rook
 * https://atcoder.jp/contests/abc269/tasks/abc269_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc269/submissions/34972566
 *
 */

package contests.abc.abc26x.abc269.abc269_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final PrintWriter pw = new PrintWriter(System.out);
    final int n = Integer.parseInt(br.readLine());
    int row_min = 1, row_max = n;
    //行を二分探索で求める
    while (row_min < row_max) {
      int row_mid = (row_max + row_min) / 2;
      pw.println(query(row_min, row_mid, 1, n));
      pw.flush();
      int ans = Integer.parseInt(br.readLine());
      if (row_mid + 1 - row_min == ans) {
        row_min = row_mid + 1;
      } else {
        row_max = row_mid;
      }
    }
    int col_min = 1, col_max = n;
    //列を二分探索で求める
    while (col_min < col_max) {
      int col_mid = (col_max + col_min) / 2;
      pw.println(query(1, n, col_min, col_mid));
      pw.flush();
      int ans = Integer.parseInt(br.readLine());
      if (col_mid + 1 - col_min == ans) {
        col_min = col_mid + 1;
      } else {
        col_max = col_mid;
      }
    }
    pw.println(String.format("! %d %d", row_max, col_max));
    pw.close();
    br.close();
  }

  static String query(int a, int b, int c, int d) {
    return String.format("? %d %d %d %d", a, b, c, d);
  }
}
