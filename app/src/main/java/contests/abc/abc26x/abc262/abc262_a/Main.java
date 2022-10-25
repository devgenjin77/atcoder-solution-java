/*
 * 第三回日本最強プログラマー学生選手権-予選-
 * （AtCoder Beginner Contest 262）
 * A - World Cup
 * https://atcoder.jp/contests/abc263/tasks/abc263_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc262/submissions/35962985
 *
 */

package contests.abc.abc26x.abc262.abc262_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static final int[] at_mod = {2, 1, 0, 3};

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int y = Integer.parseInt(br.readLine());
    br.close();
    System.out.println(y + at_mod[y % 4]);
  }
}
