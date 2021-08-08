/*
 * ABC213
 * A - Bitwise Exclusive Or
 * https://atcoder.jp/contests/abc213/tasks/abc213_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc213/submissions/24898702
 */
package contests.abc.abc213.abc213_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    br.close();
    int a = Integer.parseInt(input[0]);
    int b = Integer.parseInt(input[1]);
    System.out.println(a ^ b);
  }
}
