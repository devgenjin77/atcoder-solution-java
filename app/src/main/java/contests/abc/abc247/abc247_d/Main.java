/*
 * ABC247
 * D - Cylinder
 * https://atcoder.jp/contests/abc247/tasks/abc247_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc247/submissions/30917262
 *
 */

package contests.abc.abc247.abc247_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    NextScanner nc = new NextScanner();
    int q = Integer.parseInt(nc.next());
    Deque<Pair> queue = new ArrayDeque<>();
    PrintWriter pw = new PrintWriter(System.out);
    long now_x = 0, now_c = 0;
    for (int i = 0; i < q; i++) {
      int type = Integer.parseInt(nc.next());
      if (type == 1) {
        long x = Long.parseLong(nc.next());
        long c = Long.parseLong(nc.next());
        queue.addLast(new Pair(x, c));
      } else if (type == 2) {
        long ans = 0;
        long remain = Long.parseLong(nc.next());
        while (remain > 0) {
          if (now_c == 0) {
            Pair p = queue.pollFirst();
            now_x = p.x;
            now_c = p.c;
          }
          long use_c = Long.min(remain, now_c);
          remain -= use_c;
          now_c -= use_c;
          ans += now_x * use_c;
        }
        pw.println(ans);
      }
    }
    pw.close();
    nc.close();
  }

  static class Pair {

    long x, c;

    Pair(long x, long c) {
      this.x = x;
      this.c = c;
    }
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
