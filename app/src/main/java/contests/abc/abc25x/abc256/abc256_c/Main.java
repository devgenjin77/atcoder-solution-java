/*
 * 東京海上日動プログラミングコンテスト2022
 * （AtCoder Beginner Contest 256）
 * C - Filling 3x3 array
 * https://atcoder.jp/contests/abc256/tasks/abc256_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc256/submissions/38173253
 *
 */

package contests.abc.abc25x.abc256.abc256_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int h1 = Integer.parseInt(st.nextToken());
    final int h2 = Integer.parseInt(st.nextToken());
    final int h3 = Integer.parseInt(st.nextToken());
    final int w1 = Integer.parseInt(st.nextToken());
    final int w2 = Integer.parseInt(st.nextToken());
    final int w3 = Integer.parseInt(st.nextToken());
    br.close();
    int ans = 0;
    for (int v1 = 1; v1 < h1 - 1; v1++) {
      for (int v2 = 1; v2 < h1 - v1; v2++) {
        int v3 = h1 - v1 - v2;
        for (int v4 = 1; v4 < h2 - 1; v4++) {
          int v7 = w1 - v1 - v4;
          if (v7 <= 0) {
            break;
          }
          for (int v5 = 1; v5 < h2 - v4; v5++) {
            int v6 = h2 - v4 - v5;
            int v8 = w2 - v2 - v5;
            if (v8 <= 0) {
              break;
            }
            int v9 = h3 - v7 - v8;
            if (v9 > 0 && v9 == w3 - v3 - v6) {
              ans++;
            }
          }
        }
      }
    }
    System.out.println(ans);
  }
}
