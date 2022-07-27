/*
 * UNICORNプログラミングコンテスト2021
 * （AtCoder Beginner Contest 225）
 * A - Distinct Strings
 * https://atcoder.jp/contests/abc225/tasks/abc225_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc225/submissions/33559162
 *
 * note:
 *
 *
 */

package contests.abc.abc22x.abc225.abc225_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    br.close();
    Set<Character> set_s = new HashSet<>();
    for (int i = 0; i < 3; i++) {
      set_s.add(s.charAt(i));
    }
    int ans = 0;
    if (set_s.size() == 1) {
      ans = 1;
    } else if (set_s.size() == 2) {
      ans = 3;
    } else if (set_s.size() == 3) {
      ans = 6;
    }
    System.out.println(ans);
  }
}
