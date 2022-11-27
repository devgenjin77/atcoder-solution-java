/*
 * トヨタシステムズプログラミングコンテスト2022
 * （AtCoder Beginner Contest 279）
 * E - Cheating Amidakuji
 * https://atcoder.jp/contests/abc279/tasks/abc279_e
 *
 * verified:
 * - https://atcoder.jp/contests/abc279/submissions/36844656
 *
 * note:
 *
 */

package contests.abc.abc27x.abc279.abc279_e;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int m = Integer.parseInt(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[m];
    for (int i = 0; i < m; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken()) - 1;
    }
    br.close();
    final int[] array_b = new int[n];
    for (int i = 0; i < n; i++) {
      array_b[i] = i;
    }
    final int[] array_x = new int[m];
    final int[] array_y = new int[m];
    for (int i = 0; i < m; i++) {
      array_x[i] = array_b[array_a[i]];
      array_y[i] = array_b[array_a[i] + 1];
      int temp = array_b[array_a[i]];
      array_b[array_a[i]] = array_b[array_a[i] + 1];
      array_b[array_a[i] + 1] = temp;
    }
    final int[] val_to_idx = new int[n];
    for (int i = 0; i < n; i++) {
      val_to_idx[array_b[i]] = i;
    }
    PrintWriter pw = new PrintWriter(System.out);
    for (int i = 0; i < m; i++) {
      if (array_x[i] == 0) {
        pw.println(val_to_idx[array_y[i]] + 1);
      } else if (array_y[i] == 0) {
        pw.println(val_to_idx[array_x[i]] + 1);
      } else {
        pw.println(val_to_idx[0] + 1);
      }
    }
    pw.close();
  }
}
