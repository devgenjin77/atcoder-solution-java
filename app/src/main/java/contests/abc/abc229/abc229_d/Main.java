/*
 * ABC229
 * D - Longest X
 * https://atcoder.jp/contests/abc229/tasks/abc229_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc229/submissions/27561053
 */
package contests.abc.abc229.abc229_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int k = Integer.parseInt(br.readLine());
    br.close();
    System.out.println(solve(s, k));
  }

  static int solve(String s, int k) {
    if (s.indexOf('.') < 0) {
      return s.length();
    }
    List<Integer> list = new ArrayList<>();
    int x_cnt = 0;
    list.add(0);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '.') {
        list.add(i + 1);
      }
    }
    list.add(s.length() + 1);
    if (k >= list.size() - 2) {
      return s.length();
    }
    int ans = 0;
    for (int i = 0; i + k + 1 < list.size(); i++) {
      ans = Math.max(list.get(i + k + 1) - list.get(i) - 1, ans);
    }
    return ans;
  }
}
