/*
 * ABC232
 * C - Graph Isomorphism
 * https://atcoder.jp/contests/abc232/tasks/abc232_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc232/submissions/28102946
 */
package contests.abc.abc232.abc232_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nm = br.readLine().split(" ");
    int n = Integer.parseInt(nm[0]);
    int m = Integer.parseInt(nm[1]);
    int[][] edge_a = new int[n][n];
    int[][] edge_b = new int[n][n];
    for (int i = 0; i < m; i++) {
      String[] ab = br.readLine().split(" ");
      int a = Integer.parseInt(ab[0]) - 1;
      int b = Integer.parseInt(ab[1]) - 1;
      edge_a[a][b] = 1;
      edge_a[b][a] = 1;
    }
    for (int i = 0; i < m; i++) {
      String[] cd = br.readLine().split(" ");
      int c = Integer.parseInt(cd[0]) - 1;
      int d = Integer.parseInt(cd[1]) - 1;
      edge_b[c][d] = 1;
      edge_b[d][c] = 1;
    }
    br.close();
    boolean check_result = false;
    int[] p = new int[n];
    for (int i = 0; i < n; i++) {
      p[i] = i;
    }
    do {
      boolean chk = true;
      main_loop:
      for (int node_a = 0; node_a < n - 1; node_a++) {
        for (int node_b = node_a + 1; node_b < n; node_b++) {
          if (edge_a[node_a][node_b] != edge_b[p[node_a]][p[node_b]]) {
            chk = false;
            break main_loop;
          }
        }
      }
      if (chk) {
        check_result = true;
        break;
      }
    } while (nextPermutation(p));
    System.out.println(check_result ? "Yes" : "No");
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
