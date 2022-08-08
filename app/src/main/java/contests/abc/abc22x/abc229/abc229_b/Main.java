/*
 * NECプログラミングコンテスト2021
 * （AtCoder Beginner Contest 229）
 * B - Hard Calculation
 * https://atcoder.jp/contests/abc229/tasks/abc229_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc229/submissions/33879176
 *
 * note:
 *
 *
 */

package contests.abc.abc22x.abc229.abc229_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    br.close();
    boolean isHard = false;
    while (a > 0 && b > 0) {
      if ((a % 10) + (b % 10) > 9) {
        isHard = true;
        break;
      }
      a /= 10;
      b /= 10;
    }
    System.out.println(isHard ? "Hard" : "Easy");
  }
}
