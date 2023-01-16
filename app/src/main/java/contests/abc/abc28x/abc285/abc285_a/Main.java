/*
 * AtCoder Beginner Contest 285
 * A - Edge Checker 2
 * https://atcoder.jp/contests/abc285/tasks/abc285_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc285/submissions/38101270
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc285.abc285_a;

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
    System.out.println(b / 2 == a ? "Yes" : "No");
  }
}
