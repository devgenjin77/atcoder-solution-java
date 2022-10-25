/*
 * 第三回日本最強プログラマー学生選手権-予選-
 * （AtCoder Beginner Contest 262）
 * C - Min Max Pair
 * https://atcoder.jp/contests/abc262/tasks/abc262_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc262/submissions/35964474
 *
 */

package contests.abc.abc26x.abc262.abc262_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    long ans = 0;
    final long[] cum_idx_eq_a = new long[n + 1];
    for (int i = 1; i <= n; i++) {
      int a = array_a[i];
      cum_idx_eq_a[i] = cum_idx_eq_a[i - 1];
      if (a == i) {
        cum_idx_eq_a[i]++;
        ans += cum_idx_eq_a[i - 1];
      } else if (a < i && array_a[a] == i) {
        ans++;
      }
    }
    System.out.println(ans);
  }
}
