/*
 * エイシングプログラミングコンテスト2021
 * （AtCoder Beginner Contest 202）
 * A - Three Dice
 * https://atcoder.jp/contests/abc202/tasks/abc202_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc202/submissions/37997401
 *
 * note:
 *
 *
 */

package contests.abc.abc20x.abc202.abc202_a;

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
    System.out.println(21 - a - b - c);
  }
}
