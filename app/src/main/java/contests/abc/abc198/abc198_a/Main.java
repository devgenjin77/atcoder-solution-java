/*
 * ABC198
 * A - Div
 * https://atcoder.jp/contests/abc198/tasks/abc198_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc198/submissions/21719720
 */
package contests.abc.abc198.abc198_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.close();
    System.out.println(n - 1);
  }
}