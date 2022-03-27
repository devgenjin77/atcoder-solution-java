/*
 * ABC245
 * A - Good morning
 * https://atcoder.jp/contests/abc245/tasks/abc245_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc245/submissions/30503688
 *
 */

package contests.abc.abc245.abc245_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int a = Integer.parseInt(input[0]);
    int b = Integer.parseInt(input[1]);
    int c = Integer.parseInt(input[2]);
    int d = Integer.parseInt(input[3]);
    br.close();
    int t1 = (a * 60) + b;
    int t2 = (c * 60) + d;
    System.out.println(t1 <= t2 ? "Takahashi" : "Aoki");
  }
}
