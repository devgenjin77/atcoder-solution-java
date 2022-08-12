/*
 * AtCoder Beginner Contest 242
 * A - T-shirt
 * https://atcoder.jp/contests/abc242/tasks/abc242_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc242/submissions/33967544
 *
 * note:
 *
 */

package contests.abc.abc24x.abc242.abc242_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int a = Integer.parseInt(st.nextToken());
    final int b = Integer.parseInt(st.nextToken());
    final int c = Integer.parseInt(st.nextToken());
    final int x = Integer.parseInt(st.nextToken());
    br.close();
    double ans = 0.0;
    if (a >= x) {
      ans = 1.0;
    } else if (x > b) {
      ans = 0.0;
    } else {
      ans = (double) c / (b - a);
    }
    System.out.println(ans);
  }
}
