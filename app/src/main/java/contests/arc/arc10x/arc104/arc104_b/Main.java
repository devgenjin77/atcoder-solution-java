/*
 * AtCoder Regular Contest 104
 * B - DNA Sequence
 * https://atcoder.jp/contests/arc104/tasks/arc104_b
 *
 * verified:
 * - https://atcoder.jp/contests/arc104/submissions/37659776
 *
 * note:
 *
 */

package contests.arc.arc10x.arc104.arc104_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final String s = st.nextToken();
    br.close();
    final Map<IntPair, Integer> cnt_map = new HashMap<>();
    int sum_at = 0, sum_gc = 0;
    int ans = 0;
    cnt_map.put(new IntPair(0, 0), 1);
    for (int i = 0; i < n; i++) {
      char c = s.charAt(i);
      if (c == 'A') {
        sum_at++;
      } else if (c == 'T') {
        sum_at--;
      } else if (c == 'G') {
        sum_gc++;
      } else if (c == 'C') {
        sum_gc--;
      }
      IntPair p = new IntPair(sum_at, sum_gc);
      ans += cnt_map.getOrDefault(p, 0);
      cnt_map.put(p, cnt_map.getOrDefault(p, 0) + 1);
    }
    System.out.println(ans);
  }

  static final class IntPair implements Comparable<IntPair> {

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

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      IntPair p = (IntPair) o;
      return this.first == p.first && this.second == p.second;
    }

    @Override
    public int hashCode() {
      return java.util.Objects.hash(first, second);
    }
  }
}
