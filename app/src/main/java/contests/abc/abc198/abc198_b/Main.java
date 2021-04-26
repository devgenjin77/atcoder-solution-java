/*
 * ABC198
 * B - Palindrome with leading zeros
 * https://atcoder.jp/contests/abc198/tasks/abc198_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc198/submissions/21722187
 */
package contests.abc.abc198.abc198_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String n = br.readLine();
    br.close();
    System.out.println(solve(n) ? "Yes" : "No");
  }

  static boolean solve(String n) {
    long n1 = Long.parseLong(n);
    long n2 = Long.parseLong(new StringBuilder(n).reverse().toString());

    if(n1 == n2){
      return true;
    }

    if (n1 % n2 != 0) {
      return false;
    }

    if (String.valueOf(n1 / n2).matches("1[0]*")) {
      return true;
    }
    return false;
  }
}
