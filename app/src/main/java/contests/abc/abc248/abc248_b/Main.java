/*
 * ユニークビジョンプログラミングコンテスト2022
 * （AtCoder Beginner Contest 248）
 * B - Slimes
 * https://atcoder.jp/contests/abc248/tasks/abc248_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc248/submissions/31067479
 *
 */

package contests.abc.abc248.abc248_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    long a = Long.parseLong(st.nextToken());
    long b = Long.parseLong(st.nextToken());
    long k = Long.parseLong(st.nextToken());
    int cnt = 0;
    while (a < b) {
      a *= k;
      cnt++;
    }
    System.out.println(cnt);
  }
}
