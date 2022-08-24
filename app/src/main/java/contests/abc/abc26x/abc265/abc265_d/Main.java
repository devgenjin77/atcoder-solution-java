/*
 * AtCoder Beginner Contest 265
 * D - Iroha and Haiku (New ABC Edition)
 * https://atcoder.jp/contests/abc265/tasks/abc265_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc265/submissions/34313200
 *
 * note:
 *
 *
 */

package contests.abc.abc26x.abc265.abc265_d;

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
    final long p = Long.parseLong(st.nextToken());
    final long q = Long.parseLong(st.nextToken());
    final long r = Long.parseLong(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final long[] array_a = new long[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
    }
    br.close();
    //累積和
    final long[] cum_a = new long[n];
    cum_a[0] = array_a[0];
    for (int i = 1; i < n; i++) {
      cum_a[i] = array_a[i] + cum_a[i - 1];
    }
    boolean isOk = false;
    long offset = 0;
    int left = 0;
    while (left < n - 2 && offset + p + q + r <= cum_a[n - 1]) {
      if (Arrays.binarySearch(cum_a, offset + p + q + r) >= 0
          && Arrays.binarySearch(cum_a, offset + p + q) >= 0
          && Arrays.binarySearch(cum_a, offset + p) >= 0) {
        isOk = true;
        break;
      } else {
        offset = cum_a[left++];
      }
    }
    System.out.println(isOk ? "Yes" : "No");
  }
}
