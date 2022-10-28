/*
 * トヨタ自動車プログラミングコンテスト2022
 * （AtCoder Beginner Contest 270）
 * A - 1-2-4 Test
 * https://atcoder.jp/contests/abc270/tasks/abc270_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc270/submissions/36020646
 *
 */

package contests.abc.abc27x.abc270.abc270_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int a = Integer.parseInt(st.nextToken());
    final int b = Integer.parseInt(st.nextToken());
    br.close();
    System.out.println(a | b);
  }
}
