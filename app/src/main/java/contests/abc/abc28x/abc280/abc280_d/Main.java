/*
 * デンソークリエイトプログラミングコンテスト2022
 * （AtCoder Beginner Contest 280）
 * D - Factorial and Multiple
 * https://atcoder.jp/contests/abc280/tasks/abc280_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc280/submissions/37046573
 *
 * note:
 * - 素因数分解と二分探索の合わせ技
 * - 動画解説AC
 *
 */

package contests.abc.abc28x.abc280.abc280_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final long k = Long.parseLong(br.readLine());
    br.close();
    long rem = k, div = 2;
    //素因数分解
    Map<Long, Long> pf = new HashMap<>();
    while (div * div <= k && rem > 1) {
      if (rem % div == 0) {
        rem /= div;
        pf.put(div, pf.getOrDefault(div, 0L) + 1L);
      } else {
        div++;
      }
    }
    if (rem > 1) {
      pf.put(rem, 1L);
    }
    //二分探索
    long ok = k, ng = 1;
    while (ok - ng > 1) {
      long mid = (ok + ng) / 2;
      boolean isOK = true;
      for (long d : pf.keySet()) {
        if (func(mid, d) < pf.get(d)) {
          isOK = false;
          break;
        }
      }
      if (isOK) {
        ok = mid;
      } else {
        ng = mid;
      }
    }
    System.out.println(ok);
  }

  static long func(long d, long p) {
    if (p == 1L) {
      return d;
    }
    if (d == 0L) {
      return 0L;
    } else {
      return (d / p) + func(d / p, p);
    }
  }
}
