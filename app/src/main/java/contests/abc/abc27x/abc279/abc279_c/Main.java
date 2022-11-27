/*
 * トヨタシステムズプログラミングコンテスト2022
 * （AtCoder Beginner Contest 279）
 * C - RANDOM
 * https://atcoder.jp/contests/abc279/tasks/abc279_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc279/submissions/36844158
 *
 * note:
 *
 */

package contests.abc.abc27x.abc279.abc279_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int h = Integer.parseInt(st.nextToken());
    final int w = Integer.parseInt(st.nextToken());
    final String[] grid_s = new String[h];
    final String[] grid_t = new String[h];
    for (int i = 0; i < h; i++) {
      grid_s[i] = br.readLine();
    }
    for (int i = 0; i < h; i++) {
      grid_t[i] = br.readLine();
    }
    br.close();
    final String[] grid_alt_s = swapMatrix(h, w, grid_s);
    final String[] grid_alt_t = swapMatrix(h, w, grid_t);
    Arrays.sort(grid_alt_s);
    Arrays.sort(grid_alt_t);
    boolean isOK = true;
    for (int i = 0; i < w; i++) {
      if (!grid_alt_s[i].equals(grid_alt_t[i])) {
        isOK = false;
        break;
      }
    }
    System.out.println(isOK ? "Yes" : "No");
  }

  static String[] swapMatrix(int h, int w, String[] grid) {
    String[] ret = new String[w];
    for (int i = 0; i < w; i++) {
      StringBuilder s = new StringBuilder();
      for (int j = 0; j < h; j++) {
        s.append(grid[j].charAt(i));
      }
      ret[i] = s.toString();
    }
    return ret;
  }
}
