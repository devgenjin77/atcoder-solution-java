/*
 * AtCoder Beginner Contest 205
 * C - POW
 * https://atcoder.jp/contests/abc205/tasks/abc205_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc205/submissions/37992416
 *
 * note:
 *
 *
 */

package contests.abc.abc20x.abc205.abc205_c;

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
    br.close();
    int cmp_a = a, cmp_b = b;
    if (c % 2 == 0) {
      cmp_a = Math.abs(cmp_a);
      cmp_b = Math.abs(cmp_b);
    }
    if (cmp_a == cmp_b) {
      System.out.println("=");
    } else {
      System.out.println(cmp_a < cmp_b ? "<" : ">");
    }
  }
}
