/*
 * HHKBプログラミングコンテスト2022 Winter
 * （AtCoder Beginner Contest 282）
 * B - Let's Get a Perfect Score
 * https://atcoder.jp/contests/abc282/tasks/abc282_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc282/submissions/37372941
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc282.abc282_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final int[] bits = new int[n];
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int j = 0; j < m; j++) {
        if (s.charAt(j) == 'o') {
          bits[i] += (1 << j);
        }
      }
    }
    br.close();
    int ans = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        if ((bits[i] | bits[j]) == (1 << m) - 1) {
          ans++;
        }
      }
    }
    System.out.println(ans);
  }
}
