/*
 * ABC230
 * F - Predilection
 * https://atcoder.jp/contests/abc230/tasks/abc230_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc230/submissions/27810578
 */
package contests.abc.abc230.abc230_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

  static final long MOD = 998244353l;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[] array = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    br.close();

    Map<Long, Integer> sum_to_idx = new HashMap<>();
    long[] dp = new long[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    long sum = array[0];
    sum_to_idx.put(sum, 1);
    int k = 0;
    for (int i = 2; i <= n; i++) {
      dp[i] = ((dp[i - 1] * 2) % MOD) + MOD - dp[k];
      dp[i] %= MOD;
      sum += array[i - 1];
      k = sum_to_idx.getOrDefault(sum, 0);
      sum_to_idx.put(sum, i);
    }
    System.out.println(dp[n]);
  }
}
