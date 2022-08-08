/*
 * NECプログラミングコンテスト2021
 * （AtCoder Beginner Contest 229）
 * A - First Grid
 * https://atcoder.jp/contests/abc229/tasks/abc229_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc229/submissions/33878984
 *
 * note:
 * Noとなるパターンは限定されているので、IF文で判別
 *
 */

package contests.abc.abc22x.abc229.abc229_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String[] grid = new String[2];
    grid[0] = br.readLine();
    grid[1] = br.readLine();
    br.close();
    if (("#.".equals(grid[0]) && ".#".equals(grid[1])) || ("#.".equals(grid[1]) && ".#".equals(
        grid[0]))) {
      System.out.println("No");
    } else {
      System.out.println("Yes");
    }
  }
}
