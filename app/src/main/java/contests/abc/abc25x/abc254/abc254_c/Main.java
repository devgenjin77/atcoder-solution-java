/*
 * AtCoder Beginner Contest 254
 * C - K Swap
 * https://atcoder.jp/contests/abc254/tasks/abc254_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc254/submissions/37699693
 *
 * note:
 *
 *
 */

package contests.abc.abc25x.abc254.abc254_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int k = Integer.parseInt(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    final List<List<Integer>> list_sub = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      list_sub.add(new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
      list_sub.get(i % k).add(array_a[i]);
    }
    for (int i = 0; i < k; i++) {
      Collections.sort(list_sub.get(i));
    }
    boolean isSort = true;
    for (int i = 0; i < n; i++) {
      array_a[i] = list_sub.get(i % k).get(i / k);
      if (i > 0 && array_a[i - 1] > array_a[i]) {
        isSort = false;
        break;
      }
    }
    System.out.println(isSort ? "Yes" : "No");
  }
}
