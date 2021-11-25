/*
 * ARC129
 * B - Range Point Distance
 * https://atcoder.jp/contests/arc129/tasks/arc129_b
 *
 * verified:
 * - https://atcoder.jp/contests/arc129/submissions/27490494
 */
package contests.arc.arc129.arc129_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int l_max = 0, r_min = Integer.MAX_VALUE;
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < n; i++) {
      String[] line = br.readLine().split(" ");
      int l = Integer.parseInt(line[0]);
      int r = Integer.parseInt(line[1]);
      l_max = Math.max(l, l_max);
      r_min = Math.min(r, r_min);
      pw.println(Math.max(l_max - r_min + 1, 0) / 2);
    }
    br.close();
    pw.close();
  }
}
