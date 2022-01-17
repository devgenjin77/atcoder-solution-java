/*
 * ABC154
 * D - Dice in Line
 * https://atcoder.jp/contests/abc154/tasks/abc154_d
 *
 * verified:
 * - https://atcoder.jp/contests/abc154/submissions/28607892
 *
 */
package contests.abc.abc154.abc154_d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    StringTokenizer kn = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(kn.nextToken());
    int k = Integer.parseInt(kn.nextToken());
    int[] array_p = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    br.close();
    double[] array_sum = new double[n];
    array_sum[0] = (array_p[0] + 1.0) / 2.0;
    for (int i = 1; i < n; i++) {
      array_sum[i] = array_sum[i - 1] + ((array_p[i] + 1.0) / 2.0);
    }
    double ans = array_sum[k - 1];
    for (int i = k; i < n; i++) {
      ans = Math.max(array_sum[i] - array_sum[i - k], ans);
    }
    System.out.println(ans);
    return;
  }
}
