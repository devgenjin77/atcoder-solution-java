/*
 * ウルシステムズプログラミングコンテスト2023
 * （AtCoder Beginner Contest 286）
 * C - Rotate and Palindrome
 * https://atcoder.jp/contests/abc286/tasks/abc286_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc286/submissions/38240510
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc286.abc286_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final long a = Long.parseLong(st.nextToken());
    final long b = Long.parseLong(st.nextToken());
    final String s = br.readLine();
    br.close();
    final StringBuilder sb = new StringBuilder();
    sb.append(s).append(s);
    long ans = Long.MAX_VALUE / 2;
    for (int shift = 0; shift < n; shift++) {
      long add_b = 0;
      for (int j = 0; j < n / 2; j++) {
        if (sb.charAt(j + shift) != sb.charAt(n - j + shift - 1)) {
          add_b += b;
        }
      }
      ans = Math.min((a * shift) + add_b, ans);
    }
    System.out.println(ans);
  }
}
