/*
 * ABC153
 * C - Fennec vs Monster
 * https://atcoder.jp/contests/abc153/tasks/abc153_c
 *
 * verified:
 * - https://atcoder.jp/contests/abc153/submissions/28578022
 *
 */
package contests.abc.abc153.abc153_c;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(
        new InputStreamReader(System.in, StandardCharsets.UTF_8));
    StringTokenizer head = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(head.nextToken());
    int k = Integer.parseInt(head.nextToken());
    long[] array_h = Stream.of(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
    br.close();
    Arrays.sort(array_h);
    long ans = 0;
    for (int i = 0; i < n - k; i++) {
      ans += array_h[i];
    }
    System.out.println(ans);
    return;
  }
}
