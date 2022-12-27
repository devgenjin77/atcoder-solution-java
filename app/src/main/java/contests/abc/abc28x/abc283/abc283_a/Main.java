/*
 * ユニークビジョンプログラミングコンテスト2022 冬
 * （AtCoder Beginner Contest 283）
 * A - Power
 * https://atcoder.jp/contests/abc283/tasks/abc283_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc283/submissions/37582000
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc283.abc283_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final long a = Long.parseLong(st.nextToken());
    final int b = Integer.parseInt(st.nextToken());
    br.close();
    long ans = 1;
    for (int i = 0; i < b; i++) {
      ans *= a;
    }
    System.out.println(ans);
  }
}
