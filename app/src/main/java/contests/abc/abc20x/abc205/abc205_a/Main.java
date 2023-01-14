/*
 * AtCoder Beginner Contest 205
 * A - kcal
 * https://atcoder.jp/contests/abc205/tasks/abc205_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc205/submissions/37988893
 *
 * note:
 *
 *
 */

package contests.abc.abc20x.abc205.abc205_a;

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
    br.close();
    System.out.println(a * b / 100.0);
  }
}
