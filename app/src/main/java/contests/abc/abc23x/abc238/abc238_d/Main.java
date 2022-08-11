/*
 * モノグサプログラミングコンテスト2022
 * （AtCoder Beginner Contest 238）
 * D - AND and SUM
 * https://atcoder.jp/contests/abc238/tasks/abc238_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc238/submissions/33944747
 *
 * note:
 * bit演算
 *
 */

package contests.abc.abc23x.abc238.abc238_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int t = Integer.parseInt(br.readLine());
    final PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < t; i++) {
      final StringTokenizer as = new StringTokenizer(br.readLine());
      long a = Long.parseLong(as.nextToken());
      long s = Long.parseLong(as.nextToken());
      if (s >= (2 * a) && ((s - (2 * a) & a) == 0)) {
        pw.println("Yes");
      } else {
        pw.println("No");
      }
    }
    pw.close();
    br.close();
  }
}
