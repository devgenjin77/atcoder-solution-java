/*
 * AtCoder Beginner Contest 244
 * B - Go Straight and Turn Right
 * https://atcoder.jp/contests/abc244/tasks/abc244_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc244/submissions/35082129
 *
 * note:
 *
 */

package contests.abc.abc24x.abc244.abc244_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  //東南西北向きの順番で定義する
  private static final int[] dx = {1, 0, -1, 0};

  private static final int[] dy = {0, -1, 0, 1};

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String t = br.readLine();
    br.close();
    int pos_x = 0, pos_y = 0, now_dir = 0;
    for (int i = 0; i < n; i++) {
      char c = t.charAt(i);
      if (c == 'S') {
        pos_x += dx[now_dir];
        pos_y += dy[now_dir];
      } else if (c == 'R') {
        now_dir = (now_dir + 1) % 4;
      }
    }
    System.out.println(String.format("%d %d", pos_x, pos_y));
  }
}
