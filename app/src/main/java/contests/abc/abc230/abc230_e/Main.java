/*
 * ABC230
 * E - Fraction Floor Sum
 * https://atcoder.jp/contests/abc230/tasks/abc230_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc230/submissions/27805083
 */
package contests.abc.abc230.abc230_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    br.close();
    long ans = 0;
    long left = 1;
    while (left <= n) {
      long k = n / left;
      long right = n / k;
      ans += k * (right - left + 1);
      left = right + 1;
    }
    System.out.println(ans);
  }
}
