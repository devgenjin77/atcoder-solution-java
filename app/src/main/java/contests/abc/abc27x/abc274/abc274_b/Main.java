/*
 * キーエンスプログラミングコンテスト2022
 * （AtCoder Beginner Contest 274）
 * B - Line Sensor
 * https://atcoder.jp/contests/abc274/tasks/abc274_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc274/submissions/35921578
 *
 */

package contests.abc.abc27x.abc274.abc274_b;

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
    final int[] ans = new int[w];
    for (int i = 0; i < h; i++) {
      String str = br.readLine();
      for (int j = 0; j < w; j++) {
        if (str.charAt(j) == '#') {
          ans[j]++;
        }
      }
    }
    br.close();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < w; i++) {
      sb.append(ans[i]).append(' ');
    }
    System.out.println(sb.deleteCharAt(sb.length() - 1));
  }
}
