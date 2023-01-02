/*
 * AtCoder Beginner Contest 254
 * B - Practical Computing
 * https://atcoder.jp/contests/abc254/tasks/abc254_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc254/submissions/37698135
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc254.abc254_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    br.close();
    final int[][] array = new int[n][n];
    array[0][0] = 1;
    for (int i = 1; i < n; i++) {
      array[i][0] = 1;
      for (int j = 1; j < i + 1; j++) {
        array[i][j] = array[i - 1][j - 1] + array[i - 1][j];
      }
    }
    final PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < n; i++) {
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < i + 1; j++) {
        sb.append(array[i][j]).append(' ');
      }
      pw.println(sb.deleteCharAt(sb.length() - 1));
    }
    pw.close();
  }
}
