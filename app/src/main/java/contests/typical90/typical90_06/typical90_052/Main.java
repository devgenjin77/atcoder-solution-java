/*
 * 競プロ典型90問
 * 052 - Dice Product（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_az
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31933816
 *
 * note:
 * -因数分解をする
 *
 */

package contests.typical90.typical90_06.typical90_052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static final long MOD = 1_000_000_007l;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long ans = 1;
    for (int i = 0; i < n; i++) {
      StringTokenizer st_a = new StringTokenizer(br.readLine());
      long dice_sum = 0;
      while (st_a.hasMoreElements()) {
        dice_sum += Long.parseLong(st_a.nextToken());
      }
      ans *= dice_sum;
      ans %= MOD;
    }
    br.close();
    System.out.println(ans);
  }
}
