/*
 * AtCoder Beginner Contest 252
 * D - Distinct Trio
 * https://atcoder.jp/contests/abc252/tasks/abc252_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc252/submissions/38121437
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc252.abc252_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  private static final int MAX = 200_000;

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    final long[] cnt_a = new long[MAX];
    for (int i = 0; i < n; i++) {
      cnt_a[array_a[i] - 1]++;
    }
    long prev = 0, next = n;
    long ans = 0;
    for (int i = 0; i < MAX; i++) {
      ans += prev * cnt_a[i] * (next - cnt_a[i]);
      prev += cnt_a[i];
      next -= cnt_a[i];
    }
    System.out.println(ans);
  }
}
