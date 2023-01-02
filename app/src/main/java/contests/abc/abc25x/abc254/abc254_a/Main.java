/*
 * AtCoder Beginner Contest 254
 * A - Last Two Digits
 * https://atcoder.jp/contests/abc254/tasks/abc254_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc254/submissions/37697799
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc254.abc254_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    System.out.println(String.format("%02d", n % 100));
  }
}
