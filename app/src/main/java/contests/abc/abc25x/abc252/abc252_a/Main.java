/*
 * AtCoder Beginner Contest 252
 * A - ASCII code
 * https://atcoder.jp/contests/abc252/tasks/abc252_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc252/submissions/38124127
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc252.abc252_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    System.out.println((char) n);
  }
}
