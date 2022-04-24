/*
 * モノグサプログラミングコンテスト2022
 * （AtCoder Beginner Contest 249）
 * C - Just K
 * https://atcoder.jp/contests/abc249/tasks/abc249_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc249/submissions/31222534
 *
 */

package contests.abc.abc249.abc249_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]);
    String[] array_s = new String[n];
    for (int i = 0; i < n; i++) {
      array_s[i] = br.readLine();
    }
    br.close();
    int ans = 0;
    int[] cnt_c = new int[26];
    for (int bit = 1; bit < 1 << n; bit++) {
      int tmp = 0;
      Arrays.fill(cnt_c, 0);
      for (int idx = 0; idx < n; idx++) {
        if (((bit >> idx) & 1) == 1) {
          for (char ch : array_s[idx].toCharArray()) {
            cnt_c[ch - 'a'] += 1;
          }
        }
      }
      for (int cnt : cnt_c) {
        if (cnt == k) {
          tmp += 1;
        }
      }
      ans = Math.max(tmp, ans);
    }
    System.out.println(ans);
  }
}
