/*
 * ABC244
 * B - Go Straight and Turn Right
 * https://atcoder.jp/contests/abc244/tasks/abc244_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc244/submissions/31376706
 *
 */

package contests.abc.abc244.abc244_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  //東南西北の順番に定義
  static final int[] dir_x = {1, 0, -1, 0};
  static final int[] dir_y = {0, -1, 0, 1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();
    br.close();
    int d = 0;
    int pos_x = 0, pos_y = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == 'S') {
        pos_x += dir_x[d];
        pos_y += dir_y[d];
      } else {
        d = (d + 1) % 4;
      }
    }
    System.out.println(String.format("%d %d", pos_x, pos_y));
  }
}