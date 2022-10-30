/*
 * AtCoder Beginner Contest 275
 * A - Find Takahashi
 * https://atcoder.jp/contests/abc275/tasks/abc275_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc275/submissions/36101056
 *
 * note:
 *
 *
 */

package contests.abc.abc27x.abc275.abc275_a;

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
    final StringTokenizer st_h = new StringTokenizer(br.readLine());
    final List<IntPair> list_h = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      list_h.add(new IntPair(Integer.parseInt(st_h.nextToken()), i));
    }
    br.close();
    Collections.sort(list_h);
    System.out.println(list_h.get(n - 1).second + 1);
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
