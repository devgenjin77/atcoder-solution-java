/*
 * ABC230
 * A - AtCoder Quiz 3
 * https://atcoder.jp/contests/abc230/tasks/abc230_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc230/submissions/27709100
 */
package contests.abc.abc230.abc230_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.close();
    if (n >= 42) {
      n++;
    }
    System.out.printf("AGC%03d%n", n);
  }
}
