/*
 * ABC243
 * D - Moves on Binary Tree
 * https://atcoder.jp/contests/abc243/tasks/abc243_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc243/submissions/30110860
 *
 */
package contests.abc.abc243.abc243_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nx = br.readLine().split(" ");
    int n = Integer.parseInt(nx[0]);
    long x = Long.parseLong(nx[1]);
    String s = br.readLine();
    br.close();
    StringBuilder sb = new StringBuilder(Long.toBinaryString(x));
    for (int i = 0; i < n; i++) {
      char d = s.charAt(i);
      if (d == 'U') {
        sb.deleteCharAt(sb.length() - 1);
      } else if (d == 'L') {
        sb.append('0');
      } else if (d == 'R') {
        sb.append('1');
      }
    }
    System.out.println(Long.parseLong(sb.toString(), 2));
  }
}
