/*
 * ABC224
 * D - 8 Puzzle on Graph
 * https://atcoder.jp/contests/abc224/tasks/abc224_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc224/submissions/26881790
 */
package contests.abc.abc224.abc224_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {

  static final String GOAL = "123456780";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine());
    List<List<Integer>> edge_list = new ArrayList<>(9);
    for (int i = 0; i < 9; i++) {
      edge_list.add(new ArrayList<>());
    }
    for (int i = 0; i < m; i++) {
      String[] edge = br.readLine().split(" ");
      int p1 = Integer.parseInt(edge[0]) - 1;
      int p2 = Integer.parseInt(edge[1]) - 1;
      edge_list.get(p1).add(p2);
      edge_list.get(p2).add(p1);
    }
    int[] pos_of_pieces = Stream.of(br.readLine().split(" ")).mapToInt(v -> Integer.parseInt(v) - 1)
        .toArray();
    br.close();
    StringBuilder sb = new StringBuilder("000000000");
    for (int idx = 0; idx < 8; idx++) {
      sb.setCharAt(pos_of_pieces[idx], (char) ('0' + idx + 1));
    }
    String start = sb.toString();
    HashMap<String, Integer> cnt_map = new HashMap<>();
    cnt_map.put(start, 0);
    Queue<String> queue = new ArrayDeque<>();
    queue.add(start);
    while (!queue.isEmpty()) {
      String status = queue.poll();
      int cnt_of_next_status = cnt_map.get(status) + 1;
      int idx_0 = status.indexOf('0');
      for (int idx_next : edge_list.get(idx_0)) {
        String next_status = swap(status, idx_0, idx_next);
        if (!cnt_map.containsKey(next_status)
            || cnt_map.get(next_status) > cnt_of_next_status) {
          cnt_map.put(next_status, cnt_of_next_status);
          queue.add(next_status);
        }
      }
    }
    System.out.println(cnt_map.getOrDefault(GOAL, -1));
  }

  static String swap(String str, int i, int j) {
    char[] chars = str.toCharArray();
    char tmp = chars[i];
    chars[i] = chars[j];
    chars[j] = tmp;
    return new String(chars);
  }
}
