/*
 * AtCoder Regular Contest 151
 * A - Equal Hamming Distances
 * https://atcoder.jp/contests/arc151/tasks/arc151_a
 *
 * verified:
 * - https://atcoder.jp/contests/arc151/submissions/35774230
 *
 * note:
 *
 */

package contests.arc.arc15x.arc151.arc151_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final String s = br.readLine();
    final String t = br.readLine();
    br.close();
    final StringBuilder buf_u = new StringBuilder();
    int dist = 0; //Sとのハミング距離とTとのハミング距離の差
    for (int i = 0; i < n; i++) {
      buf_u.append('0');
      dist += (s.charAt(i) - '0') - (t.charAt(i) - '0');
    }
    if (Math.abs(dist) % 2 == 1) {
      System.out.println(-1);
      return;
    }
    int idx = n - 1;
    while (dist != 0 && idx >= 0) {
      int df = (s.charAt(idx) - '0') - (t.charAt(idx) - '0');
      //dfとdistのプラマイが同じかを見たい
      if (df * dist > 0) {
        buf_u.setCharAt(idx, '1');
        dist = dist > 0 ? dist - 2 : dist + 2;
      }
      idx--;
    }
    System.out.println(buf_u);
  }
}
