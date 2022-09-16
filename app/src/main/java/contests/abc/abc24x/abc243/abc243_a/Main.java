/*
 * AtCoder Beginner Contest 243
 * A - Shampoo
 * https://atcoder.jp/contests/abc243/tasks/abc243_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc243/submissions/34895830
 *
 * note:
 *
 */

package contests.abc.abc24x.abc243.abc243_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int v = Integer.parseInt(st.nextToken());
    final int a = Integer.parseInt(st.nextToken());
    final int b = Integer.parseInt(st.nextToken());
    final int c = Integer.parseInt(st.nextToken());
    br.close();
    int remain = v % (a + b + c);
    char ans = ' ';
    if (remain < a) {
      ans = 'F';
    } else if (remain < a + b) {
      ans = 'M';
    } else {
      ans = 'T';
    }
    System.out.println(ans);
  }
}
