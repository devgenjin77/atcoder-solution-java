/*
 * 競プロ典型90問
 * 076 - Cake Cut（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_bx
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28436807
 *
 */
package contests.typical90.typical90_076;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[] cumulative_sum = new long[2 * n];
    StringTokenizer array = new StringTokenizer(br.readLine());
    br.close();

    for (int i = 1; i <= n; i++) {
      cumulative_sum[i] = Long.parseLong(array.nextToken());
      cumulative_sum[i] += cumulative_sum[i - 1];
    }
    for(int i = 1; i < n; i++){
      cumulative_sum[n + i] = cumulative_sum[n] + cumulative_sum[i];
    }

    boolean ok = false;
    long onetenth = cumulative_sum[n] / 10;
    int left = 0, right = 1;
    while (left < n) {
      if(left == right) {
        right++;
      }
      long area = cumulative_sum[right] - cumulative_sum[left];
      if (area > onetenth) {
        left++;
      } else if (area < onetenth) {
        right++;
      } else {
        ok = true;
        break;
      }
    }
    System.out.println(ok ? "Yes" : "No");
  }
}
