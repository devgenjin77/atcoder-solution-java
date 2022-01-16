/*
 * ABC153
 * B - Common Raccoon vs Monster
 * https://atcoder.jp/contests/abc153/tasks/abc153_b
 *
 * verified:
 * - https://atcoder.jp/contests/abc153/submissions/28577276
 *
 */
package contests.abc.abc153.abc153_b;

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
    StringTokenizer head = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(head.nextToken());
    int n = Integer.parseInt(head.nextToken());
    int sum_a = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
    br.close();
    System.out.println(sum_a >= h ? "Yes" : "No");
    return;
  }
}
