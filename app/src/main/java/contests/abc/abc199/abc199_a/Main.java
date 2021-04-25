/*
 * ABC199
 * A - Square Inequality
 * https://atcoder.jp/contests/abc199/tasks/abc199_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc199/submissions/22068531
 */
package contests.abc.abc199.abc199_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    System.out.println(((a * a) + (b * b) < (c * c)) ? "Yes" : "No");
  }
}
