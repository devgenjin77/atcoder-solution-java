/*
 * AtCoder Beginner Contest 265
 * E - Warp
 * https://atcoder.jp/contests/abc265/tasks/abc265_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc265/submissions/35923147
 *
 * note:
 *
 *
 */

package contests.abc.abc26x.abc265.abc265_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  private static final long MOD = 998244353L;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final long a = Long.parseLong(st_a.nextToken());
    final long b = Long.parseLong(st_a.nextToken());
    final long c = Long.parseLong(st_a.nextToken());
    final long d = Long.parseLong(st_a.nextToken());
    final long e = Long.parseLong(st_a.nextToken());
    final long f = Long.parseLong(st_a.nextToken());
    final Map<Long, Set<Long>> map_ob = new HashMap<>();
    for (int i = 0; i < m; i++) {
      StringTokenizer st_xy = new StringTokenizer(br.readLine());
      long x = Long.parseLong(st_xy.nextToken());
      long y = Long.parseLong(st_xy.nextToken());
      if (!map_ob.containsKey(x)) {
        map_ob.put(x, new HashSet<>());
      }
      map_ob.get(x).add(y);
    }
    br.close();
    //dp[n][a][b]:=n回ワープしたうち、1つ目の移動がa回、2つ目の移動がb回
    long[][][] dp = new long[n + 1][n + 1][n + 1];
    dp[0][0][0] = 1;
    for (int all = 1; all <= n; all++) {
      for (int cnt_1 = 0; cnt_1 <= all; cnt_1++) {
        for (int cnt_2 = 0; cnt_1 + cnt_2 <= all; cnt_2++) {
          int cnt_3 = all - cnt_1 - cnt_2;
          long pos_x = (a * cnt_1) + (c * cnt_2) + (e * cnt_3);
          long pos_y = (b * cnt_1) + (d * cnt_2) + (f * cnt_3);
          if (map_ob.containsKey(pos_x) && map_ob.get(pos_x).contains(pos_y)) {
            dp[all][cnt_1][cnt_2] = 0;
          } else {
            if (cnt_1 > 0) {
              dp[all][cnt_1][cnt_2] += dp[all - 1][cnt_1 - 1][cnt_2];
            }
            if (cnt_2 > 0) {
              dp[all][cnt_1][cnt_2] += dp[all - 1][cnt_1][cnt_2 - 1];
            }
            if (cnt_3 > 0) {
              dp[all][cnt_1][cnt_2] += dp[all - 1][cnt_1][cnt_2];
            }
            dp[all][cnt_1][cnt_2] += MOD;
            dp[all][cnt_1][cnt_2] %= MOD;
          }
        }
      }
    }
    long ans = 0;
    for (int cnt1 = 0; cnt1 <= n; cnt1++) {
      for (int cnt2 = 0; cnt2 <= n; cnt2++) {
        ans += dp[n][cnt1][cnt2];
        ans %= MOD;
      }
    }
    System.out.println(ans);
  }
}
