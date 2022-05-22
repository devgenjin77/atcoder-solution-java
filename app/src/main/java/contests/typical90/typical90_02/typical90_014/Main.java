/*
 * 競プロ典型90問
 * 014 - We Used to Sing a Song Together（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_n
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31898985
 *
 * note:
 * ソートして比較する
 *
 */

package contests.typical90.typical90_02.typical90_014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st_a = new StringTokenizer(br.readLine());
    StringTokenizer st_b = new StringTokenizer(br.readLine());
    br.close();
    long[] array_a = new long[n];
    long[] array_b = new long[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(st_a.nextToken());
      array_b[i] = Long.parseLong(st_b.nextToken());
    }
    Arrays.sort(array_a);
    Arrays.sort(array_b);
    long ans = 0;
    for (int i = 0; i < n; i++) {
      ans += Math.abs(array_a[i] - array_b[i]);
    }
    System.out.println(ans);
  }
}
