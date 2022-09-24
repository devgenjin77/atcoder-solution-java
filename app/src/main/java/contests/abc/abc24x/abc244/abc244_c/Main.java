/*
 * AtCoder Beginner Contest 244
 * C - Yamanote Line Game
 * https://atcoder.jp/contests/abc244/tasks/abc244_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc244/submissions/35082614
 *
 * note:
 * インタラクティブ問題
 */

package contests.abc.abc24x.abc244.abc244_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final PrintWriter pw = new PrintWriter(System.out);
    final int n = Integer.parseInt(br.readLine());
    final boolean[] used = new boolean[(n + 1) * 2];
    final Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i < (n + 1) * 2; i++) {
      queue.add(i);
    }
    while (!queue.isEmpty()) {
      int ans = queue.poll();
      if (used[ans]) {
        continue;
      }
      used[ans] = true;
      pw.println(ans);
      pw.flush();
      int ret = Integer.parseInt(br.readLine());
      used[ret] = true;
    }
    pw.close();
    br.close();
  }
}
