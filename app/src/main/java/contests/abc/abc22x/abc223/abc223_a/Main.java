/*
 * AtCoder Beginner Contest 223
 * A - Exact Price
 * https://atcoder.jp/contests/abc223/tasks/abc223_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc223/submissions/33494719
 *
 * note:
 * xが1以上且つ100の倍数ならYes
 *
 */

package contests.abc.abc22x.abc223.abc223_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int x = Integer.parseInt(br.readLine());
    br.close();
    System.out.println(x > 0 && x % 100 == 0 ? "Yes" : "No");
  }
}
