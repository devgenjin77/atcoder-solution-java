/*
 * AtCoder Beginner Contest 216
 * C - Many Balls
 * https://atcoder.jp/contests/abc216/tasks/abc216_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc216/submissions/32476498
 *
 */

package contests.abc.abc21x.abc216.abc216_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final long n = Long.parseLong(br.readLine());
    br.close();
    final StringBuilder sb = new StringBuilder();
    long val = n;
    while (val > 1) {
      if ((val & 1) == 1) {
        sb.append('A');
      }
      sb.append('B');
      val >>= 1L;
    }
    sb.append('A');
    System.out.println(sb.reverse().toString());
  }
}
