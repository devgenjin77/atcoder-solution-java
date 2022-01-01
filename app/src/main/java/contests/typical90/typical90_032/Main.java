/*
 * 競プロ典型90問
 * 032 - AtCoder Ekiden（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_af
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28281507
 *
 */
package contests.typical90.typical90_032;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[][] array_a = new int[n][n];
    boolean[][] disable_pairs = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      String[] input_a = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        array_a[i][j] = Integer.parseInt(input_a[j]);
      }
    }
    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      String[] xy = br.readLine().split(" ");
      int xi = Integer.parseInt(xy[0]) - 1;
      int yi = Integer.parseInt(xy[1]) - 1;
      disable_pairs[xi][yi] = true;
      disable_pairs[yi][xi] = true;
    }
    br.close();

    int[] p = new int[n];
    for (int i = 0; i < n; i++) {
      p[i] = i;
    }
    int ans = Integer.MAX_VALUE;
    do {
      boolean canFinish = true;
      for (int i = 1; i < n; i++) {
        //完走できるかチェック
        if (disable_pairs[p[i - 1]][p[i]]) {
          canFinish = false;
          break;
        }
      }
      if (!canFinish) {
        continue;
      }
      int sub_ans = 0;
      for (int stage = 0; stage < n; stage++) {
        sub_ans += array_a[p[stage]][stage];
      }
      ans = Math.min(sub_ans, ans);
    } while (nextPermutation(p));
    System.out.println(ans != Integer.MAX_VALUE ? ans : -1);
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
