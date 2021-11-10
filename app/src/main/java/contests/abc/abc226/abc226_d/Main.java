/*
 * ABC226
 * D - Teleportation
 * https://atcoder.jp/contests/abc226/tasks/abc226_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc226/submissions/27169256
 */
package contests.abc.abc226.abc226_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[][] pos_array = new long[n][2];
    Set<Pair> pairs = new HashSet<>();
    for (int i = 0; i < n; i++) {
      String[] data = br.readLine().split(" ");
      pos_array[i][0] = Long.parseLong(data[0]);
      pos_array[i][1] = Long.parseLong(data[1]);
    }
    br.close();

    for (int from = 0; from < n; from++) {
      for (int to = 0; to < n; to++) {
        if (from == to) {
          continue;
        }
        long x_move = pos_array[to][0] - pos_array[from][0];
        long y_move = pos_array[to][1] - pos_array[from][1];
        long gcd = gcd(Math.abs(x_move), Math.abs(y_move));
        if (gcd != 0) {
          x_move /= gcd;
          y_move /= gcd;
        }
        pairs.add(new Pair(x_move, y_move));
      }
    }
    System.out.println(pairs.size());
  }

  static class Pair {

    long x, y;

    Pair(long x, long y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Pair pair = (Pair) o;
      return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }

  static long gcd(long a, long b) {
    return b == 0 ? a : gcd(b, a % b);
  }
}
