/*
 * モノグサプログラミングコンテスト2022
 * （AtCoder Beginner Contest 249）
 * D - Index Trio
 * https://atcoder.jp/contests/abc249/tasks/abc249_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc249/submissions/31224926
 *
 */

package contests.abc.abc249.abc249_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  final static int MAX = 200_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    long[] cnt_a = new long[MAX + 1];
    while (st.hasMoreElements()) {
      int a = Integer.parseInt(st.nextToken());
      cnt_a[a] += 1;
    }
    long ans = 0;
    for (int x1 = 1; x1 <= MAX; x1++) {
      for (int x2 = 1; x1 * x2 <= MAX; x2++) {
        ans += cnt_a[x1 * x2] * cnt_a[x1] * cnt_a[x2];
      }
    }
    System.out.println(ans);
  }
}
