/*
 * LINE Verda プログラミングコンテスト
 * （AtCoder Beginner Contest 263）
 * B - Ancestor
 * https://atcoder.jp/contests/abc263/tasks/abc263_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc263/submissions/35940405
 *
 */

package contests.abc.abc26x.abc263.abc263_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_p = new StringTokenizer(br.readLine());
    br.close();
    final int[] parent = new int[n];
    for (int i = 1; i < n; i++) {
      int p = Integer.parseInt(st_p.nextToken()) - 1;
      parent[i] = parent[p] + 1;
    }
    System.out.println(parent[n - 1]);
  }
}
