/*
 * 競プロ典型90問
 * 014 - We Used to Sing a Song Together（★3）
 * https://atcoder.jp/contests/typical90/tasks/typical90_n
 *
 * verified:
 * - https://atcoder.jp/contests/typical90/submissions/27941932
 *
 */
package contests.typical90.typical90_014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] array_a = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int[] array_b = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    br.close();
    Arrays.sort(array_a);
    Arrays.sort(array_b);
    long ans = 0;
    for (int i = 0; i < n; i++) {
      ans += Math.abs(array_a[i] - array_b[i]);
    }
    System.out.println(ans);
  }
}
