/*
 * AtCoder Beginner Contest 285
 * B - Longest Uncommon Prefix
 * https://atcoder.jp/contests/abc285/tasks/abc285_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc285/submissions/38101142
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc285.abc285_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String s = br.readLine();
    br.close();
    final int[] ans = new int[s.length()];
    for (int i = 1; i < n; i++) {
      int count = 0;
      for (int x = 0; x + i < n; x++) {
        if (s.charAt(x) != s.charAt(x + i)) {
          count++;
        } else {
          break;
        }
      }
      ans[i] = count;
    }
    final PrintWriter pw = new PrintWriter(System.out);
    for (int i = 1; i < n; i++) {
      pw.println(ans[i]);
    }
    pw.close();
  }
}
