/*
 * ABC250
 * B - Enlarged Checker Board
 * https://atcoder.jp/contests/abc250/tasks/abc250_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc250/submissions/31571672
 *
 */

package contests.abc.abc250.abc250_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    int n = Integer.parseInt(st.nextToken());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < a * n; i++) {
      StringBuilder sb = new StringBuilder(b * n);
      for (int j = 0; j < b * n; j++) {
        if (((i / a) + (j / b)) % 2 == 0) {
          sb.append('.');
        } else {
          sb.append('#');
        }
      }
      System.out.println(sb);
    }
  }
}
