/*
 * ABC240
 * D - Strange Balls
 * https://atcoder.jp/contests/abc240/tasks/abc240_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc240/submissions/32289857
 *
 */

package contests.abc.abc24x.abc240.abc240_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    int ans = 0;
    Deque<Pair> deque = new ArrayDeque<>();
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < n; i++) {
      int a = Integer.parseInt(st.nextToken());
      if (deque.size() == 0 || deque.getLast().first != a) {
        deque.addLast(new Pair(a, 1));
        ans++;
      } else {
        Pair p = deque.getLast();
        if (p.second + 1 == a) {
          deque.removeLast();
          ans -= p.second;
        } else {
          p.second += 1;
          ans++;
        }
      }
      pw.println(ans);
    }
    pw.close();
  }

  static class Pair {

    int first, second;

    public Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }
}
