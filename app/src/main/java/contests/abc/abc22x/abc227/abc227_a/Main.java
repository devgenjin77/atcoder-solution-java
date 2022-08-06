/*
 * キーエンスプログラミングコンテスト2021-Nov.
 * （AtCoder Beginner Contest 227）
 * A - Last Card
 * https://atcoder.jp/contests/abc227/tasks/abc227_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc227/submissions/33791874
 *
 * note:
 * N mod KにオフセットA-1を足す
 *
 */

package contests.abc.abc22x.abc227.abc227_a;

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
    final int a = Integer.parseInt(st.nextToken());
    br.close();
    int ans = (k + a - 1) % n;
    System.out.println(ans == 0 ? n : ans);
  }
}
