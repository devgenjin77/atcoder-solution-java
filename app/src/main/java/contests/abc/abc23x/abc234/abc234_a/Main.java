/*
 * AtCoder Beginner Contest 234
 * A - Weird Function
 * https://atcoder.jp/contests/abc234/tasks/abc234_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc234/submissions/33913950
 *
 * note:
 * 関数定義
 */

package contests.abc.abc23x.abc234.abc234_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final long t = Long.parseLong(br.readLine());
    br.close();
    long ans = func(func(func(t) + t) + func(func(t)));
    System.out.println(ans);
  }

  static long func(long x) {
    return (x * x) + (2 * x) + 3;
  }
}
