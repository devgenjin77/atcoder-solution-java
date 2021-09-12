/*
 * ABC218
 * A - Weather Forecast
 * https://atcoder.jp/contests/abc218/tasks/abc218_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc218/submissions/25747332
 */
package contests.abc.abc218.abc218_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();
    br.close();
    System.out.println(s.charAt(n - 1) == 'o' ? "Yes" : "No");
  }
}
