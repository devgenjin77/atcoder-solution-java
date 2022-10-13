/*
 * AtCoder Regular Contest 148
 * B - dp
 * https://atcoder.jp/contests/arc148/tasks/arc148_b
 *
 * verified:
 * - https://atcoder.jp/contests/arc148/submissions/35627765
 *
 * note:
 * 先頭は、最初に出たpの位置で固定。その後ろのpの位置で変換することを全探索
 */

package contests.arc.arc14x.arc148.arc148_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String s = br.readLine();
    br.close();
    String ans = s;
    int idx_p = ans.indexOf('p');
    if (idx_p >= 0) {
      for (int right = idx_p; right < n; right++) {
        if (s.charAt(right) == 'd') {
          continue;
        }
        StringBuilder buf = new StringBuilder(s);
        for (int i = idx_p; i <= right; i++) {
          buf.setCharAt(i, s.charAt(right - (i - idx_p)) == 'd' ? 'p' : 'd');
        }
        String n_s = buf.toString();
        if (ans.compareTo(n_s) > 0) {
          ans = n_s;
        }
      }
    }
    System.out.println(ans);
  }
}
