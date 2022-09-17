/*
 * AtCoder Beginner Contest 243
 * D - Moves on Binary Tree
 * https://atcoder.jp/contests/abc243/tasks/abc243_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc243/submissions/34909464
 *
 * note:
 *
 */

package contests.abc.abc24x.abc243.abc243_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final long x = Long.parseLong(st.nextToken());
    final String s = br.readLine();
    br.close();
    StringBuilder s_buf = new StringBuilder(Long.toBinaryString(x));
    for (int i = 0; i < n; i++) {
      switch (s.charAt(i)) {
        case 'L':
          s_buf.append('0');
          break;
        case 'R':
          s_buf.append('1');
          break;
        case 'U':
          s_buf.deleteCharAt(s_buf.length() - 1);
          break;
        default:
          break;
      }
    }
    System.out.println(Long.parseLong(s_buf.toString(), 2));
  }
}
