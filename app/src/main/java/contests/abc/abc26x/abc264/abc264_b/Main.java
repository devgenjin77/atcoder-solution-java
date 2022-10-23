/*
 * freee プログラミングコンテスト2022
 * （AtCoder Beginner Contest 264）
 * B - Nice Grid
 * https://atcoder.jp/contests/abc264/tasks/abc264_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc264/submissions/35925539
 *
 */

package contests.abc.abc26x.abc264.abc264_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int r = Integer.parseInt(st.nextToken()) - 1;
    final int c = Integer.parseInt(st.nextToken()) - 1;
    br.close();
    int tmp = Math.max(Math.abs(r - 7), Math.abs(c - 7));
    System.out.println(tmp % 2 == 0 ? "white" : "black");
  }
}
