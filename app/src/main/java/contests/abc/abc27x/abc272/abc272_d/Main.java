/*
 * AtCoder Beginner Contest 272
 * D - Root M Leaper
 * https://atcoder.jp/contests/abc272/tasks/abc272_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc272/submissions/35847822
 *
 * note:
 *
 *
 */

package contests.abc.abc27x.abc272.abc272_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  private static final int[] d_i = {-1, -1, 1, 1};

  private static final int[] d_j = {-1, 1, -1, 1};

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    br.close();
    final List<IntPair> move_pairs = new ArrayList<>();
    final int sqrt_m = (int) Math.sqrt(m);
    int dist_j = sqrt_m;
    for (int dist_i = 0; dist_i <= sqrt_m; dist_i++) {
      int dist = (dist_i * dist_i) + (dist_j * dist_j);
      while (dist > m && dist_j > 0) {
        dist_j--;
        dist = (dist_i * dist_i) + (dist_j * dist_j);
      }
      if (dist == m) {
        move_pairs.add(new IntPair(dist_i, dist_j));
      }
    }
    final int[][] costs = new int[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(costs[i], n * n);
    }
    final Queue<IntPair> queue = new ArrayDeque<>();
    queue.add(new IntPair(0, 0));
    costs[0][0] = 0;
    while (!queue.isEmpty()) {
      IntPair cur = queue.poll();
      int cur_cost = costs[cur.first][cur.second];
      for (IntPair move_pair : move_pairs) {
        for (int i = 0; i < 4; i++) {
          int next_i = cur.first + (d_i[i] * move_pair.first);
          int next_j = cur.second + (d_j[i] * move_pair.second);
          if (next_i >= 0 && next_i < n && next_j >= 0 && next_j < n
              && costs[next_i][next_j] > cur_cost + 1) {
            costs[next_i][next_j] = cur_cost + 1;
            queue.add(new IntPair(next_i, next_j));
          }
        }
      }
    }
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      for (int cost : costs[i]) {
        sb.append(cost == n * n ? -1 : cost).append(' ');
      }
      pw.println(sb.deleteCharAt(sb.length() - 1));
    }
    pw.close();
  }

  static class IntPair {

    int first, second;

    public IntPair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }
}
