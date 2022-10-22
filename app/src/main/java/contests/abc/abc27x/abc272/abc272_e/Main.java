/*
 * AtCoder Beginner Contest 272
 * E - Add and Mex
 * https://atcoder.jp/contests/abc272/tasks/abc272_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc272/submissions/35853018
 *
 * note:
 *
 *
 */

package contests.abc.abc27x.abc272.abc272_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    final List<List<Integer>> list_mth_nums = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      list_mth_nums.add(new ArrayList<>());
    }
    for (int i = 0; i < n; i++) {
      if (array_a[i] > m) {
        continue;
      }
      int mul = array_a[i] < 0 ? (Math.abs(array_a[i]) + i) / (i + 1) : 1;
      while (mul <= m) {
        int ad = array_a[i] + ((i + 1) * mul);
        if (ad >= 0 && ad <= m) {
          list_mth_nums.get(mul - 1).add(ad);
        } else if (ad > m) {
          break;
        }
        mul++;
      }
    }
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < m; i++) {
      List<Integer> list = list_mth_nums.get(i);
      Collections.sort(list);
      int ans = 0;
      for (int a : list) {
        if (ans < a) {
          break;
        } else if (ans == a) {
          ans++;
        }
      }
      pw.println(ans);
    }
    pw.close();
  }
}
