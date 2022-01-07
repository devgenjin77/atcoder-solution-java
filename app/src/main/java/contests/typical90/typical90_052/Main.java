/*
 * 競プロ典型90問
 * 052 - Dice Product（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_az
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28364893
 *
 */
package contests.typical90.typical90_052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

  final static long MOD = 1_000_000_007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long ans = 1;
    for (int i = 0; i < n; i++) {
      long sum_of_dice = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).sum();
      ans = (ans * sum_of_dice) % MOD;
    }
    br.close();
    System.out.println(ans);
    return;
  }
}
