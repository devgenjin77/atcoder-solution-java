/*
 * ARC135
 * A - Floor, Ceil - Decomposition
 * https://atcoder.jp/contests/arc135/tasks/arc135_a
 *
 * verified:
 * - https://atcoder.jp/contests/arc135/submissions/29338005
 *
 * Note:
 * メモ化DFS
 *
 */
package contests.arc.arc135.arc135_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

  static final long MOD = 998244353l;
  static HashMap<Long, Long> memo;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(br.readLine());
    br.close();
    memo = new HashMap<>();
    System.out.println(dfs(n));
  }

  static long dfs(long n) {
    if (memo.containsKey(n)) {
      return memo.get(n);
    }
    if(n <= 4){
      return n;
    }
    memo.put(n, (dfs((n + 1) / 2) * dfs(n / 2)) % MOD);
    return memo.get(n);
  }
}
