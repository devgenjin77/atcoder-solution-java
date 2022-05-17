/*
 * ABC213
 * A - Bitwise Exclusive Or
 * https://atcoder.jp/contests/abc213/tasks/abc213_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc213/submissions/31770468
 */

package contests.abc.abc21x.abc213.abc213_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    br.close();
    System.out.println(a ^ b);
  }
}
