/*
 * ABC241
 * A - Digit Machine
 * https://atcoder.jp/contests/abc241/tasks/abc241_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc241/submissions/29732790
 *
 */
package contests.abc.abc241.abc241_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] a = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    br.close();
    System.out.println(a[a[a[0]]]);
  }
}
