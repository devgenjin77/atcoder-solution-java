/*
 * AtCoder Beginner Contest 223
 * B - String Shifting
 * https://atcoder.jp/contests/abc223/tasks/abc223_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc223/submissions/33495097
 *
 * note:
 * compareToメソッドで文字列の大小を比較
 *
 */

package contests.abc.abc22x.abc223.abc223_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    br.close();
    String s_min = s;
    String s_max = s;
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0; i < s.length() - 1; i++) {
      sb.append(sb.charAt(0));
      sb.deleteCharAt(0);
      String s_next = sb.toString();
      if (s_next.compareTo(s_min) < 0) {
        s_min = s_next;
      }
      if (s_next.compareTo(s_max) > 0) {
        s_max = s_next;
      }
    }
    System.out.println(s_min);
    System.out.println(s_max);
  }
}
