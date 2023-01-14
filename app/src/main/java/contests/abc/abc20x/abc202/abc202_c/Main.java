/*
 * エイシングプログラミングコンテスト2021
 * （AtCoder Beginner Contest 202）
 * C - Made Up
 * https://atcoder.jp/contests/abc202/tasks/abc202_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc202/submissions/37998460
 *
 * note:
 *
 *
 */

package contests.abc.abc20x.abc202.abc202_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final StringTokenizer st_b = new StringTokenizer(br.readLine());
    final StringTokenizer st_c = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    final int[] array_b = new int[n];
    final int[] array_c = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken()) - 1;
      array_b[i] = Integer.parseInt(st_b.nextToken()) - 1;
      array_c[i] = Integer.parseInt(st_c.nextToken()) - 1;
    }
    br.close();
    final int[] cnt_bc = new int[n];
    for (int i = 0; i < n; i++) {
      cnt_bc[array_b[array_c[i]]]++;
    }
    long ans = 0;
    for (int i = 0; i < n; i++) {
      ans += cnt_bc[array_a[i]];
    }
    System.out.println(ans);
  }
}
