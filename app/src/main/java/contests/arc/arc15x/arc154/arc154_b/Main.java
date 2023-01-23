/*
 * AtCoder Regular Contest 154
 * B - New Place
 * https://atcoder.jp/contests/arc154/tasks/arc154_b
 *
 * verified:
 * - https://atcoder.jp/contests/arc154/submissions/38284720
 *
 * note:
 * ・SとTの文字種と数が合わない場合No
 * ・Sの接尾文字列がどこまでTの部分列になるかを見る。
 *
 */

package contests.arc.arc15x.arc154.arc154_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String s = br.readLine();
    final String t = br.readLine();
    br.close();
    final int[] cnt_s = new int[26];
    final int[] cnt_t = new int[26];
    for (int i = 0; i < n; i++) {
      cnt_s[s.charAt(i) - 'a']++;
      cnt_t[t.charAt(i) - 'a']++;
    }
    int ans = 0;
    if (!Arrays.equals(cnt_s, cnt_t)) {
      ans = -1;
    } else {
      int idx_s = n - 1, idx_t = n - 1;
      //Sを後ろからチェックし、どこまでTの部分列になれるかみていく
      while (idx_s >= 0 && idx_t >= 0) {
        if (s.charAt(idx_s) == t.charAt(idx_t--)) {
          idx_s--;
        }
      }
      ans = idx_s + 1;
    }
    System.out.println(ans);
  }
}
