/*
 * ABC247
 * A - Move Right
 * https://atcoder.jp/contests/abc247/tasks/abc247_a
 *
 * verified:
 * - https://atcoder.jp/contests/abc247/submissions/30914566
 *
 */

package contests.abc.abc247.abc247_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner nc = new NextScanner();
    String s = nc.next();
    nc.close();
    StringBuilder sb = new StringBuilder();
    sb.append("0").append(s);
    PrintWriter pw = new PrintWriter(System.out);
    pw.println(sb.substring(0, 4));
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
