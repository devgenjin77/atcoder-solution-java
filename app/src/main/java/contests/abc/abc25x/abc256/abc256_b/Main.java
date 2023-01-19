/*
 * 東京海上日動プログラミングコンテスト2022
 * （AtCoder Beginner Contest 256）
 * B - Batters
 * https://atcoder.jp/contests/abc256/tasks/abc256_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc256/submissions/38159618
 *
 */

package contests.abc.abc25x.abc256.abc256_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    int rest = 0, work = 0, idx = n;
    while (idx > 0) {
      work += array_a[--idx];
      if (work < 4) {
        rest++;
      } else {
        break;
      }
    }
    System.out.println(n - rest);
  }
}
