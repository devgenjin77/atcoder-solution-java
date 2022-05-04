/*
 * モノグサプログラミングコンテスト2022
 * （AtCoder Beginner Contest 238）
 * B - Pizza
 * https://atcoder.jp/contests/abc238/tasks/abc238_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc238/submissions/31430474
 *
 */

package contests.abc.abc238.abc238_b;

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
    br.close();
    int[] array_x = new int[n + 1];
    array_x[n] = 0;
    int k = 0;
    for (int i = 0; i < n; i++) {
      k += Integer.parseInt(st_a.nextToken());
      k %= 360;
      array_x[i] = k;
    }
    Arrays.sort(array_x);
    int ans = 360 - array_x[n];
    for (int i = 0; i < n; i++) {
      ans = Math.max(array_x[i + 1] - array_x[i], ans);
    }
    System.out.println(ans);
  }
}
