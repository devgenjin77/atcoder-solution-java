/*
 * AtCoder Beginner Contest 230
 * B - Triple Metre
 * https://atcoder.jp/contests/abc230/tasks/abc230_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc230/submissions/33886238
 *
 * note:
 * oが周期3で出現しているかを判定する
 *
 */

package contests.abc.abc23x.abc230.abc230_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    br.close();
    boolean isOk = true;
    int period_o = s.indexOf('o');
    if (period_o < 0 && s.length() >= 3) {
      // oが無く、かつ文字長が3以上ならNG
      isOk = false;
    } else {
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if ((c == 'o' && i % 3 == period_o) || (c == 'x' && i % 3 != period_o)) {
          // do nothing
        } else {
          isOk = false;
          break;
        }
      }
    }
    System.out.println(isOk ? "Yes" : "No");
  }
}
