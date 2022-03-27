/*
 * ABC245
 * D - Polynomial division
 * https://atcoder.jp/contests/abc245/tasks/abc245_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc245/submissions/30508654
 *
 */

package contests.abc.abc245.abc245_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);
    String[] input_a = br.readLine().split(" ");
    String[] input_c = br.readLine().split(" ");
    br.close();
    int[] array_a = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      array_a[i] = Integer.parseInt(input_a[i]);
    }
    int[] array_c = new int[n + m + 1];
    for (int i = 0; i <= n + m; i++) {
      array_c[i] = Integer.parseInt(input_c[i]);
    }
    int[] array_b = new int[m + 1];
    for(int idx_b = m; idx_b >= 0; idx_b--) {
      array_b[idx_b] = array_c[n + idx_b] / array_a[n];
      for(int idx_a = 0; idx_a <= n; idx_a++) {
        array_c[idx_a + idx_b] -= array_a[idx_a] * array_b[idx_b];
      }
    }
    StringBuilder sb = new StringBuilder();
    sb.append(array_b[0]);
    for (int i = 1; i <= m; i++) {
      sb.append(" " + array_b[i]);
    }
    System.out.println(sb.toString());
  }
}
