/*
 * 競プロ典型90問
 * 082 - Counting Numbers（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_cd
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31993707
 *
 * note:
 * -数列の公式の和を考える
 *
 */

package contests.typical90.typical90_09.typical90_082;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static final long MOD = 1_000_000_007L;

  static final long INV2 = (MOD + 1) / 2;

  final static long MAX_R = 1_000_000_000_000_000_000l;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long l = Long.parseLong(st.nextToken());
    long r = Long.parseLong(st.nextToken());
    br.close();

    long ans = 0;
    long range_low = MAX_R, digit = 19;
    long right = r;
    while (digit > 0) {
      if (right >= range_low) {
        long left = Math.max(l, range_low);
        ans += (sumOfArithmeticSeries(left - 1, right) * digit % MOD);
        ans %= MOD;
        if(left == l) {
          break;
        }
        right = range_low - 1;
      }
      range_low /= 10;
      digit--;
    }
    System.out.println(ans);
  }

  static long sumOfArithmeticSeries(long from, long to) {
    long ret = func(to);
    ret = ret + MOD - func(from);
    return ret % MOD;
  }

  static long func(long n) {
    long ret = ((n % MOD) * ((n + 1) % MOD)) % MOD;
    ret *= INV2 % MOD;
    return ret % MOD;
  }
}
