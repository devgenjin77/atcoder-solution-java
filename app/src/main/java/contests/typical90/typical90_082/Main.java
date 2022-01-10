/*
 * 競プロ典型90問
 * 082 - Counting Numbers（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_cd
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28447891
 *
 */
package contests.typical90.typical90_082;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class Main {

  final static long MOD = 1_000_000_007l;
  final static long INV2 = (MOD + 1) / 2;
  final static long MAX_R = 1_000_000_000_000_000_000l;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    StringTokenizer input = new StringTokenizer(br.readLine());
    br.close();
    long l = Long.parseLong(input.nextToken());
    long r = Long.parseLong(input.nextToken());
    int min_digit = Long.toString(l).length();
    long range_min = MAX_R;
    long range_max = MAX_R;
    long digit = 19, ans = 0;
    while (digit >= min_digit) {
      if (r >= range_min && l <= range_max) {
        long first = Math.max(l, range_min);
        long last = Math.min(r, range_max);
        ans += (sumOfArithmeticSeries(first, last) * digit % MOD);
        ans %= MOD;
      }
      digit--;
      range_min /= 10;
      range_max = (range_min * 10) - 1;
    }
    System.out.println(ans);
  }

  static long sumOfArithmeticSeries(long first, long last) {
    long n = (last - first + 1) % MOD;
    long x = (first + last) % MOD;
    return ((n * x) + MOD) % MOD * INV2 % MOD;
  }
}
