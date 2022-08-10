/*
 * AtCoder Beginner Contest 236
 * B - Who is missing?
 * https://atcoder.jp/contests/abc236/tasks/abc236_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc236/submissions/33921208
 *
 * note:
 * 全部XORすると、かけている1数字が最後の答えになる
 *
 */

package contests.abc.abc23x.abc236.abc236_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    br.close();
    int ans = Integer.parseInt(st_a.nextToken());
    while (st_a.hasMoreElements()) {
      //数列Aを全部XORする
      ans ^= Integer.parseInt(st_a.nextToken());
    }
    System.out.println(ans);
  }
}
