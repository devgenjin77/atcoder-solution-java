/*
 * ABC236
 * F - Spices
 * https://atcoder.jp/contests/abc236/tasks/abc236_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc236/submissions/28854724
 *
 */
package contests.abc.abc236.abc236_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int nx = 1 << n;
    String[] prices = br.readLine().split(" ");
    br.close();
    List<Spice> list = new ArrayList<>();
    for (int i = 0; i < prices.length; i++) {
      list.add(new Spice(i + 1, Long.parseLong(prices[i])));
    }
    Collections.sort(list, (Comparator.comparingLong(o -> o.price)));
    boolean[] used = new boolean[nx];
    Arrays.fill(used, false);
    used[0] = true;
    long ans = 0;
    for (Spice spice : list) {
      if (!used[spice.no]) {
        ans += spice.price;
        for (int i = 0; i < nx; i++) {
          if (used[i]) {
            used[i ^ spice.no] = true;
          }
        }
      }
    }
    System.out.println(ans);
  }

  static class Spice {

    int no;
    long price;

    Spice(int no, long price) {
      this.no = no;
      this.price = price;
    }
  }
}
