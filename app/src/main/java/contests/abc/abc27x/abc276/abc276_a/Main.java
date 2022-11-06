/*
 * AtCoder Beginner Contest 276
 * A - Rightmost
 * https://atcoder.jp/contests/abc276/tasks/abc276_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc276/submissions/36287391
 *
 * note:
 *
 *
 */

package contests.abc.abc27x.abc276.abc276_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    br.close();
    int idx = s.lastIndexOf('a');
    System.out.println(idx >= 0 ? idx + 1 : -1);
  }
}
