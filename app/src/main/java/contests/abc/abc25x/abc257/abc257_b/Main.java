/*
 * 日鉄ソリューションズプログラミングコンテスト2022
 * （AtCoder Beginner Contest 257）
 * B - 1D Pawn
 * https://atcoder.jp/contests/abc257/tasks/abc257_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc257/submissions/37612495
 *
 */

package contests.abc.abc25x.abc257.abc257_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final StringTokenizer st = new StringTokenizer(br.readLine());
    final int n = Integer.parseInt(st.nextToken());
    final int k = Integer.parseInt(st.nextToken());
    final int q = Integer.parseInt(st.nextToken());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final StringTokenizer st_q = new StringTokenizer(br.readLine());
    final int[] array_a = new int[k];
    for (int i = 0; i < k; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    for (int i = 0; i < q; i++) {
      int l = Integer.parseInt(st_q.nextToken());
      if (l == k) {
        array_a[l - 1] = Math.min(array_a[l - 1] + 1, n);
      } else {
        if (array_a[l] - array_a[l - 1] > 1) {
          array_a[l - 1]++;
        }
      }
    }
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < k; i++) {
      sb.append(array_a[i]);
      sb.append(' ');
    }
    System.out.println(sb.deleteCharAt(sb.length() - 1));
  }
}