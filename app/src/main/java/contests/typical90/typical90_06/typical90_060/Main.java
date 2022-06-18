/*
 * 競プロ典型90問
 * 060 - Chimera（★5）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bh
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/32576801
 *
 * note:
 * -最長増加部分列を両側から取る
 *
 */

package contests.typical90.typical90_06.typical90_060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int n = Integer.parseInt(br.readLine());
    final StringTokenizer st_a = new StringTokenizer(br.readLine());
    final int[] array_a = new int[n];
    for (int i = 0; i < n; i++) {
      array_a[i] = Integer.parseInt(st_a.nextToken());
    }
    br.close();
    //lis1=aを正順で見た時のLIS、lis2=aを逆順で見た時のLIS
    int[] lis1 = new int[n], lis2 = new int[n];
    //dp[i]:=i番目の要素が、0-indexedでLISの何番目にあたるか
    int[] dp1 = new int[n], dp2 = new int[n];
    Arrays.fill(lis1, Integer.MAX_VALUE);
    Arrays.fill(lis2, Integer.MAX_VALUE);
    for (int i = 0; i < n; i++) {
      int idx = Arrays.binarySearch(lis1, array_a[i]);
      if (idx < 0) {
        idx = ~idx;
      }
      lis1[idx] = array_a[i];
      dp1[i] = idx;
    }
    for (int i = n - 1; i >= 0; i--) {
      int idx = Arrays.binarySearch(lis2, array_a[i]);
      if (idx < 0) {
        idx = ~idx;
      }
      lis2[idx] = array_a[i];
      dp2[i] = idx;
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans = Math.max(dp1[i] + dp2[i] + 1, ans);
    }
    System.out.println(ans);
  }
}
