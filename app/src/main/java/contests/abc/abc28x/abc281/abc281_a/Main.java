/*
 * AtCoder Beginner Contest 281
 * A - Count Down
 * https://atcoder.jp/contests/abc281/tasks/abc281_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc281/submissions/37216180
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc281.abc281_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    PrintWriter pw = new PrintWriter(System.out);
    for (int a = n; a >= 0; a--) {
      pw.println(a);
    }
    pw.close();
  }
}
