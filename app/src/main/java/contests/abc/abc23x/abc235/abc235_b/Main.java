/*
 * HHKB プログラミングコンテスト 2022
 * （AtCoder Beginner Contest 235）
 * B - Climbing Takahashi
 * https://atcoder.jp/contests/abc235/tasks/abc235_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc235/submissions/33917266
 *
 * note:
 * やるだけ
 *
 */

package contests.abc.abc23x.abc235.abc235_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    int now = Integer.parseInt(st.nextToken());
    while (st.hasMoreElements()) {
      int next = Integer.parseInt(st.nextToken());
      if (next > now) {
        now = next;
      } else {
        break;
      }
    }
    System.out.println(now);
  }
}
