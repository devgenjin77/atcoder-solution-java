/*
 * ABC218
 * D - Rectangles
 * https://atcoder.jp/contests/abc218/tasks/abc218_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc218/submissions/25809745
 */
package contests.abc.abc218.abc218_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    HashMap<Integer, HashSet<Integer>> xtoy = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String[] data = br.readLine().split(" ");
      int x = Integer.parseInt(data[0]);
      int y = Integer.parseInt(data[1]);
      if (xtoy.containsKey(x) == false) {
        xtoy.put(x, new HashSet<>());
      }
      xtoy.get(x).add(y);
    }
    br.close();

    int ans = 0;
    int[] xarray = xtoy.keySet().stream().mapToInt(Integer::intValue).toArray();
    Arrays.sort(xarray);
    for (int x1 = 0; x1 < xarray.length - 1; x1++) {
      for (int x2 = x1 + 1; x2 < xarray.length; x2++) {
        int tmpcnt = 0;
        HashSet<Integer> ymap1 = xtoy.get(xarray[x1]);
        HashSet<Integer> ymap2 = xtoy.get(xarray[x2]);
        for (int ykey : ymap1) {
          if (ymap2.contains(ykey)) {
            tmpcnt += 1;
          }
        }
        ans += (tmpcnt * (tmpcnt - 1)) / 2;
      }
    }
    System.out.println(ans);
  }
}
