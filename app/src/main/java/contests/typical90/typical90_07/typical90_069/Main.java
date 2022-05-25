/*
 * 競プロ典型90問
 * 069 - Colorful Blocks 2（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bq
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31953414
 *
 * note:
 * -繰り返し二乗法をつかう
 *
 */

package contests.typical90.typical90_07.typical90_069;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  static final long MOD = 1_000_000_007L;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long n = Long.parseLong(st.nextToken());
    long k = Long.parseLong(st.nextToken());
    br.close();

    long ans;

    if (n == 1) {
      ans = k;
    } else if (n == 2) {
      ans = k * (k - 1) % MOD;
    } else {
      if (k > 2) {
        ans = (k * (k - 1) % MOD) * pow(k - 2, n - 2, MOD) % MOD;
      } else {
        ans = 0;
      }
    }
    System.out.println(ans);
  }

  static long pow(long x, long n, long mod) {
    long answer = 1l;
    while (n > 0) {
      if ((n & 1) == 1) {
        answer = answer * x % mod;
      }
      x = x * x % mod;
      n >>= 1;
    }
    return answer;
  }
}
