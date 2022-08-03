/*
 * AtCoder Beginner Contest 226
 * D - Teleportation
 * https://atcoder.jp/contests/abc226/tasks/abc226_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc226/submissions/33752964
 *
 * note:
 * 相異なる座標間の傾きをSetで管理し、総数を答える
 *
 */

package contests.abc.abc22x.abc226.abc226_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final Set<IntegerPair> set_pair = new HashSet<>();
    final int[] array_x = new int[n];
    final int[] array_y = new int[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      array_x[i] = Integer.parseInt(st.nextToken());
      array_y[i] = Integer.parseInt(st.nextToken());
    }
    br.close();
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int dx = array_x[j] - array_x[i];
        int dy = array_y[j] - array_y[i];
        if (dx == 0) {
          set_pair.add(new IntegerPair(0, 1));
          set_pair.add(new IntegerPair(0, -1));
        } else if (dy == 0) {
          set_pair.add(new IntegerPair(1, 0));
          set_pair.add(new IntegerPair(-1, 0));
        } else {
          int d = gcd(dx, dy);
          dx /= d;
          dy /= d;
          set_pair.add(new IntegerPair(dx, dy));
          set_pair.add(new IntegerPair(-dx, -dy));
        }
      }
    }
    System.out.println(set_pair.size());
  }

  static int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
  }

  static class IntegerPair implements Comparable<IntegerPair> {

    int dx, dy;

    public IntegerPair(int dx, int dy) {
      this.dx = dx;
      this.dy = dy;
    }

    @Override
    public int compareTo(IntegerPair o) {
      if (dx != o.dx) {
        return Integer.compare(dx, o.dx);
      } else {
        return Integer.compare(dy, o.dy);
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
      IntegerPair pair = (IntegerPair) o;
      return dx == pair.dx && dy == pair.dy;
    }

    @Override
    public int hashCode() {
      return java.util.Objects.hash(dx, dy);
    }
  }
}
