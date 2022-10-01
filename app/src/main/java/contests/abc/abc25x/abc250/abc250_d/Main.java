/*
 * AtCoder Beginner Contest 250
 * D - 250-like Number
 * https://atcoder.jp/contests/abc250/tasks/abc250_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc250/submissions/35263828
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc250.abc250_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final long n = Long.parseLong(br.readLine());
    br.close();
    final int limit = (int) Math.cbrt(n);
    final EratosthenesSieve sieve = new EratosthenesSieve(limit);
    final List<Long> pn_list = new ArrayList<>();
    pn_list.add(2L);
    for (int i = 3; i <= limit; i += 2) {
      if (sieve.isPrimeNumber(i)) {
        pn_list.add((long) i);
      }
    }
    long ans = 0;
    int left = 0, right = pn_list.size() - 1;
    //尺取法
    while (left < right) {
      long p_l = pn_list.get(left);
      long p_r = pn_list.get(right);
      if (p_r * p_r * p_r <= n / p_l) {
        ans += right - left;
        left++;
      } else {
        right--;
      }
    }
    System.out.println(ans);
  }

  //EratosthenesSieveライブラリ
  static class EratosthenesSieve {

    private final int div[];

    EratosthenesSieve(int n) {
      div = new int[n + 1];
      for (int i = 1; i <= n; i++) {
        div[i] = i % 2 == 0 ? 2 : i;
      }
      for (int num = 3; num * num <= n; num += 2) {
        if (div[num] == num) {
          int multiple = num * 2;
          while (multiple <= n) {
            div[multiple] = num;
            multiple += num;
          }
        }
      }
    }

    public boolean isPrimeNumber(int n) {
      return div[n] == n;
    }
  }
}
