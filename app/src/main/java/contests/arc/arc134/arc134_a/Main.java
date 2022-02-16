/*
 * ARC134
 * A - Bridge and Sheets
 * https://atcoder.jp/contests/arc134/tasks/arc134_a
 *
 * verified:
 * - https://atcoder.jp/contests/arc134/submissions/29375428
 *
 */
package contests.arc.arc134.arc134_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] head = br.readLine().split(" ");
    int n = Integer.parseInt(head[0]);
    long l = Long.parseLong(head[1]);
    long w = Long.parseLong(head[2]);
    long[] array_a = new long[n + 1];
    String[] input_a = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      array_a[i] = Long.parseLong(input_a[i]);
    }
    array_a[n] = l;
    br.close();

    long covered = 0;
    long ans = 0;
    for (int i = 0; i < n + 1; i++) {
      if (array_a[i] > covered) {
        ans += (array_a[i] - covered + w - 1) / w;
      }
      covered = array_a[i] + w;
    }
    System.out.println(ans);
  }
}
