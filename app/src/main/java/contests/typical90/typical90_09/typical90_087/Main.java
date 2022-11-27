/*
 * 競プロ典型90問
 * 087 - Chokudai's Demand（★5）
 * https://atcoder.jp/contests/typical90/tasks/typical90_ci
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/36847322
 *
 * note:
 * - 二分探索、ワーシャル・フロイド法
 *
 */

package contests.typical90.typical90_09.typical90_087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static final long INF = (long) 1e9 + 1L;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final long p = Long.parseLong(st.nextToken());
    final int k = Integer.parseInt(st.nextToken());
    final long[][] array_a = new long[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st_a = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        array_a[i][j] = Long.parseLong(st_a.nextToken());
      }
    }
    br.close();
    long l = func(k, p, n, array_a);
    long r = k == 0 ? INF : func(k - 1, p, n, array_a);
    if (l == INF && r == INF) {
      System.out.println(0);
    } else if (r == INF) {
      System.out.println("Infinity");
    } else {
      System.out.println(r - l);
    }
  }


  static long func(int k, long p, int n, long[][] dist) {
    //p以下で行ける(i,j)の組の個数がk以下になる最小のx
    long[][] tmp = new long[n][n];
    long ok = INF, ng = 0;
    while (ok - ng > 1) {
      long x = (ok + ng) / 2;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          tmp[i][j] = dist[i][j] == -1 ? x : dist[i][j];
        }
      }
      //ワーシャルフロイド法
      for (int mid = 0; mid < n; mid++) {
        for (int from = 0; from < n; from++) {
          for (int to = 0; to < n; to++) {
            tmp[from][to] = Math.min(tmp[from][mid] + tmp[mid][to], tmp[from][to]);
          }
        }
      }
      int cnt = 0;
      for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
          if (tmp[i][j] <= p) {
            cnt++;
          }
        }
      }
      if (cnt <= k) {
        ok = x;
      } else {
        ng = x;
      }
    }
    return ok;
  }
}
