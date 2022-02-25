/*
 * ABC240
 * A - Edge Checker
 * https://atcoder.jp/contests/abc240/tasks/abc240_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc240/submissions/29641760
 *
 */
package contests.abc.abc240.abc240_a;

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
    System.out.println(solve(a, b) ? "Yes" : "No");
  }

  static boolean solve(int a, int b) {
    int tmp = b - a;
    return tmp == 1 || tmp == 9;
  }
}
