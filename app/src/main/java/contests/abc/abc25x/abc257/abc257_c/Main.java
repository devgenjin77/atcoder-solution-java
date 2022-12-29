/*
 * 日鉄ソリューションズプログラミングコンテスト2022
 * （AtCoder Beginner Contest 257）
 * C - Robot Takahashi
 * https://atcoder.jp/contests/abc257/tasks/abc257_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc257/submissions/37613522
 *
 */

package contests.abc.abc25x.abc257.abc257_c;

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
    final String s = br.readLine();
    final StringTokenizer st_w = new StringTokenizer(br.readLine());
    final int[] array_w = new int[n];
    for (int i = 0; i < n; i++) {
      array_w[i] = Integer.parseInt(st_w.nextToken());
    }
    br.close();
    List<IntPair> list = new ArrayList<>();
    int cnt_adult = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '1') {
        cnt_adult++;
      }
      list.add(new IntPair(array_w[i], s.charAt(i) == '1' ? 1 : 0));
    }
    Collections.sort(list);

    int ans = 0;
    if (cnt_adult == 0 || cnt_adult == n) {
      ans = n;
    } else {
      int cnt_child = 0;
      for (int i = 0; i < n; i++) {
        if (i == 0 || list.get(i - 1).first != list.get(i).first) {
          ans = Math.max(cnt_adult + cnt_child, ans);
        }
        if (list.get(i).second == 1) {
          cnt_adult--;
        } else {
          cnt_child++;
        }
      }
    }
    System.out.println(ans);
  }

  static class IntPair implements Comparable<IntPair> {

    int first, second;

    public IntPair(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public int compareTo(IntPair o) {
      if (this.first != o.first) {
        return Integer.compare(this.first, o.first);
      } else {
        return Integer.compare(this.second, o.second);
      }
    }
  }
}
