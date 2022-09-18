/*
 * ユニークビジョンプログラミングコンテスト2022 夏
 * （AtCoder Beginner Contest 268）
 * C - Chinese Restaurant
 * https://atcoder.jp/contests/abc268/tasks/abc268_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc268/submissions/34980435
 *
 */

package contests.abc.abc26x.abc268.abc268_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final int[] array_p = new int[n];
    final StringTokenizer st_p = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      array_p[i] = Integer.parseInt(st_p.nextToken());
    }
    br.close();
    int[] cnt = new int[n];
    for (int i = 0; i < n; i++) {
      //何回目の操作でちょうど人p_iの前に料理iがくるのか。
      int diff = (n + array_p[i] - i) % n;
      cnt[diff]++;
      cnt[(n + diff - 1) % n]++;
      cnt[(diff + 1) % n]++;
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans = Math.max(cnt[i], ans);
    }
    System.out.println(ans);
  }
}
