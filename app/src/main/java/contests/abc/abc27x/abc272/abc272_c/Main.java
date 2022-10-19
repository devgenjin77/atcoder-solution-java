/*
 * AtCoder Beginner Contest 272
 * C - Max Even
 * https://atcoder.jp/contests/abc272/tasks/abc272_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc272/submissions/35794101
 *
 * note:
 *
 *
 */

package contests.abc.abc27x.abc272.abc272_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  private static final long INF = (long) 1e9;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    br.close();
    //big2[i][j]:= i=a%2 で大きい方から2つ保管
    final long[][] big2 = new long[2][2];
    Arrays.fill(big2[0], -INF);
    Arrays.fill(big2[1], -INF);
    for (int i = 0; i < n; i++) {
      long a = Long.parseLong(st_a.nextToken());
      int m = (int) (a % 2);
      if (a > big2[m][0]) {
        big2[m][1] = big2[m][0];
        big2[m][0] = a;
      } else if (a > big2[m][1]) {
        big2[m][1] = a;
      }
    }
    long ans = Math.max(big2[0][0] + big2[0][1], big2[1][0] + big2[1][1]);
    System.out.println(Math.max(ans, -1));
  }
}
