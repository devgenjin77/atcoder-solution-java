/*
 * AtCoder Beginner Contest 252
 * B - Takahashi's Failure
 * https://atcoder.jp/contests/abc252/tasks/abc252_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc252/submissions/38123993
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc252.abc252_b;

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
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final StringTokenizer st_b = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    int max_a = 0, max_at_b = 0;
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
      max_a = Math.max(array_a[i], max_a);
    }
    for (int i = 0; i < k; i++) {
      int b = Integer.parseInt(st_b.nextToken()) - 1;
      max_at_b = Math.max(array_a[b], max_at_b);
    }
    br.close();
    System.out.println(max_a == max_at_b ? "Yes" : "No");
  }
}
