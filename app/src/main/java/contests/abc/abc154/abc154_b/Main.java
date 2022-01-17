/*
 * ABC154
 * B - I miss you...
 * https://atcoder.jp/contests/abc154/tasks/abc154_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc154/submissions/28606159
 *
 */
package contests.abc.abc154.abc154_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    String s = br.readLine();
    br.close();
    System.out.printf(s.replaceAll(".", "x"));
    return;
  }
}
