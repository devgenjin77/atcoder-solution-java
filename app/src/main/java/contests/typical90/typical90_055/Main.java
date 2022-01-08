/*
 * 競プロ典型90問
 * 055 - Select 5（★2）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bc
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28370885
 *
 */
package contests.typical90.typical90_055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

  static long ans = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] npq = br.readLine().split(" ");
    int n = Integer.parseInt(npq[0]);
    long p = Long.parseLong(npq[1]);
    long q = Long.parseLong(npq[2]);
    long[] a = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    br.close();
    ans = 0;
    solve(1, p, q, a, 0, 5);
    System.out.println(ans);
  }

  static void solve(long val, long p, long q, long[] a, int idx, int remain) {
    for (int i = idx; i < a.length - (remain - 1); i++) {
      if (remain > 1) {
        solve(val * a[i] % p, p, q, a, i + 1, remain - 1);
      } else {
        if (val * a[i] % p == q) {
          ans += 1;
        }
      }
    }
  }
}
