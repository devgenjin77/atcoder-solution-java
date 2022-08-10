/*
 * AtCoder Beginner Contest 234
 * C - Happy New Year!
 * https://atcoder.jp/contests/abc234/tasks/abc234_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc234/submissions/33914372
 *
 * note:
 * 一度二進数に直して、1->2に置換する
 */

package contests.abc.abc23x.abc234.abc234_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final long k = Long.parseLong(br.readLine());
    br.close();
    final String bi_k = Long.toBinaryString(k);
    System.out.println(bi_k.replace('1', '2'));
  }
}
