/*
 * AtCoder Beginner Contest 236
 * A - chukodai
 * https://atcoder.jp/contests/abc236/tasks/abc236_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc236/submissions/33921043
 *
 * note:
 *
 *
 */

package contests.abc.abc23x.abc236.abc236_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int a = Integer.parseInt(st.nextToken()) - 1;
    final int b = Integer.parseInt(st.nextToken()) - 1;
    br.close();
    StringBuilder sb_ans = new StringBuilder(s);
    sb_ans.setCharAt(a, s.charAt(b));
    sb_ans.setCharAt(b, s.charAt(a));
    System.out.println(sb_ans);
  }
}
