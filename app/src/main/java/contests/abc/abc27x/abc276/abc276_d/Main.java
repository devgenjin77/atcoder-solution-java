/*
 * AtCoder Beginner Contest 276
 * D - Divide by 2 or 3
 * https://atcoder.jp/contests/abc276/tasks/abc276_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc276/submissions/36291611
 *
 * note:
 *
 *
 */

package contests.abc.abc27x.abc276.abc276_d;

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
    int gcd_all = array_a[0];
    for (int i = 1; i < n; i++) {
      gcd_all = gcd(array_a[i], gcd_all);
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      array_a[i] /= gcd_all;
      while (array_a[i] % 2 == 0) {
        array_a[i] /= 2;
        ans++;
      }
      while (array_a[i] % 3 == 0) {
        array_a[i] /= 3;
        ans++;
      }
      if (array_a[i] != 1) {
        ans = -1;
        break;
      }
    }
    System.out.println(ans);
  }

  static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
