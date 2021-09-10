/*
 * ABC217
 * A - Lexicographic Order
 * https://atcoder.jp/contests/abc217/tasks/abc217_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc217/submissions/25560207
 */
package contests.abc.abc217.abc217_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] head = br.readLine().split(" ");
    br.close();
    System.out.println(head[0].compareTo(head[1]) < 0 ? "Yes" : "No");
  }
}
