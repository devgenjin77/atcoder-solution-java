/*
 * AtCoder Beginner Contest 204
 * A - Rock-paper-scissors
 * https://atcoder.jp/contests/abc204/tasks/abc204_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc204/submissions/37928111
 *
 * note:
 *
 *
 */

package contests.abc.abc20x.abc204.abc204_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int x = Integer.parseInt(st.nextToken());
    final int y = Integer.parseInt(st.nextToken());
    br.close();
    System.out.println(x == y ? x : 3 - x - y);
  }
}
