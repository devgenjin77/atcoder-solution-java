/*
 * ABC236
 * D - Dance
 * https://atcoder.jp/contests/abc236/tasks/abc236_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc236/submissions/28849778
 *
 */
package contests.abc.abc236.abc236_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static int n;
  static boolean[] used;
  static int ans;
  static int[][] comp_tbl;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    used = new boolean[2 * n];
    ans = 0;
    comp_tbl = new int[2 * n][2 * n];
    for (int i = 0; i < (2 * n) - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = i + 1; j < (2 * n); j++) {
        comp_tbl[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    br.close();
    dfs(0, 0, 0);
    System.out.println(ans);
    return;
  }

  static void dfs(int level, int pair1, int comp) {
    if (level == n) {
      ans = Math.max(comp, ans);
      return;
    }
    if (used[pair1] == true) {
      dfs(level, pair1 + 1, comp);
    } else {
      used[pair1] = true;
      for (int pair2 = pair1 + 1; pair2 < (2 * n); pair2++) {
        if (used[pair2] == false) {
          used[pair2] = true;
          dfs(level + 1, pair1 + 1, comp ^ comp_tbl[pair1][pair2]);
          used[pair2] = false;
        }
      }
      used[pair1] = false;
    }
  }
}
