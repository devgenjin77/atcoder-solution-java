/*
 * パナソニックグループプログラミングコンテスト2022
 * （AtCoder Beginner Contest 273）
 * C - (K+1)-th Largest Number
 * https://atcoder.jp/contests/abc273/tasks/abc273_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc273/submissions/35707735
 *
 */

package contests.abc.abc27x.abc273.abc273_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
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
    final int[] array_ans = new int[n];
    Arrays.sort(array_a);
    int k = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (i + 1 < n && array_a[i] < array_a[i + 1]) {
        k++;
      }
      array_ans[k]++;
    }
    final PrintWriter pw = new PrintWriter(System.out);
    for (int ans : array_ans) {
      pw.println(ans);
    }
    pw.close();
  }
}
