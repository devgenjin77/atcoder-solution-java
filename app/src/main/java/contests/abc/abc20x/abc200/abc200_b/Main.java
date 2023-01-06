/*
 * 京セラプログラミングコンテスト2021
 * （AtCoder Beginner Contest 200）
 * B - 200th ABC-200
 * https://atcoder.jp/contests/abc200/tasks/abc200_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc200/submissions/37773954
 *
 * note:
 *
 *
 */

package contests.abc.abc20x.abc200.abc200_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int k = Integer.parseInt(st.nextToken());
    br.close();
    long ans = n;
    for (int i = 0; i < k; i++) {
      ans = ans % 200 == 0 ? ans / 200 : (ans * 1000) + 200;
    }
    System.out.println(ans);
  }
}
