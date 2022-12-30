/*
 * AtCoder Beginner Contest 261
 * B - Tournament Result
 * https://atcoder.jp/contests/abc261/tasks/abc261_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc261/submissions/37640155
 *
 * note:
 *
 *
 */

package contests.abc.abc26x.abc261.abc261_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String[] array_a = new String[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = br.readLine();
    }
    br.close();
    boolean isOK = true;
    main_loop:
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        char c1 = array_a[i].charAt(j);
        char c2 = array_a[j].charAt(i);
        if (!((c1 == 'W' && c2 == 'L') || (c1 == 'L' && c2 == 'W') || (c1 == 'D' && c2 == 'D'))) {
          isOK = false;
          break main_loop;
        }
      }
    }
    System.out.println(isOK ? "correct" : "incorrect");
  }
}
