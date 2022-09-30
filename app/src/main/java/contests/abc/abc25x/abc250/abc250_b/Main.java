/*
 * AtCoder Beginner Contest 250
 * B - Enlarged Checker Board
 * https://atcoder.jp/contests/abc250/tasks/abc250_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc250/submissions/35254886
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc250.abc250_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int a = Integer.parseInt(st.nextToken());
    final int b = Integer.parseInt(st.nextToken());
    br.close();
    for (int row = 0; row < a * n; row++) {
      StringBuilder sb = new StringBuilder();
      for (int col = 0; col < b * n; col++) {
        sb.append((row / a) % 2 == (col / b) % 2 ? '.' : '#');
      }
      System.out.println(sb);
    }
  }
}
