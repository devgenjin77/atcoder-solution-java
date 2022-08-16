/*
 * モノグサプログラミングコンテスト2022
 * （AtCoder Beginner Contest 249）
 * C - Just K
 * https://atcoder.jp/contests/abc249/tasks/abc249_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc249/submissions/34094028
 *
 * note:
 * bit全探索
 *
 */

package contests.abc.abc24x.abc249.abc249_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer nk = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(nk.nextToken());
    final int k = Integer.parseInt(nk.nextToken());
    final String[] array_s = new String[n];
    for (int i = 0; i < n; i++) {
      array_s[i] = br.readLine();
    }
    br.close();
    final int[] ch_cnt = new int[26];
    int ans = 0;
    //bit全探索
    for (int bit = 1; bit < (1 << n); bit++) {
      if (Integer.bitCount(bit) < k) {
        continue;
      }
      Arrays.fill(ch_cnt, 0);
      for (int i = 0; i < n; i++) {
        if ((bit >> i & 1) == 0) {
          continue;
        }
        String s = array_s[i];
        for (int j = 0; j < s.length(); j++) {
          ch_cnt[s.charAt(j) - 'a']++;
        }
      }
      int tmp_ans = 0;
      for (int cnt : ch_cnt) {
        if (cnt == k) {
          tmp_ans++;
        }
      }
      ans = Math.max(tmp_ans, ans);
    }
    System.out.println(ans);
  }
}
