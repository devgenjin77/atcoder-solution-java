/*
 * AtCoder Beginner Contest 218
 * B - qwerty
 * https://atcoder.jp/contests/abc218/tasks/abc218_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc218/submissions/32678255
 *
 */

package contests.abc.abc21x.abc218.abc218_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < 26; i++) {
      ans.append((char) ('a' + Integer.parseInt(st.nextToken()) - 1));
    }
    System.out.println(ans);
  }
}
