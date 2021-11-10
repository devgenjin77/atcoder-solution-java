/*
 * ABC226
 * C - Martial artist
 * https://atcoder.jp/contests/abc226/tasks/abc226_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc226/submissions/27168010
 */
package contests.abc.abc226.abc226_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Set<Integer> learned_move_set = new HashSet<>();
    long[] learn_times = new long[n];
    List<List<Integer>> required_moves = new ArrayList<>(n);
    for (int i = 0; i < n; i++) {
      required_moves.add(new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
      String[] data = br.readLine().split(" ");
      learn_times[i] = Long.parseLong(data[0]);
      int k = Integer.parseInt(data[1]);
      for (int idx = 2; idx < k + 2; idx++) {
        required_moves.get(i).add(Integer.parseInt(data[idx]) - 1);
      }
    }
    br.close();
    long ans = 0;
    Queue<Integer> queue = new ArrayDeque<>();
    queue.add(n - 1);
    while (!queue.isEmpty()) {
      int move_no = queue.poll();
      if (!learned_move_set.contains(move_no)) {
        ans += learn_times[move_no];
        learned_move_set.add(move_no);
      }
      for (int add_move_no : required_moves.get(move_no)) {
        if (!learned_move_set.contains(add_move_no)) {
          queue.add(add_move_no);
        }
      }
    }
    System.out.println(ans);
  }
}
