/*
 * ABC230
 * D - Destroyer Takahashi
 * https://atcoder.jp/contests/abc230/tasks/abc230_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc230/submissions/27785027
 */
package contests.abc.abc230.abc230_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] head = br.readLine().split(" ");
    int n = Integer.parseInt(head[0]);
    long d = Long.parseLong(head[1]);
    List<Wall> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      String[] data = br.readLine().split(" ");
      Wall wall = new Wall(Long.parseLong(data[0]), Long.parseLong(data[1]));
      list.add(wall);
    }
    br.close();
    Collections.sort(list, Comparator.comparingLong(w -> w.r));

    int ans = 0;
    long pos_x = -1;
    for (int i = 0; i < list.size(); i++) {
      Wall wall = list.get(i);
      if (pos_x < wall.l) {
        ans += 1;
        pos_x = wall.r + d - 1;
      }
    }
    System.out.println(ans);
  }

  static class Wall {

    long l, r;

    Wall(long l, long r) {
      this.l = l;
      this.r = r;
    }
  }
}
