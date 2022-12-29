/*
 * AtCoder Beginner Contest 259
 * B - Counterclockwise Rotation
 * https://atcoder.jp/contests/abc259/tasks/abc259_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc259/submissions/37618674
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc259.abc259_b;

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
    final int d = Integer.parseInt(st.nextToken());
    br.close();
    double x = (a * Math.cos(Math.toRadians(d))) - (b * Math.sin(Math.toRadians(d)));
    double y = (a * Math.sin(Math.toRadians(d))) + (b * Math.cos(Math.toRadians(d)));
    System.out.println(x + " " + y);
  }
}
