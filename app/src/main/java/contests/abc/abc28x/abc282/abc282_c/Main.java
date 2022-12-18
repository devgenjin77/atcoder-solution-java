/*
 * HHKBプログラミングコンテスト2022 Winter
 * （AtCoder Beginner Contest 282）
 * C - String Delimiter
 * https://atcoder.jp/contests/abc282/tasks/abc282_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc282/submissions/37373073
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc282.abc282_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String s = br.readLine();
    br.close();
    final StringBuilder sb = new StringBuilder(s);
    boolean isEnclosed = false;
    for (int i = 0; i < n; i++) {
      if (sb.charAt(i) == '"') {
        isEnclosed = !isEnclosed;
      } else if (sb.charAt(i) == ',' && !isEnclosed) {
        sb.setCharAt(i, '.');
      }
    }
    System.out.println(sb.toString());
  }
}
