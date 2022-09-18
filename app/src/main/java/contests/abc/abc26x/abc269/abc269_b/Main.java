/*
 * UNICORNプログラミングコンテスト2022
 * （AtCoder Beginner Contest 269）
 * B - Rectangle Detection
 * https://atcoder.jp/contests/abc269/tasks/abc269_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc269/submissions/34971745
 *
 */

package contests.abc.abc26x.abc269.abc269_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String[] array_s = new String[10];
    for (int i = 0; i < 10; i++) {
      array_s[i] = br.readLine();
    }
    br.close();
    int a = 11, b = 0, c = 11, d = 0;
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (array_s[i].charAt(j) == '#') {
          a = Math.min(i + 1, a);
          b = Math.max(i + 1, b);
          c = Math.min(j + 1, c);
          d = Math.max(j + 1, d);
        }
      }
    }
    System.out.println(String.format("%d %d", a, b));
    System.out.println(String.format("%d %d", c, d));
  }
}
