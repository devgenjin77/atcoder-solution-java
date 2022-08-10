/*
 * AtCoder Beginner Contest 236
 * D - Dance
 * https://atcoder.jp/contests/abc236/tasks/abc236_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc236/submissions/33925616
 *
 * note:
 * DFSで全探索する。組み合わせのうち、順列全探索すると数が多くなるので注意
 *
 */

package contests.abc.abc23x.abc236.abc236_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int n;

  static int ans;

  static int[][] comp_tbl;

  static boolean[] used;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    final int n2 = n * 2;
    ans = 0;
    comp_tbl = new int[n2][n2];
    used = new boolean[n2];
    Arrays.fill(used, false);
    for (int i = 0; i < n2 - 1; i++) {
      StringTokenizer st_a = new StringTokenizer(br.readLine());
      for (int j = i + 1; j < n2; j++) {
        comp_tbl[i][j] = Integer.parseInt(st_a.nextToken());
      }
    }
    br.close();
    dfs(0, 0, 0);
    System.out.println(ans);
  }

  static void dfs(int pair1, int now_x, int level) {
    if (level == n) {
      ans = Math.max(now_x, ans);
      return;
    }
    if (used[pair1]) {
      dfs(pair1 + 1, now_x, level);
    } else {
      used[pair1] = true;
      for (int pair2 = pair1 + 1; pair2 < (n * 2); pair2++) {
        if (!used[pair2]) {
          used[pair2] = true;
          dfs(pair1 + 1, now_x ^ comp_tbl[pair1][pair2], level + 1);
          used[pair2] = false;
        }
      }
      used[pair1] = false;
    }
  }
}
