/*
 * ABC246
 * F - typewriter
 * https://atcoder.jp/contests/abc246/tasks/abc246_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc246/submissions/30724484
 *
 * Note:
 * 包除原理
 *
 */

package contests.abc.abc246.abc246_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static final long MOD = 998244353L;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nl = br.readLine().split(" ");
    int n = Integer.parseInt(nl[0]);
    long l = Long.parseLong(nl[1]);
    int[] bit_pattern = new int[n];
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      for (int idx = 0; idx < s.length(); idx++) {
        bit_pattern[i] += 1 << (s.charAt(idx) - 'a');
      }
    }
    br.close();
    long ans = 0;
    //bit全探索
    for (int bit = 1; bit < (1 << n); bit++) {
      int bit_chars = (1 << 26) - 1;
      for (int i = 0; i < n; i++) {
        if (((bit >> i) & 1) == 1) {
          bit_chars &= bit_pattern[i];
        }
      }
      int cnt_chars = Integer.bitCount(bit_chars);
      //包除原理
      if (Integer.bitCount(bit) % 2 == 1) {
        ans += pow(cnt_chars, l, MOD);
      } else {
        ans += (MOD - pow(cnt_chars, l, MOD));
      }
      ans %= MOD;
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
