/*
 * ABC242
 * E - (∀x∀)
 * https://atcoder.jp/contests/abc242/tasks/abc242_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc242/submissions/29921446
 *
 */
package contests.abc.abc242.abc242_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  static final long MOD = 998244353L;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    PrintWriter pw = new PrintWriter(System.out);
    for (int cnt = 1; cnt <= t; cnt++) {
      int n = Integer.parseInt(br.readLine());
      String s = br.readLine();
      pw.println(solve(n, s));
    }
    pw.close();
    br.close();
  }

  static long solve(int n, String s) {
    long ans = 1;
    int left = 0, right = n - 1;
    StringBuilder sb = new StringBuilder(s);
    while (left <= right) {
      long pattern = s.charAt(left) - 'A' + 1;
      sb.setCharAt(right, s.charAt(left));
      ans = pattern + ((ans - 1) * 26);
      ans %= MOD;
      left += 1;
      right -= 1;
    }
    if (sb.toString().compareTo(s) > 0) {
      return (ans + MOD - 1) % MOD;
    } else {
      return ans;
    }
  }
}
