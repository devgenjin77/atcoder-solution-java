/*
 * ABC223
 * A - Exact Price
 * https://atcoder.jp/contests/abc223/tasks/abc223_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc223/submissions/31449654
 *
 */

package contests.abc.abc223.abc223_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(br.readLine());
    br.close();
    System.out.println((x > 0 && x % 100 == 0) ? "Yes" : "No");
  }
}
