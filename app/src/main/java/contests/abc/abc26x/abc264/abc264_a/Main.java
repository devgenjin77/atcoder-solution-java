/*
 * freee プログラミングコンテスト2022
 * （AtCoder Beginner Contest 264）
 * A - "atcoder".substr()
 * https://atcoder.jp/contests/abc264/tasks/abc264_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc264/submissions/35925142
 *
 */

package contests.abc.abc26x.abc264.abc264_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    int l = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    br.close();
    System.out.println("atcoder".substring(l - 1, r));
  }
}
