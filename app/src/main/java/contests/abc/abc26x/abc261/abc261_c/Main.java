/*
 * AtCoder Beginner Contest 261
 * C - NewFolder(1)
 * https://atcoder.jp/contests/abc261/tasks/abc261_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc261/submissions/37640288
 *
 * note:
 *
 *
 */

package contests.abc.abc26x.abc261.abc261_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final Map<String, Integer> str_cnt = new HashMap<>();
    final PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < n; i++) {
      String s = br.readLine();
      str_cnt.put(s, str_cnt.getOrDefault(s, 0) + 1);
      int cnt = str_cnt.get(s) - 1;
      if (cnt == 0) {
        pw.println(s);
      } else {
        StringBuilder sb = new StringBuilder();
        sb.append(s).append("(").append(cnt).append(")");
        pw.println(sb);
      }
    }
    pw.close();
    br.close();
  }
}
