/*
 * AtCoder Beginner Contest 265
 * A - Apple
 * https://atcoder.jp/contests/abc265/tasks/abc265_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc265/submissions/34312212
 *
 * note:
 *
 *
 */

package contests.abc.abc26x.abc265.abc265_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    br.close();
    System.out.println(Math.min(x * n, ((n / 3) * y) + (x * (n % 3))));
  }
}
