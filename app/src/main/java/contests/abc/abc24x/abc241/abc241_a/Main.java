/*
 * ABC241
 * A - Digit Machine
 * https://atcoder.jp/contests/abc241/tasks/abc241_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc241/submissions/32308041
 *
 */

package contests.abc.abc24x.abc241.abc241_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] array_a = new int[10];
    for (int i = 0; i < 10; i++) {
      array_a[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
    System.out.println(array_a[array_a[array_a[0]]]);
  }
}
