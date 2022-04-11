/*
 * ABC247
 * B - Unique Nicknames
 * https://atcoder.jp/contests/abc247/tasks/abc247_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc247/submissions/30915465
 *
 */

package contests.abc.abc247.abc247_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner nc = new NextScanner();
    int n = Integer.parseInt(nc.next());
    String[] arr_s = new String[n];
    String[] arr_t = new String[n];
    for (int i = 0; i < n; i++) {
      arr_s[i] = nc.next();
      arr_t[i] = nc.next();
    }
    nc.close();
    boolean ok = true;
    boolean b1 = false;
    boolean b2 = false;
    main_loop:
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) {
          continue;
        }
        if (!b1 && (arr_s[i].equals(arr_s[j]) || arr_s[i].equals(arr_t[j]))) {
          b1 = true;
        }
        if (!b2 && (arr_t[i].equals(arr_s[j]) || arr_t[i].equals(arr_t[j]))) {
          b2 = true;
        }
        if (b1 && b2) {
          ok = false;
          break main_loop;
        }
      }
    }
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(ok ? "Yes" : "No");
    pw.close();
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
