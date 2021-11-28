/*
 * ABC229
 * B - Hard Calculation
 * https://atcoder.jp/contests/abc229/tasks/abc229_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc229/submissions/27559576
 */
package contests.abc.abc229.abc229_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] ab = br.readLine().split(" ");
    br.close();
    long a = Long.parseLong(ab[0]);
    long b = Long.parseLong(ab[1]);
    boolean isHard = false;
    while (a > 0 && b > 0) {
      if ((a % 10) + (b % 10) > 9) {
        isHard = true;
        break;
      }
      a /= 10;
      b /= 10;
    }
    System.out.println(isHard ? "Hard" : "Easy");
  }
}
