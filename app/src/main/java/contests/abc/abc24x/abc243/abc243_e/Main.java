/*
 * AtCoder Beginner Contest 243
 * E - Edge Deletion
 * https://atcoder.jp/contests/abc243/tasks/abc243_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc243/submissions/34913786
 *
 * note:
 * - ワーシャル–フロイド法
 *
 */

package contests.abc.abc24x.abc243.abc243_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static final long INF = 1L << 60;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final int[] array_a = new int[m];
    final int[] array_b = new int[m];
    final long[] array_c = new long[m];
    final long[][] dist = new long[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(dist[i], INF);
    }
    for (int i = 0; i < m; i++) {
      StringTokenizer st_abc = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st_abc.nextToken()) - 1;
      int b = Integer.parseInt(st_abc.nextToken()) - 1;
      long c = Long.parseLong(st_abc.nextToken());
      array_a[i] = a;
      array_b[i] = b;
      array_c[i] = c;
      dist[a][b] = c;
      dist[b][a] = c;
    }
    br.close();
    // ワーシャル–フロイド法
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]);
        }
      }
    }
    int ans = 0;
    for (int i = 0; i < m; i++) {
      boolean isFoundPath = false;
      for (int mid = 0; mid < n; mid++) {
        if (dist[array_a[i]][mid] + dist[mid][array_b[i]] <= array_c[i]) {
          isFoundPath = true;
          break;
        }
      }
      if (isFoundPath) {
        ans++;
      }
    }
    System.out.println(ans);
  }
}
