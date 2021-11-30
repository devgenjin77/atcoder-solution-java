/*
 * ARC130
 * B - Colorful Lines
 * https://atcoder.jp/contests/arc130/tasks/arc130_b
 *
 * verified:
 * - https://atcoder.jp/contests/arc130/submissions/27608391
 */
package contests.arc.arc130.arc130_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] head = br.readLine().split(" ");
    int h = Integer.parseInt(head[0]);
    int w = Integer.parseInt(head[1]);
    int c = Integer.parseInt(head[2]);
    int q = Integer.parseInt(head[3]);
    int[][] queries = new int[q][3];
    for (int i = 0; i < q; i++) {
      String[] query = br.readLine().split(" ");
      queries[i][0] = Integer.parseInt(query[0]);
      queries[i][1] = Integer.parseInt(query[1]);
      queries[i][2] = Integer.parseInt(query[2]) - 1;
    }
    br.close();
    Set<Integer> h_pos_map = new HashSet<>();
    Set<Integer> w_pos_map = new HashSet<>();
    long[] colors = new long[c];
    for (int query_idx = q - 1; query_idx >= 0; query_idx--) {
      if (queries[query_idx][0] == 1) {
        //行を塗る
        if (h_pos_map.add(queries[query_idx][1])) {
          colors[queries[query_idx][2]] += w - w_pos_map.size();
        }
      } else {
        //列を塗る
        if (w_pos_map.add(queries[query_idx][1])) {
          colors[queries[query_idx][2]] += h - h_pos_map.size();
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    sb.append(colors[0]);
    for (int i = 1; i < c; i++) {
      sb.append(" ").append(colors[i]);
    }
    System.out.println(sb.toString());
  }
}
