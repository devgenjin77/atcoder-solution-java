/*
 * パナソニックグループプログラミングコンテスト2022
 * （AtCoder Beginner Contest 251）
 * D - At Most 3 (Contestant ver.)
 * https://atcoder.jp/contests/abc251/tasks/abc251_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc251/submissions/35180909
 *
 */

package contests.abc.abc25x.abc251.abc251_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int w = Integer.parseInt(br.readLine());
    br.close();
    // 1,2,3-99
    // 100,200,300-9900
    // 10000,20000,30000-990000
    // 1000000で合計298こ
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= 99; i++) {
      sb.append(i).append(' ');
    }
    for (int i = 100; i <= 9900; i += 100) {
      sb.append(i).append(' ');
    }
    for (int i = 10000; i <= 990000; i += 10000) {
      sb.append(i).append(' ');
    }
    sb.append(1_000_000);
    System.out.println((99 * 3) + 1);
    System.out.println(sb);
  }
}
