/*
 * ABC246
 * D - 2-variable Function
 * https://atcoder.jp/contests/abc246/tasks/abc246_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc246/submissions/30696081
 *
 */

package contests.abc.abc246.abc246_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    br.close();
    long limit = (long) Math.ceil(Math.cbrt(n));
    long ans = Long.MAX_VALUE;
    long a = 0, b = limit;
    while(a <= b) {
      long val = func(a, b);
      if(val > n) {
        ans = Math.min(val, ans);
        b--;
      } else if(val < n) {
        a++;
      } else {
        ans = val;
        break;
      }
    }
    System.out.println(ans);
  }

  static long func(long a, long b) {
    return (a * a * a) + (a * a * b) + (a * b * b) + (b * b * b);
  }
}
