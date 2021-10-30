/*
 * ABC224
 * C - Triangle?
 * https://atcoder.jp/contests/abc224/tasks/abc224_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc224/submissions/26881302
 */
package contests.abc.abc224.abc224_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] points = new int[n][2];
    for (int i = 0; i < n; i++) {
      String[] data = br.readLine().split(" ");
      points[i][0] = Integer.parseInt(data[0]);
      points[i][1] = Integer.parseInt(data[1]);
    }
    br.close();
    int ans = 0;
    for (int i1 = 0; i1 < n - 2; i1++) {
      int x0 = points[i1][0];
      int y0 = points[i1][1];
      for (int i2 = i1 + 1; i2 < n - 1; i2++) {
        for (int i3 = i2 + 1; i3 < n; i3++) {
          int x1 = points[i2][0] - x0;
          int y1 = points[i2][1] - y0;
          int x2 = points[i3][0] - x0;
          int y2 = points[i3][1] - y0;
          if (x1 * y2 != x2 * y1) {
            ans++;
          }
        }
      }
    }
    System.out.println(ans);
  }
}
