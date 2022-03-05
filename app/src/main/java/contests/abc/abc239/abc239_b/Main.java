/*
 * ABC239
 * B - Integer Division
 * https://atcoder.jp/contests/abc239/tasks/abc239_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc239/submissions/29851707
 *
 */
package contests.abc.abc239.abc239_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long x = Long.parseLong(br.readLine());
    br.close();
    long xx = x >= 0 ? x : x - 9;
    System.out.println(xx / 10);
  }
}
