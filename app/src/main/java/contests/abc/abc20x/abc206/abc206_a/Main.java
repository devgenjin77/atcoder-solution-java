/*
 * AtCoder Beginner Contest 206
 * （Sponsored by Panasonic）
 * A - Maxi-Buying
 * https://atcoder.jp/contests/abc206/tasks/abc206_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc206/submissions/37992821
 *
 * note:
 *
 */

package contests.abc.abc20x.abc206.abc206_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    final int price = (n * 108) / 100;
    if (price == 206) {
      System.out.println("so-so");
    } else {
      System.out.println(price < 206 ? "Yay!" : ":(");
    }
  }
}
