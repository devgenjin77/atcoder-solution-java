/*
 * AtCoder Beginner Contest 278
 * F - Shiritori
 * https://atcoder.jp/contests/abc278/tasks/abc278_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc278/submissions/36742644
 *
 * note:
 *
 *
 */

package contests.abc.abc27x.abc278.abc278_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String[] words = new String[n];
    for (int i = 0; i < n; i++) {
      words[i] = br.readLine();
    }
    ABC278FSolver solver = new ABC278FSolver(n, words);
    br.close();
    System.out.println(solver.solve() ? "First" : "Second");
  }

  static class ABC278FSolver {

    final int n;

    final String[] words;

    final boolean[][] mtx_adj;

    final int[][] memo;

    public ABC278FSolver(int n, String[] words) {
      this.n = n;
      this.words = words;
      this.mtx_adj = new boolean[n][n];
      this.memo = new int[n][1 << n];

      for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
          if (words[i].charAt(0) == words[j].charAt(words[j].length() - 1)) {
            mtx_adj[j][i] = true;
          }

          if (words[j].charAt(0) == words[i].charAt(words[i].length() - 1)) {
            mtx_adj[i][j] = true;
          }
        }
      }
    }

    public boolean solve() {
      for (int i = 0; i < n; i++) {
        if (dfs(i, (1 << i), false)) {
          return true;
        }
      }
      return false;
    }

    private boolean dfs(int prev_select, int bit_s, boolean isFirst) {
      if (memo[prev_select][bit_s] == 1) {
        return isFirst;
      }
      for (int next_select = 0; next_select < this.n; next_select++) {
        if (!mtx_adj[prev_select][next_select] || ((bit_s >> next_select) & 1) == 1) {
          continue;
        }
        int next_bit = bit_s | (1 << next_select);
        if (dfs(next_select, next_bit, !isFirst) == isFirst) {
          memo[prev_select][bit_s] = 1;
          return isFirst;
        }
      }
      memo[prev_select][bit_s] = 0;
      return !isFirst;
    }
  }
}
