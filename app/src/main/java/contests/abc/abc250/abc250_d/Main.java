/*
 * ABC250
 * D - 250-like Number
 * https://atcoder.jp/contests/abc250/tasks/abc250_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc250/submissions/31574987
 *
 */

package contests.abc.abc250.abc250_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    br.close();
    int limit = (int) Math.cbrt(n);
    EratosthenesSieve es = new EratosthenesSieve(limit);
    List<Integer> primeNumberList = new ArrayList<>();
    int[] cnt_prime = new int[limit + 1];
    for (int p = 2; p <= limit; p++) {
      cnt_prime[p] = cnt_prime[p - 1];
      if (es.isPrimeNumber(p)) {
        primeNumberList.add(p);
        cnt_prime[p]++;
      }
    }
    int ans = 0;
    for (int i = primeNumberList.size() - 1; i >= 0; i--) {
      long q = primeNumberList.get(i).longValue();
      long n_div_q = n / (q * q * q);
      if (n_div_q < q) {
        ans += cnt_prime[(int) n_div_q];
      } else {
        ans += cnt_prime[(int) (q - 1)];
      }
    }
    System.out.println(ans);
  }

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
