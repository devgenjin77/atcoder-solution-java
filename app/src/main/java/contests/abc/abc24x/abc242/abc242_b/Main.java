/*
 * AtCoder Beginner Contest 242
 * B - Minimize Ordering
 * https://atcoder.jp/contests/abc242/tasks/abc242_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc242/submissions/33967653
 *
 * note:
 * ソートするだけ
 */

package contests.abc.abc24x.abc242.abc242_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    br.close();
    final char[] buf_s = s.toCharArray();
    Arrays.sort(buf_s);
    System.out.println(buf_s);
  }
}
