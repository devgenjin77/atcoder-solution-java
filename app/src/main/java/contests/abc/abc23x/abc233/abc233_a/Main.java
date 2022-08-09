/*
 * AtCoder Beginner Contest 233
 * A - 10yen Stamp
 * https://atcoder.jp/contests/abc233/tasks/abc233_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc233/submissions/33905008
 *
 * note:
 *
 */

package contests.abc.abc23x.abc233.abc233_a;

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
    int ans = (Math.max(y - x, 0) + 9) / 10;
    System.out.println(ans);
  }
}
