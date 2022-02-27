/*
 * ABC241
 * D - Sequence Query
 * https://atcoder.jp/contests/abc241/tasks/abc241_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc241/submissions/29730820
 *
 */
package contests.abc.abc241.abc241_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int q = Integer.parseInt(br.readLine());
    TreeSet<Pair> pair_tree_set = new TreeSet<>();
    PrintWriter pw = new PrintWriter(System.out);
    for (int id = 1; id <= q; id++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(st.nextToken());
      long x = Long.parseLong(st.nextToken());
      if (type == 1) {
        pair_tree_set.add(new Pair(x, id));
      } else {
        int k = Integer.parseInt(st.nextToken());
        if (type == 2) {
          Pair comp_p = new Pair(x, id);
          for (int cnt = 0; cnt < k; cnt++) {
            comp_p = pair_tree_set.lower(comp_p);
            if (comp_p == null) {
              break;
            }
          }
          pw.println(comp_p != null ? comp_p.x : -1);
        } else if (type == 3) {
          Pair comp_p = new Pair(x, 0);
          for (int cnt = 0; cnt < k; cnt++) {
            comp_p = pair_tree_set.higher(comp_p);
            if (comp_p == null) {
              break;
            }
          }
          pw.println(comp_p != null ? comp_p.x : -1);
        }
      }
    }
    pw.close();
    br.close();
  }

  static class Pair implements Comparable<Pair> {

    long x;
    int id;

    Pair(long x, int id) {
      this.x = x;
      this.id = id;
    }

    @Override
    public int compareTo(Pair o) {
      if (x != o.x) {
        return Long.compare(x, o.x);
      } else {
        return Integer.compare(id, o.id);
      }
    }
  }
}
