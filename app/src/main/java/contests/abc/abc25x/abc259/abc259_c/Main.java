/*
 * AtCoder Beginner Contest 259
 * C - XX to XXX
 * https://atcoder.jp/contests/abc259/tasks/abc259_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc259/submissions/37621126
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc259.abc259_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    final String t = br.readLine();
    br.close();
    boolean isOK = true;
    int idx_s = 0, idx_t = 0;
    while (idx_s < s.length() || idx_t < t.length()) {
      if (idx_s >= s.length() || idx_t >= t.length()) {
        isOK = false;
        break;
      }
      char ch_s = s.charAt(idx_s++);
      char ch_t = t.charAt(idx_t++);
      int cnt_s = 1, cnt_t = 1;
      while (idx_s < s.length() && s.charAt(idx_s) == ch_s) {
        idx_s++;
        cnt_s++;
      }
      while (idx_t < t.length() && t.charAt(idx_t) == ch_t) {
        idx_t++;
        cnt_t++;
      }
      if ((ch_s != ch_t) || cnt_s > cnt_t || (cnt_s == 1 && cnt_t > 1)) {
        isOK = false;
        break;
      }
    }
    System.out.println(isOK ? "Yes" : "No");
  }
}
