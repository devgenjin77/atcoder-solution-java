/*
 * ABC223
 * B - String Shifting
 * https://atcoder.jp/contests/abc223/tasks/abc223_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc223/submissions/31449550
 *
 */

package contests.abc.abc223.abc223_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    br.close();
    String s_max = s;
    String s_min = s;
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0; i < s.length(); i++) {
      sb.append(sb.charAt(0));
      sb.deleteCharAt(0);
      String com_s = sb.toString();
      if (s_max.compareTo(com_s) < 0) {
        s_max = com_s;
      }
      if (s_min.compareTo(com_s) > 0) {
        s_min = com_s;
      }
    }
    System.out.println(s_min);
    System.out.println(s_max);
  }
}
