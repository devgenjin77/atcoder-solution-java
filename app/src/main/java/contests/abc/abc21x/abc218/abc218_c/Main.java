/*
 * AtCoder Beginner Contest 218
 * C - Shapes
 * https://atcoder.jp/contests/abc218/tasks/abc218_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc218/submissions/32804370
 *
 */

package contests.abc.abc21x.abc218.abc218_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    char[][] grid_s = new char[n][n];
    char[][] grid_t = new char[n][n];
    for (int i = 0; i < n; i++) {
      final String s = br.readLine();
      System.arraycopy(s.toCharArray(), 0, grid_s[i], 0, n);
    }
    for (int i = 0; i < n; i++) {
      final String t = br.readLine();
      System.arraycopy(t.toCharArray(), 0, grid_t[i], 0, n);
    }
    br.close();

    boolean isOk = false;
    char[][] grid_t_normal = normalize(grid_t);
    for (int r = 0; r < 4; r++) {
      char[][] grid_s_normal = normalize(grid_s);
      if (Arrays.deepEquals(grid_s_normal, grid_t_normal)) {
        isOk = true;
        break;
      } else {
        grid_s = rotateRight(grid_s);
      }
    }
    System.out.println(isOk ? "Yes" : "No");
  }

  //図形の位置を可能な限り左上にスライドさせた配列を返す
  static char[][] normalize(char[][] grid_s) {
    char[][] ret = new char[grid_s.length][grid_s[0].length];
    for (int i = 0; i < ret.length; i++) {
      Arrays.fill(ret[i], '.');
    }
    //左上を求める
    int upper = grid_s.length, left = grid_s[0].length;
    for (int i = 0; i < grid_s.length; i++) {
      for (int j = 0; j < grid_s[i].length; j++) {
        if (grid_s[i][j] == '#') {
          upper = Math.min(i, upper);
          left = Math.min(j, left);
        }
      }
    }
    for (int i = upper; i < grid_s.length; i++) {
      for (int j = left; j < grid_s[i].length; j++) {
        ret[i - upper][j - left] = grid_s[i][j];
      }
    }
    return ret;
  }

  static char[][] rotateRight(char[][] grid_s) {
    char[][] ret = new char[grid_s.length][grid_s[0].length];
    for (int i = 0; i < grid_s.length; i++) {
      for (int j = 0; j < grid_s[i].length; j++) {
        ret[j][ret.length - i - 1] = grid_s[i][j];
      }
    }
    return ret;
  }
}
