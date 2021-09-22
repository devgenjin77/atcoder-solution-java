/*
 * ABC218
 * C - Shapes
 * https://atcoder.jp/contests/abc218/tasks/abc218_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc218/submissions/26051008
 */
package contests.abc.abc218.abc218_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    char[][] shape_s = new char[n][n];
    char[][] shape_t = new char[n][n];
    for (int i = 0; i < n; i++) {
      System.arraycopy(br.readLine().toCharArray(), 0, shape_s[i], 0, n);
    }
    for (int i = 0; i < n; i++) {
      System.arraycopy(br.readLine().toCharArray(), 0, shape_t[i], 0, n);
    }
    br.close();
    System.out.println(solve(shape_s, shape_t, n) ? "Yes" : "No");
  }

  static boolean solve(char[][] shape_s, char[][] shape_t, int n) {
    int s_up = n + 1;
    int s_down = 0;
    int s_left = n + 1;
    int s_right = 0;
    for (int x = 0; x < n; x++) {
      for (int y = 0; y < n; y++) {
        if (shape_s[x][y] == '#') {
          s_up = Math.min(x, s_up);
          s_down = Math.max(x + 1, s_down);
          s_left = Math.min(y, s_left);
          s_right = Math.max(y + 1, s_right);
        }
      }
    }

    int s_x_len = s_down - s_up;
    int s_y_len = s_right - s_left;
    for (int cnt = 0; cnt < 4; cnt++) {
      if (cnt != 0) {
        //初回以外は右90回転させる
        shape_t = rotateShape90Degrees(shape_t, n);
      }
      int t_up = n + 1;
      int t_down = 0;
      int t_left = n + 1;
      int t_right = 0;

      for (int x = 0; x < n; x++) {
        for (int y = 0; y < n; y++) {
          if (shape_t[x][y] == '#') {
            t_up = Math.min(x, t_up);
            t_down = Math.max(x + 1, t_down);
            t_left = Math.min(y, t_left);
            t_right = Math.max(y + 1, t_right);
          }
        }
      }
      if (s_down - s_up != t_down - t_up || s_right - s_left != t_right - t_left) {
        continue;
      }
      boolean check = true;
      XY_LOOP:
      for (int x = 0; x < s_x_len; x++) {
        for (int y = 0; y < s_y_len; y++) {
          if (shape_s[x + s_up][y + s_left] != shape_t[x + t_up][y + t_left]) {
            check = false;
            break XY_LOOP;
          }
        }
      }
      if (check) {
        return true;
      }
    }
    return false;
  }

  static char[][] rotateShape90Degrees(char[][] shape, int n) {
    char[][] shape_ret = new char[n][n];
    for (int x = 0; x < n; x++) {
      for (int y = 0; y < n; y++) {
        shape_ret[y][n - 1 - x] = shape[x][y];
      }
    }
    return shape_ret;
  }
}
