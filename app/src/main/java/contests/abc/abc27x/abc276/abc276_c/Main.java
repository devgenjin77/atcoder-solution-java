/*
 * AtCoder Beginner Contest 276
 * C - Previous Permutation
 * https://atcoder.jp/contests/abc276/tasks/abc276_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc276/submissions/36288632
 *
 * note:
 *
 *
 */

package contests.abc.abc27x.abc276.abc276_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_p = new StringTokenizer(br.readLine());
    final int[] array_p = new int[n];
    for (int i = 0; i < n; i++) {
      array_p[i] = Integer.parseInt(st_p.nextToken());
    }
    br.close();
    prevPermutation(array_p);
    StringBuilder sb = new StringBuilder();
    for (int p : array_p) {
      sb.append(p).append(' ');
    }
    System.out.println(sb.deleteCharAt(sb.length() - 1));
  }

  static boolean prevPermutation(int[] array) {
    return permutation(array, false);
  }

  static boolean nextPermutation(int[] array) {
    return permutation(array, true);
  }

  static boolean permutation(int[] array, boolean asc) {
    int m = asc ? 1 : -1;
    int idx1 = array.length - 1;
    while (idx1 > 0 && array[idx1 - 1] * m >= array[idx1] * m) {
      idx1--;
    }
    if (idx1 <= 0) {
      return false;
    }
    int idx2 = array.length - 1;
    while (array[idx2] * m <= array[idx1 - 1] * m) {
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
