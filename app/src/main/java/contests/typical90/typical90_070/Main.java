/*
 * 競プロ典型90問
 * 070 - Plant Planning（★4）
 * https://atcoder.jp/contests/typical90/tasks/typical90_br
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28797578
 *
 */
package contests.typical90.typical90_070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long[] array_x = new long[n];
    long[] array_y = new long[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      array_x[i] = Long.parseLong(st.nextToken());
      array_y[i] = Long.parseLong(st.nextToken());
    }
    br.close();
    Arrays.sort(array_x);
    Arrays.sort(array_y);
    long median_x = array_x[n / 2];
    long median_y = array_y[n / 2];
    long cost_x = 0;
    long cost_y = 0;
    for (int i = 0; i < n; i++) {
      cost_x += Math.abs(array_x[i] - median_x);
      cost_y += Math.abs(array_y[i] - median_y);
    }
    System.out.println(cost_x + cost_y);
  }
}
