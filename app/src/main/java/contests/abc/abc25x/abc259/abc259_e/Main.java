/*
 * AtCoder Beginner Contest 259
 * E - LCM on Whiteboard
 * https://atcoder.jp/contests/abc259/tasks/abc259_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc259/submissions/37637334
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc259.abc259_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final List<IntTriple> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int m = Integer.parseInt(br.readLine());
      for (int j = 0; j < m; j++) {
        StringTokenizer st_p = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st_p.nextToken());
        int e = Integer.parseInt(st_p.nextToken());
        list.add(new IntTriple(p, e, i));
      }
    }
    br.close();
    Collections.sort(list);
    boolean[] isTarget = new boolean[n];
    for (int i = 0; i < list.size(); i++) {
      if (i == list.size() - 1 || list.get(i).first != list.get(i + 1).first) {
        //Pの切り替わりのタイミング
        if (i == 0 || list.get(i - 1).first != list.get(i).first
            || list.get(i - 1).second < list.get(i).second) {
          //左端の要素、前のPの値が異なる、Pが同じだが、次数が小さい
          isTarget[list.get(i).third] = true;
        }
      }
    }
    int ans = 1;
    for (boolean b : isTarget) {
      if (b) {
        ans++;
      }
    }
    System.out.println(Math.min(ans, n));
  }

  static class IntTriple implements Comparable<IntTriple> {

    int first, second, third;

    public IntTriple(int first, int second, int third) {
      this.first = first;
      this.second = second;
      this.third = third;
    }

    @Override
    public int compareTo(IntTriple o) {
      if (this.first != o.first) {
        return Integer.compare(this.first, o.first);
      } else if (this.second != o.second) {
        return Integer.compare(this.second, o.second);
      } else {
        return Integer.compare(this.third, o.third);
      }
    }
  }
}
