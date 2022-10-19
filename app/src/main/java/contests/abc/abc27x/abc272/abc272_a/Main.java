/*
 * AtCoder Beginner Contest 272
 * A - Integer Sum
 * https://atcoder.jp/contests/abc272/tasks/abc272_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc272/submissions/35793467
 *
 * note:
 *
 *
 */

package contests.abc.abc27x.abc272.abc272_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    br.close();
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans += Integer.parseInt(st_a.nextToken());
    }
    System.out.println(ans);
  }
}
