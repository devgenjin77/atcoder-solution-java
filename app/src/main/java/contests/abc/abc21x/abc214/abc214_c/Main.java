/*
 * AtCoder Beginner Contest 214
 * C - Distribution
 * https://atcoder.jp/contests/abc214/tasks/abc214_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc214/submissions/37731353
 *
 * note:
 *
 *
 */

package contests.abc.abc21x.abc214.abc214_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_s = new StringTokenizer(br.readLine());
    final StringTokenizer st_t = new StringTokenizer(br.readLine());
    final long[] array_s = new long[n];
    final long[] array_t = new long[n];
    for (int i = 0; i < n; i++) {
      array_s[i] = Long.parseLong(st_s.nextToken());
      array_t[i] = Long.parseLong(st_t.nextToken());
    }
    br.close();
    for (int k = 0; k < 2; k++) {
      for (int i = 0; i < n; i++) {
        int prev_idx = (n + i - 1) % n;
        array_t[i] = Math.min(array_t[prev_idx] + array_s[prev_idx], array_t[i]);
      }
    }
    final PrintWriter pw = new PrintWriter(System.out);
    for (long t : array_t) {
      pw.println(t);
    }
    pw.close();
  }
}
