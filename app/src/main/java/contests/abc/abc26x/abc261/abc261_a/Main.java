/*
 * AtCoder Beginner Contest 261
 * A - Intersection
 * https://atcoder.jp/contests/abc261/tasks/abc261_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc261/submissions/37639761
 *
 * note:
 *
 *
 */

package contests.abc.abc26x.abc261.abc261_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int l1 = Integer.parseInt(st.nextToken());
    final int r1 = Integer.parseInt(st.nextToken());
    final int l2 = Integer.parseInt(st.nextToken());
    final int r2 = Integer.parseInt(st.nextToken());
    br.close();
    final int max_l = Math.max(l1, l2);
    final int min_r = Math.min(r1, r2);
    System.out.println(Math.max(min_r - max_l, 0));
  }
}
