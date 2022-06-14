/*
 * AtCoder Beginner Contest 216
 * A - Signed Difficulty
 * https://atcoder.jp/contests/abc216/tasks/abc216_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc216/submissions/32475269
 *
 */

package contests.abc.abc21x.abc216.abc216_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String[] xy = br.readLine().split(Pattern.quote("."));
    br.close();
    final int y = Integer.parseInt(xy[1]);
    final StringBuilder sb = new StringBuilder(xy[0]);
    if (y <= 2) {
      sb.append('-');
    } else if (y >= 7) {
      sb.append('+');
    }
    System.out.println(sb.toString());
  }
}
