/*
 * モノグサプログラミングコンテスト2022
 * （AtCoder Beginner Contest 249）
 * B - Perfect String
 * https://atcoder.jp/contests/abc249/tasks/abc249_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc249/submissions/31222252
 *
 */

package contests.abc.abc249.abc249_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    br.close();
    System.out.println(solve(s) ? "Yes" : "No");
  }

  static boolean solve(String s) {
    Set<Character> set = new HashSet<>();
    boolean exist_up = false;
    boolean exist_sm = false;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (Character.isUpperCase(c)) {
        exist_up = true;
      } else {
        exist_sm = true;
      }
      if (set.contains(c)) {
        return false;
      } else {
        set.add(c);
      }
    }
    return exist_up && exist_sm;
  }
}
