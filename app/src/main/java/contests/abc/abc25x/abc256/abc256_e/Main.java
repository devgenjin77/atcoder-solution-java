/*
 * 東京海上日動プログラミングコンテスト2022
 * （AtCoder Beginner Contest 256）
 * E - Takahashi's Anguish
 * https://atcoder.jp/contests/abc256/tasks/abc256_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc256/submissions/38186281
 *
 */

package contests.abc.abc25x.abc256.abc256_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_x = new StringTokenizer(br.readLine());
    final StringTokenizer st_c = new StringTokenizer(br.readLine());
    final int[] array_x = new int[n];
    final long[] array_c = new long[n];
    final int[] in_degree = new int[n];
    for (int i = 0; i < n; i++) {
      array_x[i] = Integer.parseInt(st_x.nextToken()) - 1;
      in_degree[array_x[i]]++;
      array_c[i] = Integer.parseInt(st_c.nextToken());
    }
    br.close();
    final boolean[] visited = new boolean[n];
    //閉路外を通過済みにする
    for (int i = 0; i < n; i++) {
      if (in_degree[i] > 0 || visited[i]) {
        continue;
      }
      int cur = i;
      do {
        visited[cur] = true;
        cur = array_x[cur];
        in_degree[cur]--;
      } while (in_degree[cur] == 0);
    }
    long ans = 0;
    for (int i = 0; i < n; i++) {
      if (visited[i]) {
        continue;
      }
      int cur = i;
      long wk_c = Long.MAX_VALUE / 2; //INF
      while (!visited[cur]) {
        visited[cur] = true;
        wk_c = Math.min(array_c[cur], wk_c);
        cur = array_x[cur];
      }
      ans += wk_c;
    }
    System.out.println(ans);
  }
}
