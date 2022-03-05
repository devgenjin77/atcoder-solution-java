/*
 * ABC240
 * F - Sum Sum Max
 * https://atcoder.jp/contests/abc240/tasks/abc240_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc240/submissions/29851390
 *
 */
package contests.abc.abc240.abc240_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    int t = Integer.parseInt(br.readLine());
    for (int cnt = 1; cnt <= t; cnt++) {
      String[] nm = br.readLine().split(" ");
      int n = Integer.parseInt(nm[0]);
      int m = Integer.parseInt(nm[1]);
      long[] x = new long[n];
      long[] y = new long[n];
      for (int i = 0; i < n; i++) {
        String[] xy = br.readLine().split(" ");
        x[i] = Long.parseLong(xy[0]);
        y[i] = Long.parseLong(xy[1]);
      }
      pw.println(solve(n, m, x, y));
    }
    pw.close();
    br.close();
  }

  static long solve(int n, int m, long[] x, long[] y) {
    long ans = x[0];
    long[] dp_a = new long[n];
    long[] dp_b = new long[n];
    dp_b[0] = x[0] * y[0];
    dp_a[0] = sumOfArithmeticProgression(y[0], x[0], x[0]);
    ans = Math.max(dp_a[0], ans);
    for (int i = 1; i < n; i++) {
      dp_b[i] = dp_b[i - 1] + (x[i] * y[i]);
      dp_a[i] = dp_a[i - 1] + sumOfArithmeticProgression(y[i], dp_b[i - 1] + x[i], x[i]);
      if (dp_b[i] >= 0) {
        ans = Math.max(dp_a[i], ans);
      } else {
        long tmp_a = dp_b[i - 1] + x[i];
        if (tmp_a > 0) {
          long abs_x = Math.abs(x[i]);
          long tmp_n = (tmp_a + abs_x - 1) / abs_x;
          ans = Math.max(dp_a[i - 1] + sumOfArithmeticProgression(tmp_n, tmp_a, x[i]), ans);
        }
      }
    }
    return ans;
  }

  static long sumOfArithmeticProgression(long n, long a, long d) {
    return n * ((2 * a) + ((n - 1) * d)) / 2;
  }
}
