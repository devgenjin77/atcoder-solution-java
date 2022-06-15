/*
 * AtCoder Beginner Contest 217
 * A - Lexicographic Order
 * https://atcoder.jp/contests/abc217/tasks/abc217_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc217/submissions/32487976
 *
 */

package contests.abc.abc21x.abc217.abc217_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String[] st = br.readLine().split(" ");
    br.close();
    System.out.println(st[0].compareTo(st[1]) < 0 ? "Yes" : "No");
  }
}
