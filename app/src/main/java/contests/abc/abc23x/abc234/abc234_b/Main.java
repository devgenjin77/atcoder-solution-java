/*
 * AtCoder Beginner Contest 234
 * B - Longest Segment
 * https://atcoder.jp/contests/abc234/tasks/abc234_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc234/submissions/33914250
 *
 * note:
 * 二点間の距離を全探索
 */

package contests.abc.abc23x.abc234.abc234_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final int[] pt_x = new int[n], pt_y = new int[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer xy = new StringTokenizer(br.readLine());
      pt_x[i] = Integer.parseInt(xy.nextToken());
      pt_y[i] = Integer.parseInt(xy.nextToken());
    }
    br.close();
    int ans2 = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int diff_x = pt_x[i] - pt_x[j];
        int diff_y = pt_y[i] - pt_y[j];
        ans2 = Math.max((diff_x * diff_x) + (diff_y * diff_y), ans2);
      }
    }
    System.out.println(Math.sqrt(ans2));
  }
}
