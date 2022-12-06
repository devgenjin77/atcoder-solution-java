/*
 * デンソークリエイトプログラミングコンテスト2022
 * （AtCoder Beginner Contest 280）
 * B - Inverse Prefix Sum
 * https://atcoder.jp/contests/abc280/tasks/abc280_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc280/submissions/37063108
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc280.abc280_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_s = new StringTokenizer(br.readLine());
    final long[] array_s = new long[n];
    for (int i = 0; i < n; i++) {
      array_s[i] = Long.parseLong(st_s.nextToken());
    }
    br.close();
    final long[] array_ans = new long[n];
    long pre = 0;
    for (int i = 0; i < n; i++) {
      array_ans[i] = array_s[i] - pre;
      pre = array_s[i];
    }
    final StringBuilder sb = new StringBuilder();
    for (long ans : array_ans) {
      sb.append(ans).append(' ');
    }
    System.out.println(sb.deleteCharAt(sb.length() - 1));
  }
}
