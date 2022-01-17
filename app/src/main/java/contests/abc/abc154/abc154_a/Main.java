/*
 * ABC154
 * A - Remaining Balls
 * https://atcoder.jp/contests/abc154/tasks/abc154_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc154/submissions/28605932
 *
 */
package contests.abc.abc154.abc154_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String s = st.nextToken();
    String t = st.nextToken();
    StringTokenizer ab = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(ab.nextToken());
    int b = Integer.parseInt(ab.nextToken());
    String u = br.readLine();
    br.close();
    if (s.equals(u)) {
      a -= 1;
    } else if (t.equals(u)) {
      b -= 1;
    }
    System.out.printf("%d %d%n", a, b);
    return;
  }
}
