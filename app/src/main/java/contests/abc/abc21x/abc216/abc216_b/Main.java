/*
 * AtCoder Beginner Contest 216
 * B - Same Name
 * https://atcoder.jp/contests/abc216/tasks/abc216_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc216/submissions/32475528
 *
 */

package contests.abc.abc21x.abc216.abc216_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Set<String> set_names = new HashSet<>();
    boolean isDuplicate = false;
    for (int i = 0; i < n; i++) {
      if (!set_names.add(br.readLine())) {
        isDuplicate = true;
        break;
      }
    }
    System.out.println(isDuplicate ? "Yes" : "No");
    br.close();
  }
}
