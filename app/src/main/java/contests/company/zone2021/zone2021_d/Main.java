/*
 * ZONeエナジー プログラミングコンテスト “HELLO SPACE”
 * D - 宇宙人からのメッセージ
 * https://atcoder.jp/contests/zone2021/tasks/zone2021_d
 *
 * verified:
 * - https://atcoder.jp/contests/zone2021/submissions/22268461
 */
package contests.company.zone2021.zone2021_d;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    br.close();
    System.out.println(solve(s));
  }

  static String solve(String s) {
    Deque<Character> deque = new ArrayDeque<>();
    boolean isRev = false;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == 'R') {
        isRev = !isRev;
      } else {
        if (deque.isEmpty()) {
          deque.add(c);
        } else {
          if (isRev) {
            if (c == deque.getFirst()) {
              deque.removeFirst();
            } else {
              deque.addFirst(c);
            }
          } else {
            if (c == deque.getLast()) {
              deque.removeLast();
            } else {
              deque.addLast(c);
            }
          }
        }
      }
    }
    StringBuilder sb = new StringBuilder();
    for (char c : deque) {
      sb.append(c);
    }
    if (isRev) {
      sb.reverse();
    }
    return sb.toString();
  }
}
