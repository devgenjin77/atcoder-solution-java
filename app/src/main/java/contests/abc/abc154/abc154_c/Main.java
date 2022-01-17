/*
 * ABC154
 * C - Distinct or Not
 * https://atcoder.jp/contests/abc154/tasks/abc154_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc154/submissions/28606585
 *
 */
package contests.abc.abc154.abc154_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    br.close();
    int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st.nextToken());
    }
    boolean ok = true;
    Arrays.sort(array_a);
    for (int i = 1; i < n; i++) {
      if (array_a[i - 1] == array_a[i]) {
        ok = false;
        break;
      }
    }
    System.out.printf(ok ? "YES" : "NO");
    return;
  }
}
