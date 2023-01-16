/*
 * AtCoder Beginner Contest 285
 * C - abc285_brutmhyhiizp
 * https://atcoder.jp/contests/abc285/tasks/abc285_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc285/submissions/38100789
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc285.abc285_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    br.close();
    long ans = 0;
    long pow = 1;
    for (int i = s.length() - 1; i >= 0; i--) {
      long x = (long) (s.charAt(i) - 'A') + 1;
      ans += pow * x;
      pow *= 26;
    }
    System.out.println(ans);
  }
}
