/*
 * ABC232
 * A - QQ solver
 * https://atcoder.jp/contests/abc232/tasks/abc232_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc232/submissions/28039564
 */
package contests.abc.abc232.abc232_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split("x");
    br.close();
    System.out.println(Integer.parseInt(input[0]) * Integer.parseInt(input[1]));
  }
}
