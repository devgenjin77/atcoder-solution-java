/*
 * AtCoder Beginner Contest 216
 * E - Amusement Park
 * https://atcoder.jp/contests/abc216/tasks/abc216_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc216/submissions/32482834
 *
 */

package contests.abc.abc21x.abc216.abc216_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final long k = Integer.parseInt(st.nextToken());
    StringTokenizer st_a = new StringTokenizer(br.readLine());
    final long[] array_a = new long[n];
    long sum_a = 0;
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
      sum_a += array_a[i];
    }
    br.close();

    Arrays.sort(array_a);
    long min_fun = 0;
    if (sum_a > k) {
      long ok = 0, ng = 2_000_000_001;
      while (ng - ok > 1) {
        long mid = (ok + ng) / 2;
        long cnt = 0;
        boolean isOk = false;
        for (int idx = n - 1; idx >= 0; idx--) {
          if (array_a[idx] >= mid) {
            cnt += array_a[idx] + 1 - mid;
            if (cnt >= k) {
              isOk = true;
              break;
            }
          } else {
            break;
          }
        }
        if (isOk) {
          ok = mid;
        } else {
          ng = mid;
        }
      }
      min_fun = ok;
    } else {
      min_fun = 1;
    }

    long ans = 0;
    long add_cnt = 0;
    for (int idx = n - 1; idx >= 0; idx--) {
      if (min_fun > array_a[idx]) {
        break;
      }
      ans += sum(min_fun, array_a[idx]);
      add_cnt += array_a[idx] - min_fun + 1;
    }
    ans -= Math.max(add_cnt - k, 0) * min_fun;
    System.out.println(ans);
  }

  static long sum(long a, long l) {
    //初項a,末項l,公差1の等差数列の和
    return ((a + l) * (l - a + 1)) / 2;
  }
}
