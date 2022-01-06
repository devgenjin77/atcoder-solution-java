/*
 * 競プロ典型90問
 * 048 - I will not drop out（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_av
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/28352710
 *
 */
package contests.typical90.typical90_048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] nk = br.readLine().split(" ");
    int n = Integer.parseInt(nk[0]);
    int k = Integer.parseInt(nk[1]);
    int n2 = n * 2;
    int[] point_array = new int[n2];
    for (int i = 0; i < n; i++) {
      String[] ab = br.readLine().split(" ");
      int a = Integer.parseInt(ab[0]);
      int b = Integer.parseInt(ab[1]);
      //部分点
      point_array[i] = b;
      //満点−部分点
      point_array[i + n] = a - b;
    }
    br.close();
    Arrays.sort(point_array);
    long ans = 0;
    for (int cnt = 1; cnt <= k; cnt++) {
      ans += point_array[n2 - cnt];
    }
    System.out.println(ans);
    return;
  }
}
