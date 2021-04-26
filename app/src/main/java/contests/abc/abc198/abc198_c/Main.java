/*
 * ABC198
 * C - Compass Walking
 * https://atcoder.jp/contests/abc198/tasks/abc198_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc198/submissions/21803224
 */
package contests.abc.abc198.abc198_c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long r = Long.parseLong(st.nextToken());
    long x = Long.parseLong(st.nextToken());
    long y = Long.parseLong(st.nextToken());
    br.close();
    System.out.println(solve(r, x, y));
  }

  static long solve(long r, long x, long y) {
    long dist_p = (x * x) + (y * y);
    long r_p = r * r;
    if (r_p == dist_p) {
      return 1;
    }
    if (r_p > dist_p) {
      return 2;
    }
    return (long) Math.ceil(Math.sqrt(dist_p) / Math.sqrt(r_p));
  }
}
