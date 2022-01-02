/*
 * 競プロ典型90問
 * 028 - Cluttered Paper（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ab
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28298266
 *
 */
package contests.typical90.typical90_028;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  final static int MAX_RANGE = 1000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] ans = new int[n + 1];
    int[][] map = new int[MAX_RANGE + 1][MAX_RANGE + 1];
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      int lx = Integer.parseInt(input[0]);
      int ly = Integer.parseInt(input[1]);
      int rx = Integer.parseInt(input[2]);
      int ry = Integer.parseInt(input[3]);

      map[lx][ly] += 1;
      map[rx][ry] += 1;
      map[lx][ry] -= 1;
      map[rx][ly] -= 1;
    }
    br.close();

    for (int pos_y = 0; pos_y <= MAX_RANGE; pos_y++) {
      for (int pos_x = 1; pos_x <= MAX_RANGE; pos_x++) {
        map[pos_x][pos_y] += map[pos_x - 1][pos_y];
      }
    }

    for (int pos_x = 0; pos_x <= MAX_RANGE; pos_x++) {
      for (int pos_y = 1; pos_y <= MAX_RANGE; pos_y++) {
        map[pos_x][pos_y] += map[pos_x][pos_y - 1];
      }
    }

    for (int pos_x = 0; pos_x <= MAX_RANGE; pos_x++) {
      for (int pos_y = 0; pos_y <= MAX_RANGE; pos_y++) {
        ans[map[pos_x][pos_y]] += 1;
      }
    }
    PrintWriter pw = new PrintWriter(System.out);
    for (int num = 1; num <= n; num++) {
      pw.println(ans[num]);
    }
    pw.close();
    return;
  }
}
