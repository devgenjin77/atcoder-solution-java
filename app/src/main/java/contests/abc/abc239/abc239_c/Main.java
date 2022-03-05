/*
 * ABC239
 * C - Knight Fork
 * https://atcoder.jp/contests/abc239/tasks/abc239_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc239/submissions/29852160
 *
 */
package contests.abc.abc239.abc239_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static long[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
  static long[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    br.close();
    long x1 = Long.parseLong(input[0]);
    long y1 = Long.parseLong(input[1]);
    long x2 = Long.parseLong(input[2]);
    long y2 = Long.parseLong(input[3]);

    System.out.println(solve(x1, y1, x2, y2) ? "Yes" : "No");
  }

  static boolean solve(long x1, long y1, long x2, long y2) {
    for (int i = 0; i < 8; i++) {
      long x_diff = Math.abs(x1 + dx[i] - x2);
      long y_diff = Math.abs(y1 + dy[i] - y2);
      if ((x_diff == 1 && y_diff == 2) || (x_diff == 2 && y_diff == 1)) {
        return true;
      }
    }
    return false;
  }
}
