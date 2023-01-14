/*
 * AtCoder Beginner Contest 205
 * B - Permutation Check
 * https://atcoder.jp/contests/abc205/tasks/abc205_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc205/submissions/37989148
 *
 * note:
 *
 *
 */

package contests.abc.abc20x.abc205.abc205_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final boolean[] exists = new boolean[n];
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    br.close();
    boolean isOK = true;
    for (int i = 0; i < n; i++) {
      int a = Integer.parseInt(st_a.nextToken()) - 1;
      if (exists[a]) {
        isOK = false;
        break;
      } else {
        exists[a] = true;
      }
    }
    System.out.println(isOK ? "Yes" : "No");
  }
}
