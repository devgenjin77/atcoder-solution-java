/*
 * AtCoder Beginner Contest 230
 * A - AtCoder Quiz 3
 * https://atcoder.jp/contests/abc230/tasks/abc230_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc230/submissions/33885729
 *
 * note:
 * ゼロパディングして出力
 *
 */

package contests.abc.abc23x.abc230.abc230_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    int num = n;
    if (num >= 42) {
      num++;
    }
    System.out.println(String.format("AGC%03d", num));
  }
}
