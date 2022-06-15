/*
 * AtCoder Beginner Contest 217
 * C - Inverse of Permutation
 * https://atcoder.jp/contests/abc217/tasks/abc217_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc217/submissions/32488629
 *
 */

package contests.abc.abc21x.abc217.abc217_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st_p = new StringTokenizer(br.readLine());
    int[] array_p = new int[n];
    int[] array_q = new int[n];
    for (int i = 0; i < n; i++) {
      array_p[i] = Integer.parseInt(st_p.nextToken()) - 1;
      array_q[array_p[i]] = i;
    }
    br.close();
    StringBuilder sb = new StringBuilder();
    for (int q : array_q) {
      sb.append(q + 1).append(' ');
    }
    System.out.println(sb.deleteCharAt(sb.length() - 1));
  }
}
