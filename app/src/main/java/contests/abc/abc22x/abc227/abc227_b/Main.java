/*
 * キーエンスプログラミングコンテスト2021-Nov.
 * （AtCoder Beginner Contest 227）
 * B - KEYENCE building
 * https://atcoder.jp/contests/abc227/tasks/abc227_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc227/submissions/33793065
 *
 * note:
 * 一次方程式をAを固定して全探索
 *
 */

package contests.abc.abc22x.abc227.abc227_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st = new StringTokenizer(br.readLine());
    int ans = 0;
    for (int i = 0; i < n; i++) {
      int s = Integer.parseInt(st.nextToken());
      int max = (int) Math.sqrt(s);
      for (int a = 1; a <= max; a++) {
        if (s > 3 * a && (s - (3 * a)) % ((4 * a) + 3) == 0) {
          ans++;
          break;
        }
      }
    }
    br.close();
    System.out.println(n - ans);
  }
}
