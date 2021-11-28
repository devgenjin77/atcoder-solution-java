/*
 * ABC229
 * C - Cheese
 * https://atcoder.jp/contests/abc229/tasks/abc229_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc229/submissions/27560257
 */
package contests.abc.abc229.abc229_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nw = br.readLine().split(" ");
    int n = Integer.parseInt(nw[0]);
    long w = Long.parseLong(nw[1]);
    PriorityQueue<Cheese> queue = new PriorityQueue<>(
        (c1, c2) -> Long.compare(c2.deliciousness, c1.deliciousness));
    for (int i = 0; i < n; i++) {
      String[] ab = br.readLine().split(" ");
      long a = Long.parseLong(ab[0]);
      long b = Long.parseLong(ab[1]);
      queue.add(new Cheese(a, b));
    }
    long remain = w;
    long total = 0;
    while (remain > 0 && !queue.isEmpty()) {
      Cheese c = queue.poll();
      total += c.deliciousness * Math.min(c.grams, remain);
      remain -= c.grams;
    }
    System.out.println(total);
  }

  static class Cheese {

    long deliciousness, grams;

    Cheese(long deliciousness, long grams) {
      this.deliciousness = deliciousness;
      this.grams = grams;
    }
  }
}
