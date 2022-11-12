/*
 * 大和証券プログラミングコンテスト2022 Autumn
 * （AtCoder Beginner Contest 277）
 * D - Takahashi's Solitaire
 * https://atcoder.jp/contests/abc277/tasks/abc277_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc277/submissions/36457623
 *
 */

package contests.abc.abc27x.abc277.abc277_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final long m = Long.parseLong(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final long[] array_a = new long[n];
    long all_sum = 0;
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
      all_sum += array_a[i];
    }
    br.close();
    Arrays.sort(array_a);
    long max = 0;
    long val = array_a[0];
    for (int i = 1; i < 2 * n; i++) {
      if (array_a[(i - 1) % n] == array_a[i % n]
          || (array_a[(i - 1) % n] + 1) % m == array_a[i % n]) {
        val += array_a[i % n];
      } else {
        max = Math.max(val, max);
        val = array_a[i % n];
      }
    }
    max = Math.min(Math.max(val, max), all_sum);
    System.out.println(all_sum - max);
  }
}
