/*
 * ABC247
 * E - Max Min
 * https://atcoder.jp/contests/abc247/tasks/abc247_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc247/submissions/30929538
 *
 */

package contests.abc.abc247.abc247_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner nc = new NextScanner();
    int n = Integer.parseInt(nc.next());
    int x = Integer.parseInt(nc.next());
    int y = Integer.parseInt(nc.next());
    int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(nc.next());
    }
    nc.close();
    long ans = 0;
    int pos_x = -1, pos_y = -1, pos_ng = -1;
    for (int i = 0; i < n; i++) {
      if (array_a[i] == x) {
        pos_x = i;
      }
      if (array_a[i] == y) {
        pos_y = i;
      }
      if (array_a[i] > x || array_a[i] < y) {
        pos_ng = i;
      }
      ans += Math.max(Math.min(pos_x, pos_y) - pos_ng, 0);
    }
    System.out.println(ans);
  }

  //NextScannerライブラリ
  static class NextScanner implements AutoCloseable {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st;

    public String next() throws IOException {
      if (st == null || !st.hasMoreElements()) {
        st = new StringTokenizer(in.readLine());
      }
      return st.nextToken();
    }

    @Override
    public void close() throws Exception {
      in.close();
    }
  }
}
