/*
 * 大和証券プログラミングコンテスト2022 Autumn
 * （AtCoder Beginner Contest 277）
 * A - ^{-1}
 * https://atcoder.jp/contests/abc277/tasks/abc277_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc277/submissions/36464703
 *
 */

package contests.abc.abc27x.abc277.abc277_a;

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
    final StringTokenizer st_p = new StringTokenizer(br.readLine());
    int idx = 0;
    while (st_p.hasMoreElements()) {
      if (Integer.parseInt(st_p.nextToken()) == x) {
        break;
      }
      idx++;
    }
    br.close();
    System.out.println(idx + 1);
  }
}
