/*
 * エクサウィザーズプログラミングコンテスト2021
 * （AtCoder Beginner Contest 222）
 * B - Failing Grade
 * https://atcoder.jp/contests/abc222/tasks/abc222_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc222/submissions/33249627
 *
 * note:
 *
 */

package contests.abc.abc22x.abc222.abc222_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int p = Integer.parseInt(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    br.close();
    int ans = 0;
    while (st_a.hasMoreTokens()) {
      if (Integer.parseInt(st_a.nextToken()) < p) {
        ans++;
      }
    }
    System.out.println(ans);
  }
}
