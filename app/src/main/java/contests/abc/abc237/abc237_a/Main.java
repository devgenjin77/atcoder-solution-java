/*
 * ABC237
 * A - Not Overflow
 * https://atcoder.jp/contests/abc237/tasks/abc237_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc237/submissions/28976348
 *
 */
package contests.abc.abc237.abc237_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    br.close();
    long lim = 1l << 31;
    System.out.println(n >= -lim && n < lim ? "Yes" : "No");
  }
}
