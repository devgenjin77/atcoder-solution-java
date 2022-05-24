/*
 * 競プロ典型90問
 * 032 - AtCoder Ekiden（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_af
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/31928218
 *
 * note:
 * - 順列を生成する
 *
 */

package contests.typical90.typical90_04.typical90_032;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] array_a = new int[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st_a = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        array_a[i][j] = Integer.parseInt(st_a.nextToken());
      }
    }
    int m = Integer.parseInt(br.readLine());
    boolean[][] isNG = new boolean[n][n];
    for (int i = 0; i < m; i++) {
      StringTokenizer st_x = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st_x.nextToken()) - 1;
      int y = Integer.parseInt(st_x.nextToken()) - 1;
      isNG[x][y] = isNG[y][x] = true;
    }
    br.close();
    int[] array_p = new int[n];
    for (int i = 0; i < n; i++) {
      array_p[i] = i;
    }
    int ans = Integer.MAX_VALUE;
    do {
      boolean isOk = true;
      for (int i = 0; i < n - 1; i++) {
        if (isNG[array_p[i]][array_p[i + 1]] || isNG[array_p[i + 1]][array_p[i]]) {
          isOk = false;
          break;
        }
      }
      if (!isOk) {
        continue;
      }
      int ans_sub = 0;
      for (int i = 0; i < n; i++) {
        ans_sub += array_a[array_p[i]][i];
      }
      ans = Math.min(ans_sub, ans);
    } while (nextPermutation(array_p));
    System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
  }

  static boolean nextPermutation(int[] array) {
    int idx1 = array.length - 1;
    while (idx1 > 0 && array[idx1 - 1] >= array[idx1]) {
      idx1--;
    }
    if (idx1 <= 0) {
      return false;
    }
    int idx2 = array.length - 1;
    while (array[idx2] <= array[idx1 - 1]) {
      idx2--;
    }

    int temp = array[idx1 - 1];
    array[idx1 - 1] = array[idx2];
    array[idx2] = temp;

    idx2 = array.length - 1;
    while (idx1 < idx2) {
      temp = array[idx1];
      array[idx1] = array[idx2];
      array[idx2] = temp;
      idx1++;
      idx2--;
    }
    return true;
  }
}
