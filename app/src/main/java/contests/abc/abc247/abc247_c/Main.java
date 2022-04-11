/*
 * ABC247
 * C - 1 2 1 3 1 2 1
 * https://atcoder.jp/contests/abc247/tasks/abc247_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc247/submissions/30873876
 *
 */

package contests.abc.abc247.abc247_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner nc = new NextScanner();
    int n = Integer.parseInt(nc.next());
    nc.close();
    String[] ans = new String[n + 1];
    ans[1] = "1";
    for (int i = 2; i <= n; i++) {
      StringBuilder sb = new StringBuilder();
      sb.append(ans[i - 1]).append(" ").append(i).append(" ").append(ans[i - 1]);
      ans[i] = sb.toString();
    }
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(ans[n]);
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
