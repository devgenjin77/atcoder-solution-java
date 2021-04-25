/*
 * ABC199
 * B - Intersection
 * https://atcoder.jp/contests/abc199/tasks/abc199_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc199/submissions/22068709
 */
package contests.abc.abc199.abc199_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer sta = new StringTokenizer(br.readLine());
    StringTokenizer stb = new StringTokenizer(br.readLine());
    br.close();
    int amax = Integer.MIN_VALUE;
    int bmin = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      amax = Math.max(Integer.parseInt(sta.nextToken()), amax);
      bmin = Math.min(Integer.parseInt(stb.nextToken()), bmin);
    }
    System.out.println(Math.max(0, bmin - amax + 1));
  }
}
