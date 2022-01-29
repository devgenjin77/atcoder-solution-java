/*
 * ABC236
 * E - Average and Median
 * https://atcoder.jp/contests/abc236/tasks/abc236_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc236/submissions/28853967
 *
 */
package contests.abc.abc236.abc236_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[] array_a = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    br.close();
    long[] array_b = new long[n];
    {
      //平均値
      long ok = 1000;
      long ng = 1_000_000_000_000l + 1;
      while (Math.abs(ok - ng) > 1) {
        long mid = (ok + ng) / 2;
        for (int i = 0; i < n; i++) {
          array_b[i] = (array_a[i] * 1000) - mid;
        }
        if (solve(array_b) < 0) {
          ng = mid;
        } else {
          ok = mid;
        }
      }
      System.out.println(ok * 0.001);
    }

    {
      //中央値
      long ok = 1;
      long ng = 1_000_000_000 + 1;
      while (Math.abs(ok - ng) > 1) {
        long mid = (ok + ng) / 2;
        for (int i = 0; i < n; i++) {
          array_b[i] = (array_a[i] >= mid ? 1 : -1);
        }
        if (solve(array_b) > 0) {
          ok = mid;
        } else {
          ng = mid;
        }
      }
      System.out.println(ok);
    }
  }

  static long solve(long[] array) {
    long val1 = 0;
    long val2 = array[0];
    for (int i = 1; i < array.length; i++) {
      long next_val1 = val2;
      long next_val2 = Math.max(val1, val2) + array[i];
      val1 = next_val1;
      val2 = next_val2;
    }
    return Math.max(val1, val2);
  }
}
