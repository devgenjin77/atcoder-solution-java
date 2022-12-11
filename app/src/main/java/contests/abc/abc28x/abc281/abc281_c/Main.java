/*
 * AtCoder Beginner Contest 281
 * C - Circular Playlist
 * https://atcoder.jp/contests/abc281/tasks/abc281_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc281/submissions/37216548
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc281.abc281_c;

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
    final long t = Long.parseLong(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final long[] array_cum = new long[n + 1];
    long all_sum = 0;
    for (int i = 1; i <= n; i++) {
      long a = Long.parseLong(st_a.nextToken());
      array_cum[i] = a + array_cum[i - 1];
      all_sum += a;
    }
    br.close();
    long rem = t % all_sum;
    int b = Arrays.binarySearch(array_cum, rem);
    if (b < 0) {
      b = ~b;
    }
    long time = rem - array_cum[b - 1];
    System.out.println(b + " " + time);
  }
}
