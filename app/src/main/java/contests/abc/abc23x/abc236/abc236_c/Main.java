/*
 * AtCoder Beginner Contest 236
 * C - Route Map
 * https://atcoder.jp/contests/abc236/tasks/abc236_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc236/submissions/33922199
 *
 * note:
 *
 *
 */

package contests.abc.abc23x.abc236.abc236_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final String[] array_s = br.readLine().split(" ");
    final String[] array_t = br.readLine().split(" ");
    br.close();
    PrintWriter pw = new PrintWriter(System.out);
    int idx_t = 0;
    for (int i = 0; i < n; i++) {
      if (array_s[i].equals(array_t[idx_t])) {
        pw.println("Yes");
        idx_t++;
      } else {
        pw.println("No");
      }
    }
    pw.close();
  }
}
