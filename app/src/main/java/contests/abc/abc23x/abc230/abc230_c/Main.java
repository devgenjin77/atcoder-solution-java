/*
 * AtCoder Beginner Contest 230
 * C - X drawing
 * https://atcoder.jp/contests/abc230/tasks/abc230_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc230/submissions/33886561
 *
 * note:
 *
 *
 */

package contests.abc.abc23x.abc230.abc230_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st1 = new StringTokenizer(br.readLine());
    final StringTokenizer st2 = new StringTokenizer(br.readLine());
    final long n = Long.parseLong(st1.nextToken());
    final long a = Long.parseLong(st1.nextToken()) - 1;
    final long b = Long.parseLong(st1.nextToken()) - 1;
    final long p = Long.parseLong(st2.nextToken()) - 1;
    final long q = Long.parseLong(st2.nextToken()) - 1;
    final long r = Long.parseLong(st2.nextToken()) - 1;
    final long s = Long.parseLong(st2.nextToken()) - 1;
    br.close();

    int height = (int) (q - p + 1);
    int width = (int) (s - r + 1);
    char[] buf = new char[width];
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        long pos_i = p + i;
        long pos_j = r + j;
        buf[j] = Math.abs(pos_i - a) == Math.abs(pos_j - b) ? '#' : '.';

      }
      pw.println(buf);
    }
    pw.close();
  }
}
