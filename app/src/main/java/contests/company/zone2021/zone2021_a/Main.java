/*
 * ZONeエナジー プログラミングコンテスト “HELLO SPACE”
 * A - UFO襲来
 * https://atcoder.jp/contests/zone2021/tasks/zone2021_a
 *
 * verified:
 * - https://atcoder.jp/contests/zone2021/submissions/22267741
 */
package contests.company.zone2021.zone2021_a;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    br.close();
    System.out.println(solve(s));
  }

  static int solve(String s) {
    int ans = 0;
    for (int i = 0; i < s.length() - 3; i++) {
      if (s.substring(i).startsWith("ZONe")) {
        ans++;
      }
    }
    return ans;
  }
}
