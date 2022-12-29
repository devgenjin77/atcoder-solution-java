/*
 * 日鉄ソリューションズプログラミングコンテスト2022
 * （AtCoder Beginner Contest 257）
 * A - A to Z String 2
 * https://atcoder.jp/contests/abc257/tasks/abc257_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc257/submissions/37612219
 *
 */

package contests.abc.abc25x.abc257.abc257_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int x = Integer.parseInt(st.nextToken());
    br.close();
    int p = (x + (n - 1)) / n;
    System.out.println((char) ('A' + (p - 1)));
  }
}
