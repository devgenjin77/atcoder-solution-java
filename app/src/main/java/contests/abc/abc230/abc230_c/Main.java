/*
 * ABC230
 * C - X drawing
 * https://atcoder.jp/contests/abc230/tasks/abc230_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc230/submissions/27784942
 */
package contests.abc.abc230.abc230_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] data1 = br.readLine().split(" ");
    String[] data2 = br.readLine().split(" ");
    br.close();
    long n = Long.parseLong(data1[0]);
    long a = Long.parseLong(data1[1]);
    long b = Long.parseLong(data1[2]);

    long p = Long.parseLong(data2[0]);
    long q = Long.parseLong(data2[1]);
    long r = Long.parseLong(data2[2]);
    long s = Long.parseLong(data2[3]);

    PrintWriter pw = new PrintWriter(System.out);
    for (long h_pos = p; h_pos <= q; h_pos++) {
      StringBuilder line = new StringBuilder();
      for (long w_pos = r; w_pos <= s; w_pos++) {
        if (Math.abs(h_pos - a) == Math.abs(w_pos - b)) {
          line.append('#');
        } else {
          line.append('.');
        }
      }
      pw.println(line.toString());
    }
    pw.close();
  }
}
