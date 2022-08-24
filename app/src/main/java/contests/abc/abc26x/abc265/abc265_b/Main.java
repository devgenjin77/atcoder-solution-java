/*
 * AtCoder Beginner Contest 265
 * B - Explore
 * https://atcoder.jp/contests/abc265/tasks/abc265_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc265/submissions/34312477
 *
 * note:
 *
 *
 */

package contests.abc.abc26x.abc265.abc265_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final long t = Long.parseLong(st.nextToken());
    final long[] array_a = new long[n];
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    for (int i = 0; i < n - 1; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
    }
    final long[] array_x = new long[n];
    for (int i = 0; i < m; i++) {
      StringTokenizer st_xy = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st_xy.nextToken()) - 1;
      long y = Long.parseLong(st_xy.nextToken());
      array_x[x] = y;
    }
    br.close();

    long remain = t;
    int now = 0;
    boolean isOk = true;
    while (now < n) {
      remain += array_x[now];
      if (remain > array_a[now]) {
        remain -= array_a[now];
        now++;
      } else {
        isOk = false;
        break;
      }
    }
    System.out.println(isOk ? "Yes" : "No");
  }
}
