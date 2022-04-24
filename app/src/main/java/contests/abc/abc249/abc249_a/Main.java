/*
 * モノグサプログラミングコンテスト2022
 * （AtCoder Beginner Contest 249）
 * A - Jogging
 * https://atcoder.jp/contests/abc249/tasks/abc249_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc249/submissions/31222152
 *
 */

package contests.abc.abc249.abc249_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] in = br.readLine().split(" ");
    int a = Integer.parseInt(in[0]), b = Integer.parseInt(in[1]), c = Integer.parseInt(in[2]);
    int d = Integer.parseInt(in[3]), e = Integer.parseInt(in[4]), f = Integer.parseInt(in[5]);
    int x = Integer.parseInt(in[6]);
    br.close();

    int d_taka = distance(a, b, c, x);
    int d_aoki = distance(d, e, f, x);
    if (d_taka == d_aoki) {
      System.out.println("Draw");
    } else {
      System.out.println(d_taka > d_aoki ? "Takahashi" : "Aoki");
    }
  }

  static int distance(int a, int b, int c, int x) {
    int q = x / (a + c);
    int r = x % (a + c);
    return ((q * a * b) + (Math.min(a, r) * b));
  }
}
