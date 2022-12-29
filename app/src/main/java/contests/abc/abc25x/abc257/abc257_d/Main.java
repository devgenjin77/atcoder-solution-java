/*
 * 日鉄ソリューションズプログラミングコンテスト2022
 * （AtCoder Beginner Contest 257）
 * D - Jumping Takahashi 2
 * https://atcoder.jp/contests/abc257/tasks/abc257_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc257/submissions/37614502
 *
 */

package contests.abc.abc25x.abc257.abc257_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final long[] array_x = new long[n];
    final long[] array_y = new long[n];
    final long[] array_p = new long[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      array_x[i] = Long.parseLong(st.nextToken());
      array_y[i] = Long.parseLong(st.nextToken());
      array_p[i] = Long.parseLong(st.nextToken());
    }
    br.close();

    final long[][] mtx_dist = new long[n][n];
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        mtx_dist[i][j] = Math.abs(array_x[i] - array_x[j]) + Math.abs(array_y[i] - array_y[j]);
        mtx_dist[j][i] = mtx_dist[i][j];
      }
    }
    long ng = 0L, ok = 4_000_000_000L;
    //二分探索
    while (ok - ng > 1) {
      long mid = (ok + ng) / 2;
      boolean isOK = false;
      for (int start = 0; start < n; start++) {
        boolean[] isVisit = new boolean[n];
        isVisit[start] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        while (!queue.isEmpty()) {
          int current = queue.poll();
          for (int next = 0; next < n; next++) {
            if (isVisit[next] || current == next) {
              continue;
            }
            if (mid * array_p[current] >= mtx_dist[current][next]) {
              isVisit[next] = true;
              queue.add(next);
            }
          }
        }
        boolean isALL = true;
        for (int i = 0; i < n; i++) {
          if (!isVisit[i]) {
            isALL = false;
            break;
          }
        }
        if (isALL) {
          isOK = true;
          break;
        }
      }
      if (isOK) {
        ok = mid;
      } else {
        ng = mid;
      }
    }
    System.out.println(ok);
  }
}
