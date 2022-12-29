/*
 * AtCoder Beginner Contest 259
 * A - Growth Record
 * https://atcoder.jp/contests/abc259/tasks/abc259_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc259/submissions/37618252
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc259.abc259_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final int x = Integer.parseInt(st.nextToken());
    final int t = Integer.parseInt(st.nextToken());
    final int d = Integer.parseInt(st.nextToken());
    br.close();
    System.out.println(x > m ? t - (d * (x - m)) : t);
  }
}
