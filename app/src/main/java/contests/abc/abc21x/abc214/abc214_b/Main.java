/*
 * AtCoder Beginner Contest 214
 * B - How many?
 * https://atcoder.jp/contests/abc214/tasks/abc214_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc214/submissions/37718452
 *
 * note:
 *
 *
 */

package contests.abc.abc21x.abc214.abc214_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int s = Integer.parseInt(st.nextToken());
    final int t = Integer.parseInt(st.nextToken());
    br.close();
    int ans = 0;
    for (int a = 0; a <= s; a++) {
      for (int b = 0; b <= s - a; b++) {
        for (int c = 0; c <= s - a - b; c++) {
          if (a * b * c <= t) {
            ans++;
          } else {
            break;
          }
        }
      }
    }
    System.out.println(ans);
  }
}
