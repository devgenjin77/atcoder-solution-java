/*
 * AtCoder Beginner Contest 244
 * F - Shortest Good Path
 * https://atcoder.jp/contests/abc244/tasks/abc244_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc244/submissions/35086291
 *
 * note:
 * 集合DP
 */

package contests.abc.abc24x.abc244.abc244_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final boolean[][] mtx_adj = new boolean[n][n];
    for (int i = 0; i < m; i++) {
      StringTokenizer st_uv = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st_uv.nextToken()) - 1;
      int v = Integer.parseInt(st_uv.nextToken()) - 1;
      mtx_adj[u][v] = true;
      mtx_adj[v][u] = true;
    }
    br.close();
    //dp[s][j]:=状態sの時、今居る頂点がjであるときの最短パスの長さ
    final int[][] dp = new int[1 << n][n];
    for (int bit = 0; bit < 1 << n; bit++) {
      Arrays.fill(dp[bit], Integer.MAX_VALUE);
    }
    final Queue<Pair> queue = new ArrayDeque<>();
    for (int i = 0; i < n; i++) {
      queue.add(new Pair(1 << i, i));
      dp[1 << i][i] = 1;
    }
    while (!queue.isEmpty()) {
      Pair p = queue.poll();
      for (int next_v = 0; next_v < n; next_v++) {
        if (!mtx_adj[p.v][next_v]) {
          continue;
        }
        int next_bit = p.s ^ (1 << next_v);
        if (dp[next_bit][next_v] > dp[p.s][p.v] + 1) {
          dp[next_bit][next_v] = dp[p.s][p.v] + 1;
          queue.add(new Pair(next_bit, next_v));
        }
      }
    }
    long ans = 0;
    for (int bit = 1; bit < (1 << n); bit++) {
      int min_len = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        min_len = Math.min(dp[bit][i], min_len);
      }
      ans += min_len;
    }
    System.out.println(ans);
  }

  static final class Pair {

    private final int s;
    private final int v;

    public Pair(int s, int v) {
      this.s = s;
      this.v = v;
    }
  }
}
