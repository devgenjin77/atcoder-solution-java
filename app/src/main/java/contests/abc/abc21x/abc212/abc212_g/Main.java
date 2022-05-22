/*
 * ABC212
 * G - Power Pair
 * https://atcoder.jp/contests/abc212/tasks/abc212_g
 *
 * verified:
 * - https://atcoder.jp/contests/abc212/submissions/30322353
 */
package contests.abc.abc21x.abc212.abc212_g;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//TODO 後ほど改めて解き直す問題
public class Main {

  static final long MOD = 998_244_353L;

  static void solve(BufferedReader br, PrintWriter pw) throws Exception {
    long p = Long.parseLong(br.readLine());
    List<Long> divisor = divisorList(p - 1);
    //(0,0)の分あらかじめ1足しておく
    long ans = 1;
    for (long x : divisor) {
      long tmp = (x % MOD) * (euler(x) % MOD) % MOD;
      ans = (ans + tmp) % MOD;
    }
    pw.println(ans);
    pw.flush();
  }

  //約数列挙
  static List<Long> divisorList(long n) {
    List<Long> ret = new ArrayList<>();
    for (long x = 1l; x * x <= n; x++) {
      if (n % x == 0) {
        ret.add(x);
        if (n / x != x) {
          ret.add(n / x);
        }
      }
    }
    Collections.sort(ret);
    return ret;
  }

  //Euler's-Phi-Function(オイラーのφ関数)
  static long euler(long n) {
    long ret = n;
    for (long x = 2; x * x <= n; x++) {
      if (n % x == 0) {
        ret -= ret / x;
        while (n % x == 0) {
          n /= x;
        }
      }
    }
    if (n > 1) {
      ret -= ret / n;
    }
    return ret;
  }

  public static void main(String[] args) {
    try (
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out)) {
      solve(br, pw);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}