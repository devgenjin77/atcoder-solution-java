/*
 * NECプログラミングコンテスト2022
 * （AtCoder Beginner Contest 267）
 * A - Saturday
 * https://atcoder.jp/contests/abc267/tasks/abc267_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc267/submissions/34599447
 *
 */

package contests.abc.abc26x.abc267.abc267_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String s = br.readLine();
    br.close();
    final Map<String, Integer> ans_map = new HashMap<>();
    ans_map.put("Monday", 5);
    ans_map.put("Tuesday", 4);
    ans_map.put("Wednesday", 3);
    ans_map.put("Thursday", 2);
    ans_map.put("Friday", 1);
    System.out.println(ans_map.getOrDefault(s, -1));
  }
}
