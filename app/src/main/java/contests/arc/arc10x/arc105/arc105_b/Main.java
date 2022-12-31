/*
 * AtCoder Regular Contest 105
 * B - MAX-=min
 * https://atcoder.jp/contests/arc105/tasks/arc105_b
 *
 * verified:
 * - https://atcoder.jp/contests/arc105/submissions/37664895
 *
 * note:
 *
 */

package contests.arc.arc10x.arc105.arc105_b;

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
    int gcd_a = array_a[0];
    for (int i = 1; i < n; i++) {
      gcd_a = gcd(gcd_a, array_a[i]);
    }
    System.out.println(gcd_a);
  }

  static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
