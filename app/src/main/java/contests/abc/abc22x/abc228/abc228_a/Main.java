/*
 * トヨタシステムズプログラミングコンテスト2021
 * （AtCoder Beginner Contest 228）
 * A - On and Off
 * https://atcoder.jp/contests/abc228/tasks/abc228_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc228/submissions/33864725
 *
 * note:
 * 各時間ごとに照明のON、OFFを管理するテーブルを用意する
 *
 */

package contests.abc.abc22x.abc228.abc228_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int s = Integer.parseInt(st.nextToken());
    final int t = Integer.parseInt(st.nextToken());
    final int x = Integer.parseInt(st.nextToken());
    br.close();
    final int[] tbl_r = new int[24];
    final int to_time = s > t ? t + 24 : t;
    for (int i = s; i < to_time; i++) {
      tbl_r[i % 24] = 1;
    }
    System.out.println(tbl_r[x] == 1 ? "Yes" : "No");
  }
}
