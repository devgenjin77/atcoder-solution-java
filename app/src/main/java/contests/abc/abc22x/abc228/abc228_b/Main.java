/*
 * トヨタシステムズプログラミングコンテスト2021
 * （AtCoder Beginner Contest 228）
 * B - Takahashi's Secret
 * https://atcoder.jp/contests/abc228/tasks/abc228_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc228/submissions/33865842
 *
 * note:
 * 情報の伝播をシミュレーションする
 *
 */

package contests.abc.abc22x.abc228.abc228_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int x = Integer.parseInt(st.nextToken()) - 1;
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    final boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken()) - 1;
    }
    br.close();
    int now = x;
    int ans = 0;
    while (!visited[now]) {
      visited[now] = true;
      ans++;
      now = array_a[now];
    }
    System.out.println(ans);
  }
}
