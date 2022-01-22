/*
 * ABC235
 * A - Rotate
 * https://atcoder.jp/contests/abc235/tasks/abc235_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc235/submissions/28676743
 *
 */
package contests.abc.abc235.abc235_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String abc = br.readLine();
    br.close();
    int x = 0;
    for (int i = 0; i < abc.length(); i++) {
      x += abc.charAt(i) - '0';
    }
    System.out.println((100 * x) + (10 * x) + x);
  }
}
