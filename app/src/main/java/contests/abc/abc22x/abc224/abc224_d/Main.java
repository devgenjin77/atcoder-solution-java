/*
 * AtCoder Beginner Contest 224
 * D - 8 Puzzle on Graph
 * https://atcoder.jp/contests/abc224/tasks/abc224_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc224/submissions/33557961
 *
 * note:
 * 8コマの配置を文字列表現で表し、BFSで探索する
 *
 */

package contests.abc.abc22x.abc224.abc224_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  final static String GOAL = "123456780";

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int m = Integer.parseInt(br.readLine());
    boolean[][] matrix_adj = new boolean[9][9];
    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken()) - 1;
      int v = Integer.parseInt(st.nextToken()) - 1;
      matrix_adj[u][v] = true;
      matrix_adj[v][u] = true;
    }
    StringTokenizer st_p = new StringTokenizer(br.readLine());
    StringBuilder sb_p = new StringBuilder("000000000");
    for (int i = 1; i <= 8; i++) {
      int p = Integer.parseInt(st_p.nextToken()) - 1;
      sb_p.setCharAt(p, (char) ('0' + i));
    }
    br.close();
    Map<String, Integer> cnt_map = new HashMap<>();
    Deque<String> queue = new ArrayDeque<>();
    int ans = -1;
    cnt_map.put(sb_p.toString(), 0);
    queue.add(sb_p.toString());
    while (!queue.isEmpty()) {
      String s = queue.poll();
      int cnt_now = cnt_map.get(s);
      if (GOAL.equals(s)) {
        ans = cnt_now;
        break;
      }
      int pos_0 = s.indexOf('0');
      for (int i = 0; i < 9; i++) {
        if (!matrix_adj[pos_0][i]) {
          continue;
        }
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(pos_0, s.charAt(i));
        sb.setCharAt(i, '0');
        String next_s = sb.toString();
        if (!cnt_map.containsKey(next_s)) {
          cnt_map.put(next_s, cnt_now + 1);
          queue.add(next_s);
        }
      }
    }
    System.out.println(ans);
  }
}
