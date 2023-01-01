/*
 * AtCoder Beginner Contest 207
 * A - Repression
 * https://atcoder.jp/contests/abc207/tasks/abc207_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc207/submissions/37670663
 *
 * note:
 *
 *
 */

package contests.abc.abc20x.abc207.abc207_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int a = Integer.parseInt(st.nextToken());
    final int b = Integer.parseInt(st.nextToken());
    final int c = Integer.parseInt(st.nextToken());
    br.close();
    final int all = a + b + c;
    int ans = all - a;
    ans = Math.max(all - b, ans);
    ans = Math.max(all - c, ans);
    System.out.println(ans);
  }
}
