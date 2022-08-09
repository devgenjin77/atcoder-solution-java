/*
 * M-SOLUTIONS プロコンオープン2021
 * （AtCoder Beginner Contest 232）
 * C - Graph Isomorphism
 * https://atcoder.jp/contests/abc232/tasks/abc232_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc232/submissions/33901914
 *
 * note:
 *
 *
 */

package contests.abc.abc23x.abc232.abc232_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final boolean[][] matrix_adj_1 = new boolean[n][n];
    final boolean[][] matrix_adj_2 = new boolean[n][n];
    for (int i = 0; i < m; i++) {
      StringTokenizer st_ab = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st_ab.nextToken()) - 1;
      int b = Integer.parseInt(st_ab.nextToken()) - 1;
      matrix_adj_1[a][b] = true;
      matrix_adj_1[b][a] = true;
    }
    for (int i = 0; i < m; i++) {
      StringTokenizer st_cd = new StringTokenizer(br.readLine());
      int c = Integer.parseInt(st_cd.nextToken()) - 1;
      int d = Integer.parseInt(st_cd.nextToken()) - 1;
      matrix_adj_2[c][d] = true;
      matrix_adj_2[d][c] = true;
    }
    br.close();

    int[] p = new int[n];
    for (int i = 0; i < n; i++) {
      p[i] = i;
    }

    boolean isOk;
    do {
      isOk = true;
      main_loop:
      for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
          if (matrix_adj_1[i][j] != matrix_adj_2[p[i]][p[j]]) {
            isOk = false;
            break main_loop;
          }
        }
      }
    } while (nextPermutation(p) && !isOk);
    System.out.println(isOk ? "Yes" : "No");
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
