/*
 * パナソニックプログラミングコンテスト2021
 * （AtCoder Beginner Contest 231）
 * B - Election
 * https://atcoder.jp/contests/abc231/tasks/abc231_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc231/submissions/33897676
 *
 * note:
 * 連想配列で投票数を管理
 *
 */

package contests.abc.abc23x.abc231.abc231_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final Map<String, Integer> vote_cnt = new HashMap<>();
    String ans = "";
    int max_vote = 0;
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      int now = vote_cnt.getOrDefault(s, 0) + 1;
      vote_cnt.put(s, now);
      if (now > max_vote) {
        ans = s;
        max_vote = now;
      }
    }
    br.close();
    System.out.println(ans);
  }
}
