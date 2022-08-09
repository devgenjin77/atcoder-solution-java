/*
 * AtCoder Beginner Contest 233
 * B - A Reverse
 * https://atcoder.jp/contests/abc233/tasks/abc233_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc233/submissions/33905347
 *
 * note:
 *
 */

package contests.abc.abc23x.abc233.abc233_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    int l = Integer.parseInt(st.nextToken()) - 1;
    int r = Integer.parseInt(st.nextToken()) - 1;
    String s = br.readLine();
    br.close();
    StringBuilder ans = new StringBuilder(s);
    while (l < r) {
      ans.setCharAt(l, s.charAt(r));
      ans.setCharAt(r, s.charAt(l));
      l++;
      r--;
    }
    System.out.println(ans);
  }
}
