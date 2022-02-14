/*
 * ARC135
 * B - Sum of Three Terms
 * https://atcoder.jp/contests/arc135/tasks/arc135_b
 *
 * verified:
 * - https://atcoder.jp/contests/arc135/submissions/29341082
 *
 */
package contests.arc.arc135.arc135_b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[] array_s = new long[n];
    String[] inuput_s = br.readLine().split(" ");
    for(int i = 0; i < n; i++){
      array_s[i] = Long.parseLong(inuput_s[i]);
    }
    br.close();

    long[] ans = new long[n + 2];
    long[] diff_a = new long[n + 2];

    ans[0] = array_s[0];
    // A1,A2,A3がそれぞれ取りうる最大の数
    long[] max_a123 = new long[3];
    for (int idx_s = 1; idx_s < n; idx_s++) {
      int idx_a = idx_s + 2;
      diff_a[idx_a] = diff_a[idx_a - 3] + (array_s[idx_s] - array_s[idx_s - 1]);
      max_a123[idx_a % 3] = Math.max(diff_a[idx_a] * -1, max_a123[idx_a % 3]);
    }
    if (max_a123[0] + max_a123[1] + max_a123[2] > array_s[0]) {
      System.out.println("No");
    } else {
      ans[0] = max_a123[0];
      ans[1] = max_a123[1];
      ans[2] = array_s[0] - ans[0] - ans[1];
      for (int idx_a = 3; idx_a < n + 2; idx_a++) {
        ans[idx_a] = ans[idx_a % 3] + diff_a[idx_a];
      }
      System.out.println("Yes");
      StringBuilder sb = new StringBuilder();
      sb.append(ans[0]);
      for(int i = 1; i < n + 2; i++){
        sb.append(" ").append(ans[i]);
      }
      System.out.println(sb.toString());
    }
  }
}
