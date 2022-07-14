/*
 * AtCoder Beginner Contest 221
 * B - typo
 * https://atcoder.jp/contests/abc221/tasks/abc221_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc221/submissions/33224758
 *
 * note:
 * 前から比較して、異なる文字がある場合、一度だけ入れ替える
 */

package contests.abc.abc22x.abc221.abc221_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    final String t = br.readLine();
    br.close();
    StringBuilder s_buf = new StringBuilder(s);
    boolean isOk = true;
    if (s.equals(t)) {
      // そもそも同じの場合なにもしない
    } else {
      for (int i = 0; i < s_buf.length() - 1; i++) {
        //前から比較して、異なる文字がある場合、一度だけ入れ替える
        if (s_buf.charAt(i) != t.charAt(i)) {
          s_buf.setCharAt(i, s.charAt(i + 1));
          s_buf.setCharAt(i + 1, s.charAt(i));
          isOk = t.equals(s_buf.toString());
          break;
        }
      }
    }
    System.out.println(isOk ? "Yes" : "No");
  }
}
