/*
 * AtCoder Beginner Contest 215
 * B - log2(N)
 * https://atcoder.jp/contests/abc215/tasks/abc215_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc215/submissions/32429300
 *
 */

package contests.abc.abc21x.abc215.abc215_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final long n = Long.parseLong(br.readLine());
    br.close();
    System.out.println(Long.toBinaryString(n).length() - 1);
  }
}
