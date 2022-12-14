/*
 * AtCoder Beginner Contest 281
 * F - Xor Minimization
 * https://atcoder.jp/contests/abc281/tasks/abc281_f
 *
 * verified:
 * - https://atcoder.jp/contests/abc281/submissions/37272002
 *
 * note:
 *
 *
 */

package contests.abc.abc28x.abc281.abc281_f;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    Arrays.sort(array_a);
    System.out.println(dfs(array_a, 0, n, 29));
  }

  static int dfs(int[] array, int from, int to, int d) {
    if (d < 0) {
      return 0;
    }
    if (((array[from] ^ array[to - 1]) >> d & 1) == 0) {
      return dfs(array, from, to, d - 1);
    } else {
      int idx = Arrays.binarySearch(array, from, to, array[to - 1] >> d << d);
      if (idx < 0) {
        idx = ~idx;
      }
      return Math.min(dfs(array, from, idx, d - 1), dfs(array, idx, to, d - 1)) | (1 << d);
    }
  }
}
