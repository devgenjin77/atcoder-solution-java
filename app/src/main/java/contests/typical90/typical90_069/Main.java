/*
 * 競プロ典型90問
 * 069 - Colorful Blocks 2（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bq
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28467887
 *
 */
package contests.typical90.typical90_069;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

public class Main {

  static final long MOD = 1_000_000_007L;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long n = Long.parseLong(st.nextToken());
    long k = Long.parseLong(st.nextToken());
    br.close();
    System.out.println(solve(n, k, MOD));
  }

  static long solve(long n, long k, long mod){
    long ans = k % mod;
    if(n > 1){
      ans = ans * (k - 1) % mod;
    }
    if(n > 2) {
      if(k > 2) {
        ans = ans * pow(k - 2, n - 2, mod) % mod;
      } else {
        ans = 0;
      }
    }
    return ans;
  }

  static long pow(long x, long n, long mod) {
    long answer = 1l;
    while (n > 0) {
      if((n & 1) == 1){
        answer = answer * x % mod;
      }
      x = x * x % mod;
      n >>= 1;
    }
    return answer;
  }
}
