/*
 * デンソークリエイトプログラミングコンテスト2022
 * （AtCoder Beginner Contest 280）
 * A - Pawn on a Grid
 * https://atcoder.jp/contests/abc280/tasks/abc280_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc280/submissions/37063265
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc280.abc280_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int h = Integer.parseInt(st.nextToken());
    final int w = Integer.parseInt(st.nextToken());
    int ans = 0;
    for (int i = 0; i < h; i++) {
      String s = br.readLine();
      for (int j = 0; j < w; j++) {
        if (s.charAt(j) == '#') {
          ans++;
        }
      }
    }
    br.close();
    System.out.println(ans);
  }
}
