/*
 * AtCoder Beginner Contest 237
 * D - LR insertion
 * https://atcoder.jp/contests/abc237/tasks/abc237_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc237/submissions/33927313
 *
 * note:
 * 両端キューを使う
 *
 */

package contests.abc.abc23x.abc237.abc237_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String s = br.readLine();
    br.close();
    final Deque<Integer> deque = new ArrayDeque<>();
    deque.add(n);
    for (int i = n - 1; i >= 0; i--) {
      //LとRの操作を逆順で解釈
      if (s.charAt(i) == 'L') {
        deque.addLast(i);
      } else {
        deque.addFirst(i);
      }
    }
    StringBuilder sb = new StringBuilder();
    for (Integer i : deque) {
      sb.append(i).append(' ');
    }
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(sb.deleteCharAt(sb.length() - 1));
    pw.close();
  }
}
