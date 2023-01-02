/*
 * AtCoder Beginner Contest 210
 * A - Cabbages
 * https://atcoder.jp/contests/abc210/tasks/abc210_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc210/submissions/37698864
 *
 * note:
 *
 *
 */

package contests.abc.abc21x.abc210.abc210_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int a = Integer.parseInt(st.nextToken());
    final int x = Integer.parseInt(st.nextToken());
    final int y = Integer.parseInt(st.nextToken());
    br.close();
    System.out.println(n > a ? (x * a) + (y * (n - a)) : x * n);
  }
}
