/*
 * ABC241
 * F - Skate
 * https://atcoder.jp/contests/abc241/tasks/abc241_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc241/submissions/29814870
 *
 */
package contests.abc.abc241.abc241_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] head = br.readLine().split(" ");
    int h = Integer.parseInt(head[0]);
    int w = Integer.parseInt(head[1]);
    int n = Integer.parseInt(head[2]);

    String[] start = br.readLine().split(" ");
    int sx = Integer.parseInt(start[0]);
    int sy = Integer.parseInt(start[1]);

    String[] goal = br.readLine().split(" ");
    int gx = Integer.parseInt(goal[0]);
    int gy = Integer.parseInt(goal[1]);

    Map<Position, Integer> cost_map = new HashMap<>();
    Map<Integer, TreeSet<Integer>> map_x = new HashMap<>();
    Map<Integer, TreeSet<Integer>> map_y = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String[] obj = br.readLine().split(" ");
      int x = Integer.parseInt(obj[0]);
      int y = Integer.parseInt(obj[1]);
      if (map_x.containsKey(x)) {
        map_x.get(x).add(y);
      } else {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(y);
        map_x.put(x, set);
      }

      if (map_y.containsKey(y)) {
        map_y.get(y).add(x);
      } else {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(x);
        map_y.put(y, set);
      }
    }
    br.close();

    Position pos_start = new Position(sx, sy);
    Queue<Position> queue = new ArrayDeque<>();
    queue.add(pos_start);
    cost_map.put(pos_start, 0);
    while (!queue.isEmpty()) {
      Position now_p = queue.poll();
      int now_cost = cost_map.get(now_p);

      //Up, Down
      if (map_y.containsKey(now_p.pos_y)) {
        //Up
        Integer next_up_x = map_y.get(now_p.pos_y).lower(now_p.pos_x);
        if (next_up_x != null && next_up_x + 1 < now_p.pos_x) {
          Position next_pos = new Position(next_up_x + 1, now_p.pos_y);
          if (cost_map.getOrDefault(next_pos, Integer.MAX_VALUE) > now_cost + 1) {
            cost_map.put(next_pos, now_cost + 1);
            queue.add(next_pos);
          }
        }
        //Down
        Integer next_down_x = map_y.get(now_p.pos_y).higher(now_p.pos_x);
        if (next_down_x != null && next_down_x - 1 > now_p.pos_x) {
          Position next_pos = new Position(next_down_x - 1, now_p.pos_y);
          if (cost_map.getOrDefault(next_pos, Integer.MAX_VALUE) > now_cost + 1) {
            cost_map.put(next_pos, now_cost + 1);
            queue.add(next_pos);
          }
        }
      }
      //Left, Right
      if (map_x.containsKey(now_p.pos_x)) {
        //Left
        Integer next_left_y = map_x.get(now_p.pos_x).lower(now_p.pos_y);
        if (next_left_y != null && next_left_y + 1 < now_p.pos_y) {
          Position next_pos = new Position(now_p.pos_x, next_left_y + 1);
          if (cost_map.getOrDefault(next_pos, Integer.MAX_VALUE) > now_cost + 1) {
            cost_map.put(next_pos, now_cost + 1);
            queue.add(next_pos);
          }
        }
        //Right
        Integer next_right_y = map_x.get(now_p.pos_x).higher(now_p.pos_y);
        if (next_right_y != null && next_right_y - 1 > now_p.pos_y) {
          Position next_pos = new Position(now_p.pos_x, next_right_y - 1);
          if (cost_map.getOrDefault(next_pos, Integer.MAX_VALUE) > now_cost + 1) {
            cost_map.put(next_pos, now_cost + 1);
            queue.add(next_pos);
          }
        }
      }
    }
    Position pos_goal = new Position(gx, gy);
    System.out.println(cost_map.getOrDefault(pos_goal, -1));
  }

  static class Position {

    int pos_x, pos_y;

    Position(int pos_x, int pos_y) {
      this.pos_x = pos_x;
      this.pos_y = pos_y;
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof Position)) {
        return false;
      } else {
        Position p = (Position) o;
        return pos_x == p.pos_x && pos_y == p.pos_y;
      }
    }

    @Override
    public int hashCode() {
      return Objects.hash(pos_x, pos_y);
    }
  }
}
