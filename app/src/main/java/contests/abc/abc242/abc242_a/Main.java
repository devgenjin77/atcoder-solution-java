/*
 * ABC242
 * A - T-shirt
 * https://atcoder.jp/contests/abc242/tasks/abc242_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc242/submissions/29924427
 *
 */
package contests.abc.abc242.abc242_a;

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
    int c = Integer.parseInt(input[2]);
    int x = Integer.parseInt(input[3]);
    double ans = 0;
    if(x <= a) {
      ans = 1.0;
    } else if(x > b) {
      ans = 0.0;
    } else {
      ans = (double) c / (b - a);
    }
    System.out.println(ans);
  }
}
