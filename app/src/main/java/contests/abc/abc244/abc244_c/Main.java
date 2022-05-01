/*
 * ABC244
 * C - Yamanote Line Game
 * https://atcoder.jp/contests/abc244/tasks/abc244_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc244/submissions/31377471
 *
 */

package contests.abc.abc244.abc244_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    TreeSet<Integer> t_set = new TreeSet<>();
    PrintWriter pw = new PrintWriter(System.out);
    int max = (2 * n) + 1;
    for (int i = 1; i <= max; i++) {
      t_set.add(i);
    }
    while (true) {
      pw.println(t_set.pollFirst());
      pw.flush();
      int x = Integer.parseInt(br.readLine());
      if (!t_set.remove(x)) {
        break;
      }
    }
    br.close();
    pw.close();
  }
}
