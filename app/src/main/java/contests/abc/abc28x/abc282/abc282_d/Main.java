/*
 * HHKBプログラミングコンテスト2022 Winter
 * （AtCoder Beginner Contest 282）
 * D - Make Bipartite 2
 * https://atcoder.jp/contests/abc282/tasks/abc282_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc282/submissions/37377269
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc282.abc282_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final List<List<Integer>> list_adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list_adj.add(new ArrayList<>());
    }
    final int[] degrees = new int[n];
    final int[] colors = new int[n];
    Arrays.fill(colors, -1);
    for (int i = 0; i < m; i++) {
      StringTokenizer st_uv = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st_uv.nextToken()) - 1;
      int v = Integer.parseInt(st_uv.nextToken()) - 1;
      list_adj.get(u).add(v);
      list_adj.get(v).add(u);
      degrees[u]++;
      degrees[v]++;
    }
    br.close();
    long ans = ((long) n * (n - 1) / 2) - m;
    long[] col01 = new long[2];
    boolean isBipartite = true;
    final Queue<Integer> queue = new ArrayDeque<>();
    main_loop:
    for (int i = 0; i < n; i++) {
      if (degrees[i] == 0 || colors[i] != -1) {
        continue;
      }
      queue.add(i);
      colors[i] = 0;
      col01[0] = 1;
      col01[1] = 0;
      while (!queue.isEmpty()) {
        int v = queue.poll();
        for (int next : list_adj.get(v)) {
          if (colors[next] == -1) {
            queue.add(next);
            colors[next] = (colors[v] + 1) % 2;
            col01[colors[next]]++;
          } else {
            if (colors[next] == colors[v]) {
              isBipartite = false;
              break main_loop;
            }
          }
        }
      }
      ans -= (col01[0] * (col01[0] - 1)) / 2;
      ans -= (col01[1] * (col01[1] - 1)) / 2;
    }
    System.out.println(isBipartite ? ans : 0);
  }
}
