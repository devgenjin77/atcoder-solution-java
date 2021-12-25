/*
 * ABC232
 * E - Rook Path
 * https://atcoder.jp/contests/abc232/tasks/abc232_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc232/submissions/28104141
 */
package contests.abc.abc232.abc232_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  final static long MOD = 998244353;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] hwk = br.readLine().split(" ");
    int h = Integer.parseInt(hwk[0]);
    int w = Integer.parseInt(hwk[1]);
    int k = Integer.parseInt(hwk[2]);
    String[] points = br.readLine().split(" ");
    int x1 = Integer.parseInt(points[0]);
    int y1 = Integer.parseInt(points[1]);
    int x2 = Integer.parseInt(points[2]);
    int y2 = Integer.parseInt(points[3]);
    br.close();
    long dp00 = 0, dp01 = 0, dp10 = 0, dp11 = 0;
    long dq00 = 0, dq01 = 0, dq10 = 0, dq11 = 0;
    if (x1 == x2 && y1 == y2) {
      dp00 = 1;
    } else if (x1 == x2) {
      dp01 = 1;
    } else if (y1 == y2) {
      dp10 = 1;
    } else {
      dp11 = 1;
    }
    for (int cnt = 1; cnt <= k; cnt++) {
      dq00 = dp10 + dp01;
      dq00 %= MOD;
      dq10 = (dp00 * (h - 1)) + (dp10 * (h - 2)) + dp11;
      dq10 %= MOD;
      dq01 = (dp00 * (w - 1)) + (dp01 * (w - 2)) + dp11;
      dq01 %= MOD;
      dq11 = (dp10 * (w - 1)) + (dp01 * (h - 1)) + (dp11 * ((h - 2) + (w - 2)));
      dq11 %= MOD;
      dp00 = dq00;
      dp10 = dq10;
      dp01 = dq01;
      dp11 = dq11;
    }
    System.out.println(dp00);
  }
}
