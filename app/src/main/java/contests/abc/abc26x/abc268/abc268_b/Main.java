/*
 * ユニークビジョンプログラミングコンテスト2022 夏
 * （AtCoder Beginner Contest 268）
 * B - Prefix?
 * https://atcoder.jp/contests/abc268/tasks/abc268_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc268/submissions/34774406
 *
 */

package contests.abc.abc26x.abc268.abc268_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    final String t = br.readLine();
    br.close();
    System.out.println(t.startsWith(s) ? "Yes" : "No");
  }
}
