/*
 * パナソニックグループプログラミングコンテスト2022
 * （AtCoder Beginner Contest 273）
 * A - A Recursive Function
 * https://atcoder.jp/contests/abc273/tasks/abc273_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc273/submissions/35706489
 *
 */

package contests.abc.abc27x.abc273.abc273_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final long n = Long.parseLong(br.readLine());
    br.close();
    System.out.println(func(n));
  }

  static final long func(long k) {
    if (k == 0) {
      return 1;
    } else {
      return k * func(k - 1);
    }
  }
}
