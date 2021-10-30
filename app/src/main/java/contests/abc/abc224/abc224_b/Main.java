/*
 * ABC224
 * B - Mongeness
 * https://atcoder.jp/contests/abc224/tasks/abc224_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc224/submissions/26881041
 */
package contests.abc.abc224.abc224_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] hw = br.readLine().split(" ");
    int h = Integer.parseInt(hw[0]);
    int w = Integer.parseInt(hw[1]);
    int[][] array = new int[h][w];
    for (int i = 0; i < h; i++) {
      String[] data = br.readLine().split(" ");
      for (int j = 0; j < w; j++) {
        array[i][j] = Integer.parseInt(data[j]);
      }
    }
    br.close();
    boolean isMonge = true;
    main_loop:
    for (int pos_h = 0; pos_h < h - 1; pos_h++) {
      for (int pos_w = 0; pos_w < w - 1; pos_w++) {
        if (array[pos_h][pos_w] + array[pos_h + 1][pos_w + 1] > array[pos_h][pos_w + 1] + array[
            pos_h + 1][pos_w]) {
          isMonge = false;
          break main_loop;
        }
      }
    }
    System.out.println(isMonge ? "Yes" : "No");
  }
}
