/*
 * AtCoder Beginner Contest 207
 * B - Hydrate
 * https://atcoder.jp/contests/abc207/tasks/abc207_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc207/submissions/37671142
 *
 * note:
 *
 *
 */

package contests.abc.abc20x.abc207.abc207_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final long a = Long.parseLong(st.nextToken());
    final long b = Long.parseLong(st.nextToken());
    final long c = Long.parseLong(st.nextToken());
    final long d = Long.parseLong(st.nextToken());
    br.close();
    long div = (c * d) - b;
    long ans = 0;
    if (div > 0) {
      ans = (a + div - 1) / div;
    } else {
      ans = -1;
    }
    System.out.println(ans);
  }
}
