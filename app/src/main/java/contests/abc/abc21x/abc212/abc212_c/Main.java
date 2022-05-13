/*
 * ABC212
 * C - Min Difference
 * https://atcoder.jp/contests/abc212/tasks/abc212_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc212/submissions/31641252
 */

package contests.abc.abc21x.abc212.abc212_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringTokenizer st_a = new StringTokenizer(br.readLine());
    StringTokenizer st_b = new StringTokenizer(br.readLine());
    br.close();
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] array_a = new int[n];
    int[] array_b = new int[m];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    for (int i = 0; i < m; i++) {
      array_b[i] = Integer.parseInt(st_b.nextToken());
    }
    int ans = Integer.MAX_VALUE;
    Arrays.sort(array_a);
    for (int i = 0; i < m; i++) {
      int b = Arrays.binarySearch(array_a, array_b[i]);
      if (b >= 0) {
        ans = 0;
        break;
      } else {
        int idx_ins = ~b;
        if (idx_ins < n) {
          ans = Math.min(Math.abs(array_a[idx_ins] - array_b[i]), ans);
        }
        if (idx_ins > 0) {
          ans = Math.min(Math.abs(array_a[idx_ins - 1] - array_b[i]), ans);
        }
      }
    }
    System.out.println(ans);
  }
}
