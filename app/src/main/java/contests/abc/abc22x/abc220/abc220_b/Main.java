/*
 * AtCoder Beginner Contest 220
 * B - Base K
 * https://atcoder.jp/contests/abc220/tasks/abc220_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc220/submissions/32819915
 *
 */

package contests.abc.abc22x.abc220.abc220_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(br.readLine());
    String[] ab = br.readLine().split(" ");
    br.close();
    long ans = Long.parseLong(ab[0], k) * Long.parseLong(ab[1], k);
    System.out.println(ans);
  }
}
