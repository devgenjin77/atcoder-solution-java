/*
 * ABC242
 * D - ABC Transform
 * https://atcoder.jp/contests/abc242/tasks/abc242_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc242/submissions/29917677
 *
 */
package contests.abc.abc242.abc242_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  static final String ABC = "ABC";

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    int q = Integer.parseInt(br.readLine());
    long[][] query = new long[q][2];
    for (int i = 0; i < q; i++) {
      String[] input = br.readLine().split(" ");
      query[i][0] = Long.parseLong(input[0]);
      query[i][1] = Long.parseLong(input[1]);
    }
    br.close();

    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < q; i++) {
      pw.println(ABC.charAt(func(s, query[i][0], query[i][1] - 1)));
    }
    pw.close();
  }

  static int func(String s, long t, long k) {
    int ret = 0;
    if (t == 0) {
      ret = s.charAt((int) k) - 'A';
    } else if (k == 0) {
      ret = s.charAt(0) - 'A';
      ret += (int) (t % 3);
    } else {
      if (k % 2 == 0) {
        ret = func(s, t - 1, k / 2) + 1;
      } else {
        ret = func(s, t - 1, k / 2) + 2;
      }
    }
    return ret % 3;
  }
}
